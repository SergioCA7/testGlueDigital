package com.sergiocuenca.fakerepository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sergiocuenca.fakerepository.FakeProductRepository;
import com.sergiocuenca.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class FakeProductRepositoryImpl implements FakeProductRepository {
    @Autowired
    ObjectMapper objectMapper;
    @Override
    public List<Product> getAllProducts() {

        List<Product> productList;
        try {
            String file = "src/main/resources/templates/products.json";
            String json =new String(Files.readAllBytes(Paths.get(file)));
            productList = objectMapper.readValue(json, new TypeReference<List<Product>>(){});

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
}
