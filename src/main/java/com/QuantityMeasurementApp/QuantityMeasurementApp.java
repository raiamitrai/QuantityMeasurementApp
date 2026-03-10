package com.QuantityMeasurementApp;


public class QuantityMeasurementApp {

    public static <U extends IMeasureable> boolean demonstrateEquality(
            Quantity<U> q1, Quantity<U> q2) {

        if (q1 == null || q2 == null)
            throw new IllegalArgumentException("Quantities cannot be null");

        return q1.equals(q2);
    }

    public static <U extends IMeasureable> Quantity<U> demonstrateConversion(
            Quantity<U> source, U targetUnit) {

        if (source == null || targetUnit == null)
            throw new IllegalArgumentException("Invalid input");

        double convertedValue = source.convertTo(targetUnit);
        return new Quantity<>(convertedValue, targetUnit);
    }

    public static <U extends IMeasureable> Quantity<U> demonstrateAddition(
            Quantity<U> q1, Quantity<U> q2) {

        if (q1 == null || q2 == null)
            throw new IllegalArgumentException("Invalid input");

        return q1.add(q2);
    }

    public static <U extends IMeasureable> Quantity<U> demonstrateAddition(
            Quantity<U> q1, Quantity<U> q2, U targetUnit) {

        if (q1 == null || q2 == null || targetUnit == null)
            throw new IllegalArgumentException("Invalid input");

        return q1.add(q2, targetUnit);
    }

    public static void main(String[] args) {

        // -------- WEIGHT DEMONSTRATION --------

//        Quantity<WeightUnit> weightInGrams =
//                new Quantity<>(1000.0, WeightUnit.GRAMS);
//
//        Quantity<WeightUnit> weightInKilograms =
//                new Quantity<>(1.0, WeightUnit.KILOGRAMS);
//
//        boolean areWeightsEqual =
//                demonstrateEquality(weightInGrams, weightInKilograms);
//
//        System.out.println("Are weights equal? " + areWeightsEqual);
//
//
//        Quantity<WeightUnit> convertedWeight =
//                demonstrateConversion(weightInGrams, WeightUnit.KILOGRAMS);
//
//        System.out.println("Converted Weight: "
//                + convertedWeight.getValue() + " "
//                + convertedWeight.getUnit());
//
//
//        Quantity<WeightUnit> weightInPounds =
//                new Quantity<>(2.20462, WeightUnit.POUNDS);
//
//        Quantity<WeightUnit> sumWeight =
//                demonstrateAddition(weightInKilograms, weightInPounds);
//
//        System.out.println("Sum Weight: "
//                + sumWeight.getValue() + " "
//                + sumWeight.getUnit());
//
//
//        Quantity<WeightUnit> sumWeightInGrams =
//                demonstrateAddition(weightInKilograms,
//                        weightInPounds,
//                        WeightUnit.GRAMS);
//
//        System.out.println("Sum Weight in Grams: "
//                + sumWeightInGrams.getValue() + " "
//                + sumWeightInGrams.getUnit());
//
//
//        // -------- VOLUME DEMONSTRATION --------
//
//        Quantity<VolumeUnit> volumeInLitres =
//                new Quantity<>(1.0, VolumeUnit.LITRE);
//
//        Quantity<VolumeUnit> volumeInMillilitres =
//                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
//
//        boolean areVolumesEqual =
//                demonstrateEquality(volumeInLitres, volumeInMillilitres);
//
//        System.out.println("Are volumes equal? " + areVolumesEqual);
//
//
//        Quantity<VolumeUnit> convertedVolume =
//                demonstrateConversion(volumeInLitres, VolumeUnit.MILLILITRE);
//
//        System.out.println("Converted Volume: "
//                + convertedVolume.getValue() + " "
//                + convertedVolume.getUnit());
//
//
//        Quantity<VolumeUnit> volumeInGallon =
//                new Quantity<>(1.0, VolumeUnit.GALLON);
//
//        Quantity<VolumeUnit> sumVolume =
//                demonstrateAddition(volumeInLitres, volumeInGallon);
//
//        System.out.println("Sum Volume: "
//                + sumVolume.getValue() + " "
//                + sumVolume.getUnit());
//
//
//        Quantity<VolumeUnit> sumVolumeInMillilitres =
//                demonstrateAddition(volumeInLitres,
//                        volumeInGallon,
//                        VolumeUnit.MILLILITRE);
//
//        System.out.println("Sum Volume in Millilitres: "
//                + sumVolumeInMillilitres.getValue() + " "
//                + sumVolumeInMillilitres.getUnit());
    	
    	Quantity<VolumeUnit> liter =
                new Quantity<>(1, VolumeUnit.LITRE);

        Quantity<VolumeUnit> milliliter =
                new Quantity<>(500, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                QuantityMeasurementApp.demonstrateAddition(
                        liter,
                        milliliter,
                        VolumeUnit.MILLILITRE);

        System.out.println(result.getValue());
    }
}