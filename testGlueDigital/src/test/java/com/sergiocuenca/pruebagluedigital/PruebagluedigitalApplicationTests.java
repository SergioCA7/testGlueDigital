package com.sergiocuenca.pruebagluedigital;

import com.sergiocuenca.dto.ProductDTO;
import com.sergiocuenca.fakerepository.FakeProductRepository;
import com.sergiocuenca.model.Product;
import com.sergiocuenca.service.GeneralOrderService;
import com.sergiocuenca.service.impl.GeneralOrderServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)

class PruebagluedigitalApplicationTests {


	@InjectMocks
	private GeneralOrderServiceImpl generalOrderService;

	@Mock
	private FakeProductRepository fakeProductRepository;

	@Mock
	private ModelMapper modelMapper;


	private static List<Product> products;

	private static List<ProductDTO> productsDTO;

	private static Product product1;
	private static Product product2;
	private static ProductDTO product1dto;
	private static ProductDTO product2dto;


	@BeforeAll
	public static void beforeAll() {
		HashMap<String, Integer> stock1 = new HashMap<>();
		stock1.put("S", 4);
		stock1.put("M", 9);
		stock1.put("L", 0);
		Product p1 = new Product(1, "V-NECK BASIC SHIRT", 100, stock1);
		p1.setScore(326.0);
		HashMap<String, Integer> stock2 = new HashMap<>();
		stock2.put("S", 35);
		stock2.put("M", 9);
		stock2.put("L", 9);
		Product p2 = new Product(2, "CONTRASTING FABRIC T-SHIRT", 50, stock2);
		p2.setScore(1952.0);

		products = new ArrayList<>();
		products.add(p1);
		products.add(p2);

		ProductDTO p1dto = new ProductDTO(1, "V-NECK BASIC SHIRT", 100, stock1);
		p1dto.setScore(326.0);
		ProductDTO p2dto = new ProductDTO(2, "CONTRASTING FABRIC T-SHIRT", 50, stock2);
		p2dto.setScore(256.0);

		productsDTO = new ArrayList<>();
		productsDTO.add(p1dto);
		productsDTO.add(p2dto);

		product1 = p1;
		product2 = p2;
		product1dto = p1dto;
		product2dto = p2dto;

	}


	@Test
	public void testServiceOrderGeneralShouldThrowException() {
		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			generalOrderService.getGeneralOrderByWeight(1.0, -1.0);
		});
	}

	@Test
	public void testServiceOrderGeneralID1ShouldBeFirst() {
		given(fakeProductRepository.getAllProducts()).willReturn(products);
		when(modelMapper.map(product1, ProductDTO.class)).thenReturn(product1dto);
		when(modelMapper.map(product2, ProductDTO.class)).thenReturn(product2dto);

		List<ProductDTO> result = generalOrderService.getGeneralOrderByWeight(2.0, 3.0);
		assertEquals(result.get(0).getId(), 1);
	}

}
