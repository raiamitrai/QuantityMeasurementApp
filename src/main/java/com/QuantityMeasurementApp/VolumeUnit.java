package com.QuantityMeasurementApp;

public enum VolumeUnit implements IMeasureable {
    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);

    private final double conversionFactor;
    VolumeUnit(double conversionFactor){
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value*this.conversionFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return Math.round((baseValue/this.conversionFactor)*100.0)/100.0;
    }
}
