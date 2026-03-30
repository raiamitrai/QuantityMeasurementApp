package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UC4LengthTest {

    @Test
    public void testYardToYard_SameValue() {

        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(1.0, LengthUnit.YARDS);

        Assertions.assertTrue(l1.equals(l2));
    }

    @Test
    public void testYardToYard_DifferentValue() {

        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(2.0, LengthUnit.YARDS);

        Assertions.assertFalse(l1.equals(l2));
    }

    @Test
    public void testYardToFeet_Equivalent() {

        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(3.0, LengthUnit.FEET);

        Assertions.assertTrue(l1.equals(l2));
    }

    @Test
    public void testFeetToYard_Equivalent() {

        Length l1 = new Length(3.0, LengthUnit.FEET);
        Length l2 = new Length(1.0, LengthUnit.YARDS);

        Assertions.assertTrue(l1.equals(l2));
    }

    @Test
    public void testYardToInches_Equivalent() {

        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(36.0, LengthUnit.INCHES);

        Assertions.assertTrue(l1.equals(l2));
    }

    @Test
    public void testInchesToYard_Equivalent() {

        Length l1 = new Length(36.0, LengthUnit.INCHES);
        Length l2 = new Length(1.0, LengthUnit.YARDS);

        Assertions.assertTrue(l1.equals(l2));
    }

    @Test
    public void testCentimeterToCentimeter() {

        Length l1 = new Length(2.0, LengthUnit.CENTIMETERS);
        Length l2 = new Length(2.0, LengthUnit.CENTIMETERS);

        Assertions.assertTrue(l1.equals(l2));
    }

    @Test
    public void testCentimeterToInches_Equivalent() {

        Length l1 = new Length(1.0, LengthUnit.CENTIMETERS);
        Length l2 = new Length(0.393701, LengthUnit.INCHES);

        Assertions.assertTrue(l1.equals(l2));
    }

    @Test
    public void testCentimeterToFeet_NotEquivalent() {

        Length l2 = new Length(1.0, LengthUnit.FEET);
        Length l1 = new Length(1.0, LengthUnit.CENTIMETERS);

        Assertions.assertFalse(l1.equals(l2));
    }

    @Test
    public void testMultiUnit_TransitiveProperty() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length inches = new Length(36.0, LengthUnit.INCHES);

        Assertions.assertTrue(yard.equals(feet));
        Assertions.assertTrue(feet.equals(inches));
        Assertions.assertTrue(yard.equals(inches));
    }

    @Test
    public void testNullComparison() {

        Length l1 = new Length(1.0, LengthUnit.YARDS);

        Assertions.assertFalse(l1.equals(null));
    }

    @Test
    public void testSameReference() {

        Length l1 = new Length(1.0, LengthUnit.YARDS);

        Assertions.assertTrue(l1.equals(l1));
    }
}