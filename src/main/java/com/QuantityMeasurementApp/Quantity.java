package com.QuantityMeasurementApp;

import java.util.Objects;

public class Quantity<U extends IMeasureable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() { 
        return value; 
    }

    public U getUnit() { 
        return unit; 
    }

    public double convertTo(U targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double base = unit.convertToBaseUnit(value);
        return targetUnit.convertFromBaseUnit(base);
    }

    // ADD operations
    public Quantity<U> add(Quantity<U> other) {

        if (other == null)
            throw new IllegalArgumentException("Arguments cannot be null");

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        double sumBase = thisBase + otherBase;

        double result = unit.convertFromBaseUnit(sumBase);

        return new Quantity<>(result, unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        if (other == null || targetUnit == null)
            throw new IllegalArgumentException("Arguments cannot be null");

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        double sumBase = thisBase + otherBase;

        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new Quantity<>(result, targetUnit);
    }

    // SUBTRACT operations
    public Quantity<U> subtract(Quantity<U> other) {

        if (other == null)
            throw new IllegalArgumentException("Arguments cannot be null");

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        double diffBase = thisBase - otherBase;

        double result = unit.convertFromBaseUnit(diffBase);

        return new Quantity<>(result, unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        if (other == null || targetUnit == null)
            throw new IllegalArgumentException("Arguments cannot be null");

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        double diffBase = thisBase - otherBase;

        double result = targetUnit.convertFromBaseUnit(diffBase);

        return new Quantity<>(result, targetUnit);
    }

    // DIVIDE operations
    public double divide(Quantity<U> other) {

        if (other == null)
            throw new IllegalArgumentException("Arguments cannot be null");

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        if (otherBase == 0)
            throw new ArithmeticException("Cannot divide by zero");

        return thisBase / otherBase;
    }

    public Quantity<U> divide(double divisor, U targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        if (divisor == 0)
            throw new ArithmeticException("Cannot divide by zero");

        double baseValue = unit.convertToBaseUnit(value);

        double resultBase = baseValue / divisor;

        double result = targetUnit.convertFromBaseUnit(resultBase);

        return new Quantity<>(result, targetUnit);
    }

    @Override
    public int hashCode() {
        long rounded = Math.round(unit.convertToBaseUnit(value) * 1000);
        return Objects.hash(rounded);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Quantity<?> other = (Quantity<?>) obj;

        double a = unit.convertToBaseUnit(value);
        double b = other.unit.convertToBaseUnit(other.value);

        return Math.abs(a - b) < 0.0001;
    }
}