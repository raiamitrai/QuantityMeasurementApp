package com.QuantityMeasurementApp;

import java.util.Objects;

public class Quantity<U extends IMeasureable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if(unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() { return value; }
    public U getUnit() { return unit; }

    public double convertTo(U targetUnit) {
        double base = unit.convertToBaseUnit(value);
        return base / targetUnit.getConversionFactor();   // ✔ FIXED
    }

    public Quantity<U> add(Quantity<U> other){
        if(other == null) throw new IllegalArgumentException();

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);
        double sum = thisBase + otherBase;

        return new Quantity<>(sum / this.unit.getConversionFactor(), this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit){
        if(other == null) throw new IllegalArgumentException();

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);
        double sum = thisBase + otherBase;

        return new Quantity<>(sum / targetUnit.getConversionFactor(), targetUnit);
    }

    @Override
    public int hashCode() {
        long rounded = Math.round(unit.convertToBaseUnit(value) * 1000);
        return Objects.hashCode(rounded);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Quantity<?> other = (Quantity<?>) obj;

        double a = unit.convertToBaseUnit(value);
        double b = other.unit.convertToBaseUnit(other.value);

        return Math.abs(a - b) < 0.0001;
    }
}