package com.QuantityMeasurementApp;

public class QuantityMeasurementApp {
	public static void main(String[] args) {
		Weight pound = new Weight(2.2, WeightUnit.POUNDS);
		Weight kilogram = new Weight(1.0, WeightUnit.KILOGRAMS);
		System.out.println(pound.equals(kilogram));
	}
}
