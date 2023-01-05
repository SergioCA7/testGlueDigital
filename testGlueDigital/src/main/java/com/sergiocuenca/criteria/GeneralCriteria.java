package com.sergiocuenca.criteria;

import com.sergiocuenca.comparators.Comparators;
import com.sergiocuenca.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GeneralCriteria implements ICriteria{

    private ICriteria unitSalesCriteria;

    private ICriteria stockRatioCriteria;


    public GeneralCriteria(ICriteria unitSalesCriteria, ICriteria stockRatioCriteria) {
        this.unitSalesCriteria = unitSalesCriteria;
        this.stockRatioCriteria = stockRatioCriteria;
    }

    @Override
    public List<Product> applyCriteria(List<Product> products) {
        List<Product> productsWithStockRatio = this.stockRatioCriteria.applyCriteria(products);
        List<Product> productsWithUnitSales = this.unitSalesCriteria.applyCriteria(products);
        ArrayList<Product> sortedProducts = new ArrayList<>(products);

        sortedProducts.forEach(product -> {
            Double stockRatioScore = getScoreFromProduct(productsWithStockRatio, product);
            Double unitSalesScore = getScoreFromProduct(productsWithUnitSales, product);
            product.setScore(Double.sum(stockRatioScore, unitSalesScore));
        });

        sortedProducts.sort(Comparators.scoreComparator());

        return sortedProducts;
    }

    private Double getScoreFromProduct(List<Product> products, Product productToFilter) {
        return products.stream().filter(stockRatioProduct -> {
            return stockRatioProduct.getId().equals(productToFilter.getId());
        }).findFirst().map(Product::getScore).orElseThrow();
    }
}
