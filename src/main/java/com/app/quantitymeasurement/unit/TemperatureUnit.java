package com.app.quantitymeasurement.unit;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS{
        public double convertToBaseUnit(double v){
            return v;
        }
        public double convertFromBaseUnit(double b){
            return b;
        }
    },

    FAHRENHEIT{
        public double convertToBaseUnit(double v){
            return (v - 32) * 5.0 / 9.0;
        }
        public double convertFromBaseUnit(double b){
            return (b * 9.0 / 5.0) + 32;
        }
    },

    KELVIN{
        public double convertToBaseUnit(double v){
            return v - 273.15;
        }
        public double convertFromBaseUnit(double b){
            return b + 273.15;
        }
    };

    public String getUnitName(){
        return name();
    }

    public boolean supportsArithmetic(){
        return false;
    }
}