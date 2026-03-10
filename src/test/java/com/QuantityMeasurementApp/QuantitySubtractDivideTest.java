package com.QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuantitySubtractDivideTest {

    @Test
    public void subtractVolumeLitersAndMilliliters() {
        Quantity<VolumeUnit> q1 = new Quantity<>(2, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(500, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = q1.subtract(q2);

        assertEquals(1.5, result.getValue());
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    public void subtractVolumeLitersAndMillilitersInTargetUnit() {
        Quantity<VolumeUnit> q1 = new Quantity<>(2, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(500, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = q1.subtract(q2, VolumeUnit.MILLILITRE);

        assertEquals(1500, result.getValue());
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
    }

    @Test
    public void subtractWeightKilogramsAndGrams() {
        Quantity<WeightUnit> q1 = new Quantity<>(2, WeightUnit.KILOGRAMS);
        Quantity<WeightUnit> q2 = new Quantity<>(500, WeightUnit.GRAMS);

        Quantity<WeightUnit> result = q1.subtract(q2);

        assertEquals(1.5, result.getValue());
        assertEquals(WeightUnit.KILOGRAMS, result.getUnit());
    }

    @Test
    public void subtractWeightKilogramsAndGramsInTargetUnit() {
        Quantity<WeightUnit> q1 = new Quantity<>(2, WeightUnit.KILOGRAMS);
        Quantity<WeightUnit> q2 = new Quantity<>(500, WeightUnit.GRAMS);

        Quantity<WeightUnit> result = q1.subtract(q2, WeightUnit.GRAMS);

        assertEquals(1500, result.getValue());
        assertEquals(WeightUnit.GRAMS, result.getUnit());
    }

    @Test
    public void preventSubtractNullQuantity() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1, VolumeUnit.LITRE);

        assertThrows(IllegalArgumentException.class, () -> q1.subtract(null));
    }

    @Test
    public void divideVolumeLitersByMilliliters() {
        Quantity<VolumeUnit> q1 = new Quantity<>(2, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(500, VolumeUnit.MILLILITRE);

        double result = q1.divide(q2);

        assertEquals(4.0, result);
    }

    @Test
    public void divideWeightKilogramsByGrams() {
        Quantity<WeightUnit> q1 = new Quantity<>(2, WeightUnit.KILOGRAMS);
        Quantity<WeightUnit> q2 = new Quantity<>(500, WeightUnit.GRAMS);

        double result = q1.divide(q2);

        assertEquals(4.0, result);
    }

    @Test
    public void divideVolumeByScalarInSameUnit() {
        Quantity<VolumeUnit> q = new Quantity<>(2, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = q.divide(2, VolumeUnit.LITRE);

        assertEquals(1.0, result.getValue());
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    public void divideVolumeByScalarInTargetUnit() {
        Quantity<VolumeUnit> q = new Quantity<>(2, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = q.divide(2, VolumeUnit.MILLILITRE);

        assertEquals(1000, result.getValue());
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
    }

    @Test
    public void preventDivideByZeroScalar() {
        Quantity<VolumeUnit> q = new Quantity<>(2, VolumeUnit.LITRE);

        assertThrows(ArithmeticException.class, () -> q.divide(0, VolumeUnit.LITRE));
    }

    @Test
    public void preventDivideByNullQuantity() {
        Quantity<VolumeUnit> q = new Quantity<>(2, VolumeUnit.LITRE);

        assertThrows(IllegalArgumentException.class, () -> q.divide(null));
    }
}
