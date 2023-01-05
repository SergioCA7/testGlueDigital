package com.sergiocuenca.service;

import com.sergiocuenca.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface GeneralOrderService {
    public List<ProductDTO> getGeneralOrderByWeight(Double stockRatioWeight, Double unitSalesWeight);
}
