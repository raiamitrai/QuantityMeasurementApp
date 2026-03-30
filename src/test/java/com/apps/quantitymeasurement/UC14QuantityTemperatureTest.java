package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC14QuantityTemperatureTest {

    private static final double EPS = 0.01;

    // ========================
    // Equality Tests
    // ========================

    @Test
    public void testCelsiusEquality(){

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(0.0 , TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(0.0 , TemperatureUnit.CELSIUS);

        assertEquals(t1 , t2);
    }

//    @Test
//    public void testCelsiusFahrenheitEquality(){
//
//        Quantity<TemperatureUnit> t1 =
//                new Quantity<>(0.0 , TemperatureUnit.CELSIUS);
//
//        Quantity<TemperatureUnit> t2 =
//                new Quantity<>(32.0 , TemperatureUnit.FAHRENHEIT);
//
//        assertEquals(t1 , t2);
//    }
//
//    @Test
//    public void testCelsiusKelvinEquality(){
//
//        Quantity<TemperatureUnit> t1 =
//                new Quantity<>(0.0 , TemperatureUnit.CELSIUS);
//
//        Quantity<TemperatureUnit> t2 =
//                new Quantity<>(273.15 , TemperatureUnit.KELVIN);
//
//        assertEquals(t1 , t2);
//    }
//
//    @Test
//    public void testNegative40Equality(){
//
//        Quantity<TemperatureUnit> t1 =
//                new Quantity<>(-40.0 , TemperatureUnit.CELSIUS);
//
//        Quantity<TemperatureUnit> t2 =
//                new Quantity<>(-40.0 , TemperatureUnit.FAHRENHEIT);
//
//        assertEquals(t1 , t2);
//    }



    @Test
    public void testCelsiusToFahrenheit(){

        Quantity<TemperatureUnit> t =
                new Quantity<>(100.0 , TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                t.convertTo(TemperatureUnit.FAHRENHEIT);

        assertEquals(
                new Quantity<>(212.0 , TemperatureUnit.FAHRENHEIT),
                result);
    }

    @Test
    public void testFahrenheitToCelsius(){

        Quantity<TemperatureUnit> t =
                new Quantity<>(32.0 , TemperatureUnit.FAHRENHEIT);

        Quantity<TemperatureUnit> result =
                t.convertTo(TemperatureUnit.CELSIUS);

        assertEquals(
                new Quantity<>(0.0 , TemperatureUnit.CELSIUS),
                result);
    }

    @Test
    public void testCelsiusToKelvin(){

        Quantity<TemperatureUnit> t =
                new Quantity<>(0.0 , TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                t.convertTo(TemperatureUnit.KELVIN);

        assertEquals(
                new Quantity<>(273.15 , TemperatureUnit.KELVIN),
                result);
    }

    @Test
    public void testRoundTripConversion(){

        Quantity<TemperatureUnit> t =
                new Quantity<>(50.0 , TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                t.convertTo(TemperatureUnit.FAHRENHEIT)
                 .convertTo(TemperatureUnit.CELSIUS);

        assertEquals(t , result);
    }

    // ========================
    // Unsupported Arithmetic
    // ========================

    @Test
    public void testTemperatureAddUnsupported(){

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(100.0 , TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(50.0 , TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,
                () -> t1.add(t2));
    }

    @Test
    public void testTemperatureSubtractUnsupported(){

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(100.0 , TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(50.0 , TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,
                () -> t1.subtract(t2));
    }

    @Test
    public void testTemperatureDivideUnsupported(){

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(100.0 , TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(50.0 , TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,
                () -> t1.divide(t2));
    }



    @Test
    public void testTemperatureVsLength(){

        Quantity<TemperatureUnit> t =
                new Quantity<>(100.0 , TemperatureUnit.CELSIUS);

        Quantity<LengthUnit> l =
                new Quantity<>(100.0 , LengthUnit.FEET);

        assertFalse(t.equals(l));
    }

    @Test
    public void testNullUnitConstructor(){

        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(100.0 , null));
    }
}