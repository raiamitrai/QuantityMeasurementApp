package com.QuantityMeasurementApp;

public enum WeightUnit {
	KILOGRAMS(1.0),
	GRAMS(0.001),
	POUNDS(0.453592);
	
	private final double conversionFactor;
	
	WeightUnit(double conversionFactor){
		this.conversionFactor = conversionFactor;
	}
	
	public double getConversionFactor() {
		return conversionFactor;
	}
	
	public double convertToBaseUnit(double value) {
		return value*this.getConversionFactor();
	}
	
	public double convertFromBaseUnit(double baseValue) {
		return Math.round((baseValue / this.conversionFactor)*100.0)/100.0;
	}
	
	public static void main(String args[]) {
		double kilo = 10;
		
		System.out.println(WeightUnit.GRAMS.convertToBaseUnit(kilo));
		System.out.println(WeightUnit.POUNDS.convertToBaseUnit(kilo));
	}
}
