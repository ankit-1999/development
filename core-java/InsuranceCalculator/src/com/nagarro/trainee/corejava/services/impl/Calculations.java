package com.nagarro.trainee.corejava.services.impl;

import com.nagarro.trainee.corejava.constants.*;
import com.nagarro.trainee.corejava.services.CostCalculation;


public class Calculations implements CostCalculation{
	@Override
	public double calculateInsurance(double costPrice, String carType) {
		if (carType.toLowerCase().equals(CarConstants.HATCHBACK)) {
			return (CarConstants.HATCHBACH_INSURANCE * costPrice) / 100;
		} else if (carType.toLowerCase().equals(CarConstants.SEDAN)) {
			return (CarConstants.SEDAN_INSURANCE * costPrice) / 100;
		} else {
			return (CarConstants.SUV_INSURANCE * costPrice) / 100;
		}

	}

	@Override
	public double calculatePremium(double insurance, String insuranceType) {
		if (insuranceType.toLowerCase().equals(CarConstants.PREMIUM)) {
			return (insurance + (insurance * CarConstants.PREMIUM_INSURANCE) / 100);
		} else {
			return (insurance + (insurance * CarConstants.BASIC_INSURANCE) / 100);
		}

	}

}
