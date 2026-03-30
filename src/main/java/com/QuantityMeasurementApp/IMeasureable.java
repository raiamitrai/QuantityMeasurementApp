package com.QuantityMeasurementApp;

public interface IMeasureable {
	double getConversionFactor();
	double convertToBaseUnit(double value);
	double convertFromBaseUnit(double baseValue);
}
