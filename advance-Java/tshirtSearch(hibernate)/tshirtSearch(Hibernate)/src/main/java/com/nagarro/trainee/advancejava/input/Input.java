package com.nagarro.trainee.advancejava.input;

import java.util.Scanner;

import com.nagarro.trainee.advancejava.exception.InvalidInputException;
import com.nagarro.trainee.advancejava.validation.Validation;



public class Input {
	public static String gender;
	public static String size;
	public static String colour;
	public static String outputPreference;

	Scanner sc = new Scanner(System.in);
    
	public void input()
	{
		inputColour();
		inputSize();
		inputGender();
		inputOutputPreference();
		System.out.println();
	}
	
	// input gender of user
	public void inputGender() {
		boolean error = true;
		System.out.println(" Enter your gender (M/F) : ");
		do {
			try {
				// M=Male and F=Female
				String tmp = sc.nextLine().toUpperCase();
				if (Validation.validateGender(tmp) == true) {
					this.gender = tmp;
					error = false;
				}

			} catch (Exception e) {
				System.out.println(" Enter valid gender i.e M=Male and F=Female ");
				sc.nextLine();
			}
		} while (error);

	}

	//input color of T-shirt
	public void inputColour() {
		System.out.println(" Please input color of T-shirts you want : ");
		try {
			String tmp = sc.nextLine();
			this.colour = tmp;
		} catch (Exception e) {
			System.out.println(" Please enter valid T-shirt color ");
		}
	}

	// input size of T-shirt
	public void inputSize() {
		boolean error = true;
		System.out.println(" Enter your T-shirt size i.e { S, M, L, XL, XXL }");
		do {
			try {
				String tmp = sc.nextLine().toUpperCase();
				if (Validation.validateSize(tmp) == true) {
					Input.size = tmp;
					error = false;
				}

			} catch (Exception e) {
				System.out.println(" Please Enter valid T-shirt size i.e { S, M, L, XL, XXL } ");
				sc.nextLine();
			}
		} while (error);
	}
	
	// input output-preferences i.e sorting order of output
	public void inputOutputPreference()
	{
		
		System.out.println(" Enter your Output-Preference i.e : ");
		System.out.println(" 1. Price    2. Rating    3. Price and Rating ");
		while(true){
			int i;
			try {
				i = sc.nextInt();
				if (Validation.validateOutputPreference(i) == true) {
					return;
				}
				throw new InvalidInputException();
			} catch (Exception e) {
				System.out.println(" Please Select Valid Output-Preference i.e : " );
				System.out.println(" 1. Price    2. Rating    3. Price and Rating ");
				sc.nextLine();
			}
		}
	}

}
