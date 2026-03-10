package com.QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WeightTest {

    @Test
    public void kilogramEquals1000Grams() {
        Weight kg = new Weight(1, WeightUnit.KILOGRAMS);
        Weight g = new Weight(1000, WeightUnit.GRAMS);
        assertEquals(kg, g);
    }

    @Test
    public void poundEquals453Point592Grams() {
        Weight pound = new Weight(1, WeightUnit.POUNDS);
        Weight grams = new Weight(453.592, WeightUnit.GRAMS);
        assertEquals(pound, grams);
    }

    @Test
    public void tonneEquals1000000Grams() {
        // if TONNE not defined, simulate via kilograms
        Weight kg = new Weight(1000, WeightUnit.KILOGRAMS);
        Weight grams = new Weight(1_000_000, WeightUnit.GRAMS);
        assertEquals(kg, grams);
    }

    @Test
    public void kilogramNotEqualToPound() {
        Weight kg = new Weight(1, WeightUnit.KILOGRAMS);
        Weight pound = new Weight(1, WeightUnit.POUNDS);
        assertNotEquals(kg, pound);
    }

    @Test
    public void additionOfWeightsEqualsExpected() {
        Weight w1 = new Weight(1, WeightUnit.KILOGRAMS);
        Weight w2 = new Weight(500, WeightUnit.GRAMS);

        Weight result = Weight.sum(w1, w2);

        assertEquals(new Weight(1.5, WeightUnit.KILOGRAMS), result);
    }

    @Test
    public void additionWithTargetUnit() {
        Weight w1 = new Weight(1, WeightUnit.KILOGRAMS);
        Weight w2 = new Weight(500, WeightUnit.GRAMS);

        Weight result = Weight.sum(w1, w2, WeightUnit.GRAMS);

        assertEquals(new Weight(1500, WeightUnit.GRAMS), result);
    }

    @Test
    public void sum_FirstWeightNull_ShouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> {
            Weight.sum(null, new Weight(1, WeightUnit.KILOGRAMS));
        });
    }

    @Test
    public void sum_SecondWeightNull_ShouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> {
            Weight.sum(new Weight(1, WeightUnit.KILOGRAMS), null);
        });
    }

    @Test
    public void equalityAfterConversion() {
        Weight w1 = new Weight(2.2, WeightUnit.POUNDS);
        Weight w2 = new Weight(1, WeightUnit.KILOGRAMS);
        assertEquals(w1, w2);
    }

    @Test
    public void inequalityDifferentValues() {
        Weight w1 = new Weight(2, WeightUnit.KILOGRAMS);
        Weight w2 = new Weight(2, WeightUnit.POUNDS);
        assertNotEquals(w1, w2);
    }
}
