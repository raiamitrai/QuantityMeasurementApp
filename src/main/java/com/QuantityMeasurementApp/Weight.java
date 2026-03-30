package com.QuantityMeasurementApp;

import java.util.Objects;

public final class Weight {
	public static Weight sum(Weight weight1, Weight weight2) {
		if(weight1==null || weight2==null)
			throw new IllegalArgumentException("weight cannot be null");
		double w1 = weight1.unit.convertToBaseUnit(weight1.value);
		double w2 = weight2.unit.convertToBaseUnit(weight2.value);
		double sum = w1+w2;
		Weight result = new Weight(weight1.unit.convertFromBaseUnit(sum), weight1.unit);
		return result;
	}
	
	public static Weight sum(Weight weight1, Weight weight2, WeightUnit targetUnit) {
		if(weight1==null || weight2==null || targetUnit==null)
			throw new IllegalArgumentException("weight or its unit cannot be null");
		double w1 = weight1.unit.convertToBaseUnit(weight1.value);
		double w2 = weight2.unit.convertToBaseUnit(weight2.value);
		double sum = w1+w2;
		Weight result = new Weight(targetUnit.convertFromBaseUnit(sum), targetUnit);
		return result;
	}
	
	private final double value;
	private final WeightUnit unit;
	
	public Weight(double value, WeightUnit unit) {
		if(unit ==null)
			throw new IllegalArgumentException("Unit cannot be null");
		
		if(Double.isNaN(value) || Double.isInfinite(value))
			throw new IllegalArgumentException("value should be number");
		
		this.value = value;
		this.unit = unit;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(unit.convertToBaseUnit(value));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weight other = (Weight) obj;
		
		double a = this.unit.convertToBaseUnit(value);
		double b = other.unit.convertToBaseUnit(other.value);
		return Math.abs(a-b)<0.01;
	}

	@Override
	public String toString() {
		return "Weight [value=" + value + ", unit=" + unit + "]";
	}

	public double getValue() {
		return value;
	}

	public WeightUnit getUnit() {
		return unit;
	}	
}
