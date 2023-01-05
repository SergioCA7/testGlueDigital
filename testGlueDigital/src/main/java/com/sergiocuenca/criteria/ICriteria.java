package com.sergiocuenca.criteria;

import com.sergiocuenca.model.Product;

import java.util.List;

public interface ICriteria {

    public List<Product> applyCriteria(List<Product> products);
}
