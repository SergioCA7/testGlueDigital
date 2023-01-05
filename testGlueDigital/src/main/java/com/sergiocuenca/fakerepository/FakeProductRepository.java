package com.sergiocuenca.fakerepository;

import com.sergiocuenca.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FakeProductRepository {

    public List<Product> getAllProducts();
}
