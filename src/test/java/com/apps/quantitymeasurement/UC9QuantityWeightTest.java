package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC9QuantityWeightTest {

    @Test
    public void testEquality_KgToKg_Same(){

        QuantityWeight w1 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight w2 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_KgToGram(){

        QuantityWeight w1 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight w2 =
                new QuantityWeight(1000.0, WeightUnit.GRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_KgToPound(){

        QuantityWeight w1 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight w2 =
                new QuantityWeight(2.20462, WeightUnit.POUND);

        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_Zero(){

        QuantityWeight w1 =
                new QuantityWeight(0.0, WeightUnit.KILOGRAM);

        QuantityWeight w2 =
                new QuantityWeight(0.0, WeightUnit.GRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_Negative(){

        QuantityWeight w1 =
                new QuantityWeight(-1.0, WeightUnit.KILOGRAM);

        QuantityWeight w2 =
                new QuantityWeight(-1000.0, WeightUnit.GRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_NullComparison(){

        QuantityWeight w1 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertFalse(w1.equals(null));
    }

    @Test
    public void testEquality_SameReference(){

        QuantityWeight w1 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertEquals(w1, w1);
    }

    @Test
    public void testEquality_NullUnitConstructor(){

        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityWeight(1.0, null));
    }

    // ---------- Conversion Tests ----------

    @Test
    public void testConversion_KgToGram(){

        QuantityWeight w =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertEquals(
                new QuantityWeight(1000.0, WeightUnit.GRAM),
                w.convertTo(WeightUnit.GRAM));
    }

    @Test
    public void testConversion_PoundToKg(){

        QuantityWeight w =
                new QuantityWeight(2.20462, WeightUnit.POUND);

        assertEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                w.convertTo(WeightUnit.KILOGRAM));
    }

    @Test
    public void testConversion_SameUnit(){

        QuantityWeight w =
                new QuantityWeight(5.0, WeightUnit.KILOGRAM);

        assertEquals(w, w.convertTo(WeightUnit.KILOGRAM));
    }

    @Test
    public void testConversion_RoundTrip(){

        QuantityWeight w =
                new QuantityWeight(1.5, WeightUnit.KILOGRAM);

        QuantityWeight result =
                w.convertTo(WeightUnit.GRAM)
                 .convertTo(WeightUnit.KILOGRAM);

        assertEquals(w, result);
    }

    // ---------- Addition Tests ----------

    @Test
    public void testAddition_SameUnit(){

        QuantityWeight w1 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight w2 =
                new QuantityWeight(2.0, WeightUnit.KILOGRAM);

        assertEquals(
                new QuantityWeight(3.0, WeightUnit.KILOGRAM),
                w1.add(w2));
    }

    @Test
    public void testAddition_CrossUnit(){

        QuantityWeight w1 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight w2 =
                new QuantityWeight(1000.0, WeightUnit.GRAM);

        assertEquals(
                new QuantityWeight(2.0, WeightUnit.KILOGRAM),
                w1.add(w2));
    }

    @Test
    public void testAddition_ExplicitTarget(){

        QuantityWeight w1 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight w2 =
                new QuantityWeight(1000.0, WeightUnit.GRAM);

        assertEquals(
                new QuantityWeight(2000.0, WeightUnit.GRAM),
                w1.add(w2, WeightUnit.GRAM));
    }

    @Test
    public void testAddition_WithZero(){

        QuantityWeight w1 =
                new QuantityWeight(5.0, WeightUnit.KILOGRAM);

        QuantityWeight w2 =
                new QuantityWeight(0.0, WeightUnit.GRAM);

        assertEquals(
                new QuantityWeight(5.0, WeightUnit.KILOGRAM),
                w1.add(w2));
    }

    @Test
    public void testAddition_Negative(){

        QuantityWeight w1 =
                new QuantityWeight(5.0, WeightUnit.KILOGRAM);

        QuantityWeight w2 =
                new QuantityWeight(-2000.0, WeightUnit.GRAM);

        assertEquals(
                new QuantityWeight(3.0, WeightUnit.KILOGRAM),
                w1.add(w2));
    }

    @Test
    public void testAddition_LargeValues(){

        QuantityWeight w1 =
                new QuantityWeight(1e6, WeightUnit.KILOGRAM);

        QuantityWeight w2 =
                new QuantityWeight(1e6, WeightUnit.KILOGRAM);

        assertEquals(
                new QuantityWeight(2e6, WeightUnit.KILOGRAM),
                w1.add(w2));
    }
}