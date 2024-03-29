package com.sergiocuenca.controller;

import com.sergiocuenca.dto.ProductDTO;
import com.sergiocuenca.service.GeneralOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/generalOrder")
public class GeneralOrderController {

    @Autowired
    GeneralOrderService generalOrderService;

    @GetMapping()
    ResponseEntity<List<ProductDTO>> getGeneralOrderByWeight(@RequestParam("stockRatioWeight") Double stockRatioWeight,
                                                             @RequestParam("unitSalesWeight") Double unitSalesWeight) {
        List<ProductDTO> responseBody = this.generalOrderService.getGeneralOrderByWeight(stockRatioWeight, unitSalesWeight);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
