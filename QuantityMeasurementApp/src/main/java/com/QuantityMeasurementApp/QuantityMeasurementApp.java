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

        // Equality demonstration
        Quantity<WeightUnit> weightInGrams =
                new Quantity<>(1000.0, WeightUnit.GRAMS);

        Quantity<WeightUnit> weightInKilograms =
                new Quantity<>(1.0, WeightUnit.KILOGRAMS);

        boolean areEqual =
                demonstrateEquality(weightInGrams, weightInKilograms);

        System.out.println("Are weights equal? " + areEqual);


        // Conversion demonstration
        Quantity<WeightUnit> convertedWeight =
                demonstrateConversion(weightInGrams, WeightUnit.KILOGRAMS);

        System.out.println("Converted Weight: "
                + convertedWeight.getValue() + " "
                + convertedWeight.getUnit());


        // Addition → result in unit of first quantity
        Quantity<WeightUnit> weightInPounds =
                new Quantity<>(2.20462, WeightUnit.POUNDS);

        Quantity<WeightUnit> sumWeight =
                demonstrateAddition(weightInKilograms, weightInPounds);

        System.out.println("Sum Weight: "
                + sumWeight.getValue() + " "
                + sumWeight.getUnit());


        // Addition → result in specified target unit
        Quantity<WeightUnit> sumWeightInGrams =
                demonstrateAddition(weightInKilograms,
                        weightInPounds,
                        WeightUnit.GRAMS);

        System.out.println("Sum Weight in Grams: "
                + sumWeightInGrams.getValue() + " "
                + sumWeightInGrams.getUnit());
    }
}
