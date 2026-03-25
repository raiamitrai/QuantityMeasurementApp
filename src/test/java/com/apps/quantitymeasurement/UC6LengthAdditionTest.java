package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC6LengthAdditionTest {

    @Test
    public void testAddition_SameUnit_FeetPlusFeet(){

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(2.0, LengthUnit.FEET);

        Length result = l1.add(l2);

        assertEquals(new Length(3.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_SameUnit_InchPlusInch(){

        Length l1 = new Length(6.0, LengthUnit.INCHES);
        Length l2 = new Length(6.0, LengthUnit.INCHES);

        Length result = l1.add(l2);

        assertEquals(new Length(12.0, LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_CrossUnit_FeetPlusInches(){

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length result = l1.add(l2);

        assertEquals(new Length(2.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_CrossUnit_InchPlusFeet(){

        Length l1 = new Length(12.0, LengthUnit.INCHES);
        Length l2 = new Length(1.0, LengthUnit.FEET);

        Length result = l1.add(l2);

        assertEquals(new Length(24.0, LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_CrossUnit_YardPlusFeet(){

        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(3.0, LengthUnit.FEET);

        Length result = l1.add(l2);

        assertEquals(new Length(2.0, LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_CrossUnit_CentimeterPlusInch(){

        Length l1 = new Length(2.54, LengthUnit.CENTIMETERS);
        Length l2 = new Length(1.0, LengthUnit.INCHES);

        Length result = l1.add(l2);

        assertEquals(new Length(5.08, LengthUnit.CENTIMETERS), result);
    }

    @Test
    public void testAddition_Commutativity(){

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length r1 = l1.add(l2);
        Length r2 = l2.add(l1);

        assertEquals(
                r1.convertTo(LengthUnit.INCHES),
                r2.convertTo(LengthUnit.INCHES));
    }

    @Test
    public void testAddition_WithZero(){

        Length l1 = new Length(5.0, LengthUnit.FEET);
        Length l2 = new Length(0.0, LengthUnit.INCHES);

        Length result = l1.add(l2);

        assertEquals(new Length(5.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_NegativeValues(){

        Length l1 = new Length(5.0, LengthUnit.FEET);
        Length l2 = new Length(-2.0, LengthUnit.FEET);

        Length result = l1.add(l2);

        assertEquals(new Length(3.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_NullSecondOperand(){

        Length l1 = new Length(1.0, LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> l1.add(null));
    }

    @Test
    public void testAddition_LargeValues(){

        Length l1 = new Length(1e6, LengthUnit.FEET);
        Length l2 = new Length(1e6, LengthUnit.FEET);

        Length result = l1.add(l2);

        assertEquals(new Length(2e6, LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_SmallValues(){

        Length l1 = new Length(0.001, LengthUnit.FEET);
        Length l2 = new Length(0.002, LengthUnit.FEET);
        Length result = l1.add(l2);
        assertEquals(new Length(0.00, LengthUnit.FEET), result);
    }
}