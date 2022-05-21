package com.nagarro.trainee.corejava.model;

public class CarModel {

	public static String carModel;
	public static String carType;
	public static double carCost;
	public static String insuranceType;

	public String outputCarModel() {
		return (carModel.toUpperCase());
	}

	public String outputInsuranceType() {
		return (insuranceType.toUpperCase());
	}

	public String outputCarType() {
		return (carType.toUpperCase());
	}

	public double outputCarCost() {
		return (carCost);
	}

}