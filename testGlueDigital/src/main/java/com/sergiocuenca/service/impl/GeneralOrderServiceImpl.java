package com.sergiocuenca.service.impl;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.sergiocuenca.criteria.GeneralCriteria;
import com.sergiocuenca.criteria.ICriteria;
import com.sergiocuenca.criteria.StockRatioCriteria;
import com.sergiocuenca.criteria.UnitsSalesCriteria;
import com.sergiocuenca.dto.ProductDTO;
import com.sergiocuenca.fakerepository.FakeProductRepository;
import com.sergiocuenca.model.Product;
import com.sergiocuenca.service.GeneralOrderService;
import com.sergiocuenca.validators.WeightValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneralOrderServiceImpl implements GeneralOrderService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FakeProductRepository fakeProductRepository;

    public List<ProductDTO> getGeneralOrderByWeight(Double stockRatioWeight, Double unitSalesWeight) {

        WeightValidator.validatePositiveWeights(stockRatioWeight,unitSalesWeight);

        ICriteria stockRatioCriteria = new StockRatioCriteria(stockRatioWeight);
        ICriteria unitsSalesCriteria = new UnitsSalesCriteria(unitSalesWeight);
        ICriteria generalCriteria = new GeneralCriteria(unitsSalesCriteria,stockRatioCriteria);

        List<Product> products = fakeProductRepository.getAllProducts();

        List<Product> entityResponse = generalCriteria.applyCriteria(products);

        return entityResponse.stream().map(response -> {
            return modelMapper.map(response, ProductDTO.class);
        }).collect(Collectors.toList());
    }

}
