package com.app.quantitymeasurement.unit;

public enum LengthUnit implements IMeasurable {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double factor;

    LengthUnit(double factor){
        this.factor = factor;
    }

    public double convertToBaseUnit(double value){
        return value * factor;
    }

    public double convertFromBaseUnit(double baseValue){
        return baseValue / factor;
    }

    public String getUnitName(){
        return name();
    }

    public boolean supportsArithmetic(){
        return true;
    }
}