package com.QuantityMeasurementApp;

public enum WeightUnit implements IMeasureable{
	KILOGRAMS(1.0),
	GRAMS(0.001),
	POUNDS(0.453592);
	
	private final double conversionFactor;
	
	WeightUnit(double conversionFactor){
		this.conversionFactor = conversionFactor;
	}
	
	@Override
	public double getConversionFactor() {
		return conversionFactor;
	}
	
	@Override
	public double convertToBaseUnit(double value) {
		return value*this.getConversionFactor();
	}
	
	@Override
	public double convertFromBaseUnit(double baseValue) {
		return Math.round((baseValue / this.conversionFactor)*100.0)/100.0;
	}
}
