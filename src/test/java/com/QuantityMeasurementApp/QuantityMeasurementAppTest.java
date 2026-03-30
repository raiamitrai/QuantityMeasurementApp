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

    // ---------------- ADD TESTS ----------------

    @Test
    void testAdd_UC12_BehaviorPreserved() {

        Quantity<LengthUnit> q1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.add(q2);

        assertEquals(2.0, result.getValue(), 0.001);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    // ---------------- SUBTRACT TESTS ----------------

    @Test
    void testSubtract_UC12_BehaviorPreserved() {

        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(9.5, result.getValue(), 0.001);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    // ---------------- DIVIDE TESTS ----------------

    @Test
    void testDivide_UC12_BehaviorPreserved() {

        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2, LengthUnit.FEET);

        double result = q1.divide(q2);

        assertEquals(5.0, result);
    }

    // ---------------- VALIDATION TESTS ----------------

    @Test
    void testValidation_NullOperand_ConsistentAcrossOperations() {

        Quantity<LengthUnit> q = new Quantity<>(10, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> q.add(null));
        assertThrows(IllegalArgumentException.class, () -> q.subtract(null));
        assertThrows(IllegalArgumentException.class, () -> q.divide(null));
    }

    @Test
    void testValidation_CrossCategory_ConsistentAcrossOperations() {

        Quantity<LengthUnit> length = new Quantity<>(10, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(5, WeightUnit.KILOGRAMS);

        assertThrows(IllegalArgumentException.class,
                () -> length.add((Quantity) weight));

        assertThrows(IllegalArgumentException.class,
                () -> length.subtract((Quantity) weight));

        assertThrows(IllegalArgumentException.class,
                () -> length.divide((Quantity) weight));
    }

    // ---------------- IMMUTABILITY TESTS ----------------

    @Test
    void testImmutability_AfterAdd_ViaCentralizedHelper() {

        Quantity<LengthUnit> q1 = new Quantity<>(5, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5, LengthUnit.FEET);

        Quantity<LengthUnit> result = q1.add(q2);

        assertEquals(5, q1.getValue());
        assertEquals(10, result.getValue());
    }

    @Test
    void testImmutability_AfterSubtract_ViaCentralizedHelper() {

        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5, LengthUnit.FEET);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(10, q1.getValue());
        assertEquals(5, result.getValue());
    }

    // ---------------- TARGET UNIT TEST ----------------

    @Test
    void testExplicitTargetUnit_AddSubtract_Overrides() {

        Quantity<LengthUnit> q1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.add(q2, LengthUnit.INCHES);

        assertEquals(24, result.getValue(), 0.001);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }
}
