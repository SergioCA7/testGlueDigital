package com.sergiocuenca.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Objects;

public class Product implements Cloneable{

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("Sales_Units")
    private Integer unitSales;
    @JsonProperty("Stocks")
    private HashMap<String, Integer> stocks;
    @JsonProperty("score")
    private Double score;

    public Product(Integer id, String name, Integer unitSales, HashMap<String, Integer> stocks) {
        this.id = id;
        this.name = name;
        this.unitSales = unitSales;
        this.stocks = stocks;
    }

    public Product() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnitSales() {
        return unitSales;
    }

    public void setUnitSales(Integer unitSales) {
        this.unitSales = unitSales;
    }

    public HashMap<String, Integer> getStocks() {
        return stocks;
    }

    public void setStocks(HashMap<String, Integer> stocks) {
        this.stocks = stocks;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(unitSales, product.unitSales) && Objects.equals(stocks, product.stocks) && Objects.equals(score, product.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, unitSales, stocks, score);
    }

    @Override
    public Product clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
