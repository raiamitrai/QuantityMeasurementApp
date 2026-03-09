package com.QuantityMeasurementApp;

//Alerady following the standlone class like uc 8 from begining itself
public enum LengthUnit{
	FEET(12.0),
	INCHES(1.0),
	YARDS(36.0),
	CENTIMETERS(0.393701);
	
	private final double conversionFactor;
	
	LengthUnit(double conversionFactor){
		this.conversionFactor = conversionFactor;
	}
	
	public double getConversionFactor() {
		return conversionFactor;
	}
}
