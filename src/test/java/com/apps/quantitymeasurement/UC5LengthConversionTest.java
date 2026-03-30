package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UC5LengthConversionTest {

    @Test
    public void testFeetToInches(){

        Length result =
                new Length(1, LengthUnit.FEET)
                        .convertTo(LengthUnit.INCHES);

        Assertions.assertEquals(
                new Length(12, LengthUnit.INCHES),
                result);
    }

    @Test
    public void testInchesToFeet(){

        Length result =
                new Length(24, LengthUnit.INCHES)
                        .convertTo(LengthUnit.FEET);

        Assertions.assertEquals(
                new Length(2, LengthUnit.FEET),
                result);
    }

    @Test
    public void testYardsToFeet(){

        Length result =
                new Length(1, LengthUnit.YARDS)
                        .convertTo(LengthUnit.FEET);

        Assertions.assertEquals(
                new Length(3, LengthUnit.FEET),
                result);
    }

    @Test
    public void testInchesToYards(){

        Length result =
                new Length(72, LengthUnit.INCHES)
                        .convertTo(LengthUnit.YARDS);

        Assertions.assertEquals(
                new Length(2, LengthUnit.YARDS),
                result);
    }

    @Test
    public void testCentimeterToInches(){

        Length result =
                new Length(2.54, LengthUnit.CENTIMETERS)
                        .convertTo(LengthUnit.INCHES);

        Assertions.assertEquals(
                new Length(1, LengthUnit.INCHES),
                result);
    }

    @Test
    public void testFeetToCentimeter(){

        Length result =
                new Length(1, LengthUnit.FEET)
                        .convertTo(LengthUnit.CENTIMETERS);

        Assertions.assertEquals(
                new Length(30.48, LengthUnit.CENTIMETERS),
                result);
    }

    @Test
    public void testSameUnitConversion(){

        Length result =
                new Length(5, LengthUnit.FEET)
                        .convertTo(LengthUnit.FEET);

        Assertions.assertEquals(
                new Length(5, LengthUnit.FEET),
                result);
    }

    @Test
    public void testZeroConversion(){

        Length result =
                new Length(0, LengthUnit.FEET)
                        .convertTo(LengthUnit.INCHES);

        Assertions.assertEquals(
                new Length(0, LengthUnit.INCHES),
                result);
    }

    @Test
    public void testNegativeConversion(){

        Length result =
                new Length(-1, LengthUnit.FEET)
                        .convertTo(LengthUnit.INCHES);

        Assertions.assertEquals(
                new Length(-12, LengthUnit.INCHES),
                result);
    }

    @Test
    public void testRoundTripConversion(){

        Length original =
                new Length(3, LengthUnit.FEET);

        Length converted =
                original.convertTo(LengthUnit.INCHES)
                        .convertTo(LengthUnit.FEET);

        Assertions.assertEquals(original, converted);
    }

    @Test
    public void testNullTargetUnit(){

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Length(1, LengthUnit.FEET)
                        .convertTo(null));
    }
}