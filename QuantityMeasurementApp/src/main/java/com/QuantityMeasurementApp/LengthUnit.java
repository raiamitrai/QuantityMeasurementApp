package com.QuantityMeasurementApp;

//Alerady following the standlone class like uc 8 from begining itself
public enum LengthUnit implements IMeasureable{
	FEET(12.0),
	INCHES(1.0),
	YARDS(36.0),
	CENTIMETERS(0.393701);
	
	private final double conversionFactor;
	
	LengthUnit(double conversionFactor){
		this.conversionFactor = conversionFactor;
	}
	
	@Override
	public double convertToBaseUnit(double value) {
		return value*this.getConversionFactor();
	}
	
	@Override
	public double convertFromBaseUnit(double baseValue) {
		return Math.round((baseValue / this.conversionFactor)*100.0)/100.0;
	}
	
	@Override
	public double getConversionFactor() {
		return conversionFactor;
	}
}
