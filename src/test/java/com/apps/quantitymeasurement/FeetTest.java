package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FeetTest {

    @Test
    public void sameValue(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(10.0);
        Assertions.assertTrue(feet1.equals(feet2));
    }

     @Test
    public void differentValue(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(2.0);
        Assertions.assertFalse(feet1.equals(feet2));
    }

  @Test
public void nullCamparism(){

    Assertions.assertThrows(
            NullPointerException.class,
            () -> new QuantityMeasurementApp.Feet(null));
}

     @Test
    public void nonNumericValue(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        Assertions.assertFalse(feet1.equals("hello"));
    }
    @Test
    public void testQualitySameReference(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        Assertions.assertTrue(feet1.equals(feet1));
    }
}

