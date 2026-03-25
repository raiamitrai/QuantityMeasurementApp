package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC13QuantityArithmeticRefactorTest {

    // ---------- ADD Tests ----------

    @Test
    public void testAdd_SameUnit(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(5 , LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(3 , LengthUnit.FEET);

        assertEquals(
                new Quantity<>(8 , LengthUnit.FEET),
                q1.add(q2));
    }

    @Test
    public void testAdd_CrossUnit(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(1 , LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(12 , LengthUnit.INCHES);

        assertEquals(
                new Quantity<>(2 , LengthUnit.FEET),
                q1.add(q2));
    }

    // ---------- SUBTRACT Tests ----------

    @Test
    public void testSubtract_SameUnit(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(10 , LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(4 , LengthUnit.FEET);

        assertEquals(
                new Quantity<>(6 , LengthUnit.FEET),
                q1.subtract(q2));
    }

    @Test
    public void testSubtract_CrossUnit(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(10 , LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(6 , LengthUnit.INCHES);

        assertEquals(
                new Quantity<>(9.5 , LengthUnit.FEET),
                q1.subtract(q2));
    }

    @Test
    public void testSubtract_NegativeResult(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(2 , LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(5 , LengthUnit.FEET);

        assertEquals(
                new Quantity<>(-3 , LengthUnit.FEET),
                q1.subtract(q2));
    }

    // ---------- DIVIDE Tests ----------

    @Test
    public void testDivide_SameUnit(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(10 , LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(2 , LengthUnit.FEET);

        assertEquals(5.0 , q1.divide(q2));
    }

    @Test
    public void testDivide_CrossUnit(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(24 , LengthUnit.INCHES);

        Quantity<LengthUnit> q2 =
                new Quantity<>(2 , LengthUnit.FEET);

        assertEquals(1.0 , q1.divide(q2));
    }

    @Test
    public void testDivide_ByZero(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(10 , LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(0 , LengthUnit.FEET);

        assertThrows(
                ArithmeticException.class,
                () -> q1.divide(q2));
    }

    // ---------- Validation Tests ----------

    @Test
    public void testAdd_NullOperand(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(10 , LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> q1.add(null));
    }

    @Test
    public void testSubtract_NullOperand(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(10 , LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> q1.subtract(null));
    }

    @Test
    public void testDivide_NullOperand(){

        Quantity<LengthUnit> q1 =
                new Quantity<>(10 , LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> q1.divide(null));
    }

    @Test
    public void testCrossCategoryArithmetic(){

        Quantity<LengthUnit> l =
                new Quantity<>(10 , LengthUnit.FEET);

        Quantity<WeightUnit> w =
                new Quantity<>(5 , WeightUnit.KILOGRAM);

        assertThrows(
                IllegalArgumentException.class,
                () -> l.add((Quantity) w));
    }
}