package com.nagarro.trainee.corejava.application;

import java.util.Scanner;

import com.nagarro.trainee.corejava.input.*;
import com.nagarro.trainee.corejava.services.*;
import com.nagarro.trainee.corejava.services.impl.*;
import com.nagarro.trainee.corejava.validation.Validation;

public class Main {

	public static void main(String args[]) {
		Input io = new Input();
		Calculations cl = new Calculations();

		while (true) {
			io.inputCarModel();
			io.inputCarType();
			io.inputInsuranceType();
			io.inputCarCost();
			System.out.println();
			double insurance = cl.calculateInsurance(io.carCost, io.carType);
			System.out.println("Your Car Modal is : " + io.outputCarModel());
			System.out.println("Your Car Price is : " + io.outputCarCost());
			System.out.println("Total Insurance to be Paid is : " + cl.calculatePremium(insurance, io.insuranceType));

			System.out.println();
			System.out.println("Do you want to enter details of any other car. Type ('n') if not else Type ('y') : ");
			char c;
			Scanner sc = new Scanner(System.in);
			c = sc.next().charAt(0);
			if (Validation.validateNewEnrty(c) == true) {
				break;
			}
		}
	}

}
