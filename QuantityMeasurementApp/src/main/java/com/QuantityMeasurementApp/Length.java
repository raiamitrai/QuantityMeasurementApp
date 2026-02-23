package com.QuantityMeasurementApp;

public class Length {
	public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
		return value*sourceUnit.getConversionFactor()/targetUnit.getConversionFactor();
	}
	
	private final double value;
	private final LengthUnit unit;
	
	public Length(double value, LengthUnit unit) {
		this.value = value;
		this.unit = unit;
	}
	
	private double toBaseUnit() {
        return value * unit.getConversionFactor();
    }

    public boolean compare(Length other) {
        if (other == null) return false;

        double a = this.toBaseUnit();
        double b = other.toBaseUnit();

        return Math.abs(a - b) < 0.0001;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;
        Length other = (Length) obj;
        return compare(other);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(toBaseUnit());
    }
    
    public double convertTo(LengthUnit targetUnit) {
    	return toBaseUnit()/targetUnit.getConversionFactor();
    }
}
