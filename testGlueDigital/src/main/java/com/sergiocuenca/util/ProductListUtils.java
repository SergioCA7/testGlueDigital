package com.sergiocuenca.util;

import com.sergiocuenca.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductListUtils {

    public static List<Product> cloneListWithoutReference(List<Product> products) {
        ArrayList<Product> result = new ArrayList<>();
            products.forEach(product -> {
                result.add(product.clone());
            });
        return result;
    }
}
