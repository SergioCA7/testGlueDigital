package com.sergiocuenca.comparators;

import com.sergiocuenca.model.Product;

import java.util.Comparator;

public class Comparators {

    public static Comparator<Product> scoreComparator() {
        return Comparator.comparing(Product::getScore).reversed();
    }
}
