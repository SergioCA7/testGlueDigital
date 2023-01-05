package com.sergiocuenca.criteria;

import com.sergiocuenca.comparators.Comparators;
import com.sergiocuenca.model.Product;
import com.sergiocuenca.util.HashMapUtils;
import com.sergiocuenca.util.ProductListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StockRatioCriteria implements ICriteria{

    private Double weight;

    public StockRatioCriteria(Double weight) {
        this.weight = weight;
    }

    @Override
    public List<Product> applyCriteria(List<Product> products) {
        ArrayList<Product> sortedProducts = new ArrayList<>(ProductListUtils.cloneListWithoutReference(products));
        this.addScoreToProduct(sortedProducts);
        sortedProducts.sort(Comparators.scoreComparator());
        return sortedProducts;
    }

    private void addScoreToProduct(List<Product> products) {
        products.forEach(product -> {
            product.setScore(HashMapUtils.getAllValueSum(product.getStocks()) * Double.valueOf(this.weight));
        });
    }
}
