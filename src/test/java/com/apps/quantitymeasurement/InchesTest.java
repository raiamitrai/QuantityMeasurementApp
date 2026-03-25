package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InchesTest {

    @Test
    public void sameValue(){
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(10.0);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(10.0);
        Assertions.assertTrue(inches1.equals(inches2));
    }

    @Test
    public void differentValue(){
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(2.0);
        Assertions.assertFalse(inches1.equals(inches2));
    }

    @Test
public void nullCamparism(){

    Assertions.assertThrows(
            NullPointerException.class,
            () -> new QuantityMeasurementApp.Inches(null));
}

     @Test
    public void nonNumericValue(){
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(10.0);
        Assertions.assertFalse(inches1.equals("hello"));
    }
    @Test
    public void testQualitySameReference(){
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(10.0);
        Assertions.assertTrue(inches1.equals(inches1));
    }
}


