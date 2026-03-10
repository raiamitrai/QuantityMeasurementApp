package com.QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VolumeTest {

    @Test
    public void volumeLiterEqualsMilliliters() {
        Quantity<VolumeUnit> liter =
                new Quantity<>(1, VolumeUnit.LITRE);

        Quantity<VolumeUnit> milliliter =
                new Quantity<>(1000, VolumeUnit.MILLILITRE);

        assertTrue(QuantityMeasurementApp.demonstrateEquality(liter, milliliter));
    }

    @Test
    public void convertVolumeLitersToMilliliters() {
        Quantity<VolumeUnit> liter =
                new Quantity<>(1, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                QuantityMeasurementApp.demonstrateConversion(liter, VolumeUnit.MILLILITRE);

        assertEquals(1000, result.getValue());
    }

    @Test
    public void convertVolumeGallonToLiter() {
        Quantity<VolumeUnit> gallon =
                new Quantity<>(1, VolumeUnit.GALLON);

        Quantity<VolumeUnit> result =
                QuantityMeasurementApp.demonstrateConversion(gallon, VolumeUnit.LITRE);

        assertEquals(3.79, result.getValue());
    }

    @Test
    public void addVolumeLitersAndMilliliters() {
        Quantity<VolumeUnit> liter =
                new Quantity<>(1, VolumeUnit.LITRE);

        Quantity<VolumeUnit> milliliter =
                new Quantity<>(500, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                QuantityMeasurementApp.demonstrateAddition(liter, milliliter);

        assertEquals(1.5, result.getValue());
    }

    @Test
    public void addVolumeLitersAndMillilitersInMilliliters() {
        Quantity<VolumeUnit> liter =
                new Quantity<>(1, VolumeUnit.LITRE);

        Quantity<VolumeUnit> milliliter =
                new Quantity<>(500, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                QuantityMeasurementApp.demonstrateAddition(
                        liter,
                        milliliter,
                        VolumeUnit.MILLILITRE);

        assertEquals(1500, result.getValue());
    }

    @Test
    public void addVolumeLitersAndGallons() {
        Quantity<VolumeUnit> liter =
                new Quantity<>(1, VolumeUnit.LITRE);

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1, VolumeUnit.GALLON);

        Quantity<VolumeUnit> result =
                QuantityMeasurementApp.demonstrateAddition(liter, gallon);

        assertEquals(4.79, result.getValue());
    }

    @Test
    public void volumeGallonEqualsLiters() {
        Quantity<VolumeUnit> gallon =
                new Quantity<>(1, VolumeUnit.GALLON);

        Quantity<VolumeUnit> liter =
                new Quantity<>(3.78541, VolumeUnit.LITRE);

        assertTrue(QuantityMeasurementApp.demonstrateEquality(gallon, liter));
    }
}