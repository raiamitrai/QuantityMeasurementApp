package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC11QuantityVolumeTest {

    // ---------- Equality Tests ----------

    @Test
    public void testEquality_LitreToLitre(){

        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 = new Quantity<>(1.0, VolumeUnit.LITRE);

        assertEquals(v1, v2);
    }

    @Test
    public void testEquality_LitreToMillilitre(){

        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertEquals(v1, v2);
    }

    @Test
    public void testEquality_LitreToGallon(){

        Quantity<VolumeUnit> v1 =
                new Quantity<>(3.78541, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        assertEquals(v1, v2);
    }

    @Test
    public void testEquality_Zero(){

        Quantity<VolumeUnit> v1 =
                new Quantity<>(0.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(0.0, VolumeUnit.MILLILITRE);

        assertEquals(v1, v2);
    }

    @Test
    public void testEquality_Negative(){

        Quantity<VolumeUnit> v1 =
                new Quantity<>(-1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(-1000.0, VolumeUnit.MILLILITRE);

        assertEquals(v1, v2);
    }

    @Test
    public void testEquality_NullComparison(){

        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        assertFalse(v1.equals(null));
    }

    @Test
    public void testEquality_SameReference(){

        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        assertEquals(v1, v1);
    }

    @Test
    public void testConstructor_NullUnit(){

        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(1.0, null));
    }

    // ---------- Conversion Tests ----------

    @Test
    public void testConversion_LitreToMillilitre(){

        Quantity<VolumeUnit> v =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        assertEquals(
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE),
                v.convertTo(VolumeUnit.MILLILITRE));
    }

    @Test
    public void testConversion_GallonToLitre(){

        Quantity<VolumeUnit> v =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        assertEquals(
                new Quantity<>(3.79, VolumeUnit.LITRE),
                v.convertTo(VolumeUnit.LITRE));
    }

    @Test
    public void testConversion_SameUnit(){

        Quantity<VolumeUnit> v =
                new Quantity<>(5.0, VolumeUnit.LITRE);

        assertEquals(v, v.convertTo(VolumeUnit.LITRE));
    }

    @Test
    public void testConversion_RoundTrip(){

        Quantity<VolumeUnit> v =
                new Quantity<>(2.5, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                v.convertTo(VolumeUnit.GALLON)
                 .convertTo(VolumeUnit.LITRE);

        assertEquals(v, result);
    }

    // ---------- Addition Tests ----------

    @Test
    public void testAddition_SameUnit(){

        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(2.0, VolumeUnit.LITRE);

        assertEquals(
                new Quantity<>(3.0, VolumeUnit.LITRE),
                v1.add(v2));
    }

    @Test
    public void testAddition_CrossUnit(){

        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertEquals(
                new Quantity<>(2.0, VolumeUnit.LITRE),
                v1.add(v2));
    }

    @Test
    public void testAddition_ExplicitTarget(){

        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertEquals(
                new Quantity<>(0.53, VolumeUnit.GALLON),
                v1.add(v2, VolumeUnit.GALLON));
    }

    @Test
    public void testAddition_WithZero(){

        Quantity<VolumeUnit> v1 =
                new Quantity<>(5.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(0.0, VolumeUnit.MILLILITRE);

        assertEquals(
                new Quantity<>(5.0, VolumeUnit.LITRE),
                v1.add(v2));
    }

    @Test
    public void testAddition_Negative(){

        Quantity<VolumeUnit> v1 =
                new Quantity<>(5.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(-2000.0, VolumeUnit.MILLILITRE);

        assertEquals(
                new Quantity<>(3.0, VolumeUnit.LITRE),
                v1.add(v2));
    }

    @Test
    public void testAddition_NullOperand(){

        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        assertThrows(
                IllegalArgumentException.class,
                () -> v1.add(null));
    }

    @Test
    public void testAddition_NullTarget(){

        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertThrows(
                IllegalArgumentException.class,
                () -> v1.add(v2, null));
    }
}