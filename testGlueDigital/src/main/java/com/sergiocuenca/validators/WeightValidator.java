package com.sergiocuenca.validators;

public class WeightValidator {

    public static void validatePositiveWeights(Double stockRatioWeight, Double unitSalesWeight) {
        if (stockRatioWeight < 0 || unitSalesWeight < 0) {
            throw new RuntimeException("Weights cannot be negative");
        }
    }
}
