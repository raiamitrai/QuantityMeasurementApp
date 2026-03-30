package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC12QuantityArithmeticTest {

    @Test
    public void testSubtraction_SameUnit(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(10 , LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(5 , LengthUnit.FEET);

        assertEquals(
                new Quantity<>(5 , LengthUnit.FEET),
                q1.subtract(q2));
    }

    @Test
    public void testSubtraction_CrossUnit(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(10 , LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(6 , LengthUnit.INCHES);

        assertEquals(
                new Quantity<>(9.5 , LengthUnit.FEET),
                q1.subtract(q2));
    }

    @Test
    public void testSubtraction_ExplicitTarget(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(10 , LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(6 , LengthUnit.INCHES);

        assertEquals(
                new Quantity<>(114 , LengthUnit.INCHES),
                q1.subtract(q2 , LengthUnit.INCHES));
    }

    @Test
    public void testSubtraction_Negative(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(5 , LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(10 , LengthUnit.FEET);

        assertEquals(
                new Quantity<>(-5 , LengthUnit.FEET),
                q1.subtract(q2));
    }

    @Test
    public void testSubtraction_NullOperand(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(10 , LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> q1.subtract(null));
    }

    @Test
    public void testDivision_SameUnit(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(10 , LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(2 , LengthUnit.FEET);

        assertEquals(5.0 , q1.divide(q2));
    }

    @Test
    public void testDivision_CrossUnit(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(24 , LengthUnit.INCHES);

        Quantity<LengthUnit> q2 =
                new Quantity<>(2 , LengthUnit.FEET);

        assertEquals(1.0 , q1.divide(q2));
    }

    @Test
    public void testDivision_ByZero(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(10 , LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(0 , LengthUnit.FEET);

        assertThrows(
                ArithmeticException.class,
                () -> q1.divide(q2));
    }

    @Test
    public void testDivision_CrossCategory(){

        Quantity<LengthUnit> l =
                new Quantity<>(10 , LengthUnit.FEET);

        Quantity<WeightUnit> w =
                new Quantity<>(5 , WeightUnit.KILOGRAM);

        assertThrows(
                IllegalArgumentException.class,
                () -> l.divide((Quantity) w));
    }
}