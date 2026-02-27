package com.QuantityMeasurementApp;

public class Length {
	//unit conversion of value from source unit to target
	public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) throws IllegalArgumentException {
		if(value<0.0)	throw new IllegalArgumentException("Invalid value");
		if(sourceUnit == null || targetUnit==null)	throw new IllegalArgumentException("Unit cannot be null");
			
		return value*sourceUnit.getConversionFactor()/targetUnit.getConversionFactor();
	}
	
	//adding two length and return result in length1 unit
	public static Length sum(Length length1, Length length2) throws IllegalArgumentException{
		if(length1==null || length2==null)
			throw new IllegalArgumentException("null value not allowed");
		
		double l1=length1.value*length1.unit.getConversionFactor();
		double l2=length2.value*length2.unit.getConversionFactor();
		double sum = (l1+l2)/length1.unit.getConversionFactor();
		return new Length(sum, length1.unit);
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
