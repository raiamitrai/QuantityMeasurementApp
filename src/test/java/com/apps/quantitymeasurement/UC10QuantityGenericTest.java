package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC10QuantityGenericTest {

    @Test
    public void testLengthEquality(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(1 , LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(12 , LengthUnit.INCHES);

        assertEquals(q1 , q2);
    }

    @Test
    public void testWeightEquality(){

        Quantity<WeightUnit> q1 =
                new Quantity<>(1 , WeightUnit.KILOGRAM);

        Quantity<WeightUnit> q2 =
                new Quantity<>(1000 , WeightUnit.GRAM);

        assertEquals(q1 , q2);
    }

    @Test
    public void testCrossCategoryPrevention(){

        Quantity<LengthUnit> l =
                new Quantity<>(1 , LengthUnit.FEET);

        Quantity<WeightUnit> w =
                new Quantity<>(1 , WeightUnit.KILOGRAM);

        assertFalse(l.equals(w));
    }

    @Test
    public void testAddition_Length(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(1 , LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(12 , LengthUnit.INCHES);

        assertEquals(
                new Quantity<>(2 , LengthUnit.FEET),
                q1.add(q2));
    }

    @Test
    public void testAddition_Weight(){

        Quantity<WeightUnit> q1 =
                new Quantity<>(1 , WeightUnit.KILOGRAM);

        Quantity<WeightUnit> q2 =
                new Quantity<>(1000 , WeightUnit.GRAM);

        assertEquals(
                new Quantity<>(2 , WeightUnit.KILOGRAM),
                q1.add(q2));
    }
}