package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC7LengthAdditionWithTargetUnitTest {

    @Test
    public void testAddition_ExplicitTargetUnit_Feet(){

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length result = l1.add(l2, LengthUnit.FEET);

        assertEquals(new Length(2.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Inches(){

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length result = l1.add(l2, LengthUnit.INCHES);

        assertEquals(new Length(24.0, LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Yards(){

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length result = l1.add(l2, LengthUnit.YARDS);

        assertEquals(new Length(0.67, LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters(){

        Length l1 = new Length(1.0, LengthUnit.INCHES);
        Length l2 = new Length(1.0, LengthUnit.INCHES);

        Length result = l1.add(l2, LengthUnit.CENTIMETERS);

        assertEquals(new Length(5.08, LengthUnit.CENTIMETERS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsFirstOperand(){

        Length l1 = new Length(2.0,LengthUnit.YARDS);
        Length l2 = new Length(3.0, LengthUnit.FEET);

        Length result = l1.add(l2, LengthUnit.YARDS);

        assertEquals(new Length(3.0, LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsSecondOperand(){

        Length l1 = new Length(2.0, LengthUnit.YARDS);
        Length l2 = new Length(3.0, LengthUnit.FEET);

        Length result = l1.add(l2, LengthUnit.FEET);

        assertEquals(new Length(9.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity(){

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length r1 = l1.add(l2, LengthUnit.YARDS);
        Length r2 = l2.add(l1, LengthUnit.YARDS);

        assertEquals(r1, r2);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_WithZero(){

        Length l1 = new Length(5.0, LengthUnit.FEET);
        Length l2 = new Length(0.0, LengthUnit.INCHES);

        Length result = l1.add(l2, LengthUnit.YARDS);

        assertEquals(new Length(1.67, LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValues(){

        Length l1 = new Length(5.0, LengthUnit.FEET);
        Length l2 = new Length(-2.0, LengthUnit.FEET);

        Length result = l1.add(l2, LengthUnit.INCHES);

        assertEquals(new Length(36.0, LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit(){

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        assertThrows(
                IllegalArgumentException.class,
                () -> l1.add(l2, null));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_LargeToSmallScale(){

        Length l1 = new Length(1000.0, LengthUnit.FEET);
        Length l2 = new Length(500.0, LengthUnit.FEET);

        Length result = l1.add(l2, LengthUnit.INCHES);

        assertEquals(new Length(18000.0, LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SmallToLargeScale(){

        Length l1 = new Length(12.0, LengthUnit.INCHES);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length result = l1.add(l2, LengthUnit.YARDS);

        assertEquals(new Length(0.67, LengthUnit.YARDS), result);
    }
}