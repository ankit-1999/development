package com.nagarro.trainee.corejava.input;

import java.util.Scanner;

import com.nagarro.trainee.corejava.exception.*;
import com.nagarro.trainee.corejava.model.*;
import com.nagarro.trainee.corejava.validation.*;

public class Input extends CarModel {

	Scanner sc = new Scanner(System.in);

	public void inputCarModel() {
		boolean error = true;
		do {
			try {
				System.out.println("Enter Car Model : ");
				carModel = sc.nextLine();
				error = false;
			} catch (Exception e) {
				System.out.println("Enter valid car model");
				sc.nextLine();
			}
		} while (error);
	}

	public void inputCarType() {
		System.out.println("Select Car Type    1. Hatchback    2. Sedan    3. Suv ");
		while (true) {
			int i;
			try {
				i = sc.nextInt();
				if (Validation.validateCarType(i) == true) {
					return;
				}
				throw new InvalidInputException();
			} catch (Exception e) {
				System.out.println("Please Select Valid Car Type    1. Hatchback    2.Sedan    3. Suv ");
				sc.nextLine();
			}
		}

	}

	public void inputCarCost() {
		System.out.print("Enter Car Cost : ");
		boolean error = true;
		do {
			try {
				carCost = sc.nextDouble();
				sc.nextLine();
				error = false;
			} catch (Exception e) {
				System.out.print("Please Enter Valid Car Cost : ");
				sc.nextLine();
			}
		} while (error);
	}

	public void inputInsuranceType() {
		System.out.println("Select Insurance Type    1. Basic    2. Premium ");
		while (true) {
			try {
				int i = sc.nextInt();
				if (Validation.validateInsuranceType(i) == true) {
					return;
				}
				throw new InvalidInputException();
			} catch (Exception e) {
				System.out.println("Please Select Valide Insurance type    1. Basic    2. Premium ");
				sc.nextLine();
			}
		}

	}
	
}
