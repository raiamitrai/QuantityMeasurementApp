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

    //add operations
    public Quantity<U> add(Quantity<U> other) {

        validateArithmeticOperands(other, unit, true);

        double resultBase = performBaseArithmetic(other, ArithmeticOperation.ADD);

        double result = unit.convertFromBaseUnit(resultBase);

        return new Quantity<>(result, unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        validateArithmeticOperands(other, targetUnit, true);

        double resultBase = performBaseArithmetic(other, ArithmeticOperation.ADD);

        double result = targetUnit.convertFromBaseUnit(resultBase);

        return new Quantity<>(result, targetUnit);
    }
    
    //subtract operations
    public Quantity<U> subtract(Quantity<U> other) {

        validateArithmeticOperands(other, unit, true);

        double resultBase = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);

        double result = unit.convertFromBaseUnit(resultBase);

        return new Quantity<>(result, unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        validateArithmeticOperands(other, targetUnit, true);

        double resultBase = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);

        double result = targetUnit.convertFromBaseUnit(resultBase);

        return new Quantity<>(result, targetUnit);
    }

    //divide operations
    public double divide(Quantity<U> other) {

        validateArithmeticOperands(other, null, false);

        return performBaseArithmetic(other, ArithmeticOperation.DIVIDE);
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

//    function perform arithmetic operations
    private double performBaseArithmetic(Quantity<U> other, ArithmeticOperation operation) {

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        return operation.compute(thisBase, otherBase);
    }

//    input validation
    private void validateArithmeticOperands(Quantity<U> other, U targetUnit, boolean targetUnitRequired) {

        if (other == null)
            throw new IllegalArgumentException("Other quantity cannot be null");

        if (this.unit == null || other.unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cannot operate on different measurement categories");

        if (!Double.isFinite(this.value) || !Double.isFinite(other.value))
            throw new IllegalArgumentException("Values must be finite numbers");

        if (targetUnitRequired && targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");
    }

    //arithmetic operations enum
    private enum ArithmeticOperation {

        ADD {
            @Override
            public double compute(double thisBase, double otherBase) {
                return thisBase + otherBase;
            }
        },

        SUBTRACT {
            @Override
            public double compute(double thisBase, double otherBase) {
                return thisBase - otherBase;
            }
        },

        DIVIDE {
            @Override
            public double compute(double thisBase, double otherBase) {
                if (otherBase == 0.0)
                    throw new ArithmeticException("Cannot divide by zero");
                return thisBase / otherBase;
            }
        };

        public abstract double compute(double thisBase, double otherBase);
    }


    @Override
    public int hashCode() {
        long rounded = Math.round(unit.convertToBaseUnit(value) * 1000);
        return Objects.hash(rounded);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Quantity<?> other = (Quantity<?>) obj;

        double a = unit.convertToBaseUnit(value);
        double b = other.unit.convertToBaseUnit(other.value);

        return Math.abs(a - b) < 0.0001;
    }
}