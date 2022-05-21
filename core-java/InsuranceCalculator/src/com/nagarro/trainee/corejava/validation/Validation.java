package com.nagarro.trainee.corejava.validation;



import java.io.*;

import com.nagarro.trainee.corejava.model.*;
import com.nagarro.trainee.corejava.constants.*;

public class Validation extends CarConstants {

	public static boolean validateCarType(int i)  {

		if (i == 1) {
			CarModel.carType =HATCHBACK;
		} else if (i == 2) {
			CarModel.carType =SEDAN;
		} else if (i == 3) {
			CarModel.carType =SUV;
		} else {
			return false;
		}

		return true;
	}

	public static boolean validateInsuranceType(int i) {
		if (i == 1) {
			CarModel.insuranceType =BASIC;
		} else if (i == 2) {
			CarModel.insuranceType =PREMIUM;
		} else {
			return false;
		}
		return true;

	}

	public static boolean validateNewEnrty(char c) {
		char bool = Character.toLowerCase(c);
		if (Character.compare(bool, 'n') == 0) {
			return true;
		}
		return false;
	}
}