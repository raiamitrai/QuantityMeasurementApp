package com.QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {

    @Test
    public void lengthFeetEqualsInches() {
        Quantity<LengthUnit> feet = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12, LengthUnit.INCHES);
        assertEquals(feet, inches);
    }

    @Test
    public void lengthYardsEqualsFeet() {
        Quantity<LengthUnit> yard = new Quantity<>(1, LengthUnit.YARDS);
        Quantity<LengthUnit> feet = new Quantity<>(3, LengthUnit.FEET);
        assertEquals(yard, feet);
    }

    @Test
    public void weightKilogramEqualsGrams() {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KILOGRAMS);
        Quantity<WeightUnit> grams = new Quantity<>(1000, WeightUnit.GRAMS);
        assertEquals(kg, grams);
    }

    @Test
    public void weightPoundEqualsGrams() {
        Quantity<WeightUnit> pound = new Quantity<>(1, WeightUnit.POUNDS);
        Quantity<WeightUnit> grams = new Quantity<>(453.592, WeightUnit.GRAMS);
        assertEquals(pound, grams);
    }

    @Test
    public void convertLengthFeetToInches() {
        Quantity<LengthUnit> feet = new Quantity<>(1, LengthUnit.FEET);
        double inches = feet.convertTo(LengthUnit.INCHES);
        assertEquals(12, inches, 0.0001);
    }

    @Test
    public void convertLengthYardsToInches() {
        Quantity<LengthUnit> yard = new Quantity<>(1, LengthUnit.YARDS);
        double inches = yard.convertTo(LengthUnit.INCHES);
        assertEquals(36, inches, 0.0001);
    }

    @Test
    public void convertWeightKilogramsToGrams() {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KILOGRAMS);
        double grams = kg.convertTo(WeightUnit.GRAMS);
        assertEquals(1000, grams, 0.0001);
    }

    @Test
    public void addLengthFeetAndInches() {
        Quantity<LengthUnit> feet = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(6, LengthUnit.INCHES);

        Quantity<LengthUnit> result = feet.add(inches);

        assertEquals(new Quantity<>(1.5, LengthUnit.FEET), result);
    }

    @Test
    public void addWeightKilogramsAndGrams() {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KILOGRAMS);
        Quantity<WeightUnit> grams = new Quantity<>(500, WeightUnit.GRAMS);

        Quantity<WeightUnit> result = kg.add(grams);

        assertEquals(new Quantity<>(1.5, WeightUnit.KILOGRAMS), result);
    }

    @Test
    public void addWeightKilogramsAndPounds() {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KILOGRAMS);
        Quantity<WeightUnit> pounds = new Quantity<>(2.20462, WeightUnit.POUNDS);

        Quantity<WeightUnit> result = kg.add(pounds);

        assertEquals(new Quantity<>(2.0, WeightUnit.KILOGRAMS), result);
    }

    @Test
    public void testGenericTypeSafetyWithWeight() {
        Quantity<WeightUnit> w = new Quantity<>(1, WeightUnit.KILOGRAMS);
        assertNotNull(w);
        assertEquals(1, w.getValue());
    }

    @Test
    public void preventCrossTypeComparisonLengthVsWeight() {
        Quantity<LengthUnit> length = new Quantity<>(1, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1, WeightUnit.KILOGRAMS);

        assertNotEquals(length, weight);
    }
}
