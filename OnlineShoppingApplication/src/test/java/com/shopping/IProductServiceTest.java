package com.shopping;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.shopping.dao.IProductRepository;
import com.shopping.entities.Product;
import com.shopping.services.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
 class IProductServiceTest {
	@Mock
	private IProductRepository productRepository;
	@InjectMocks
	private ProductServiceImpl productService;
	
	@Test
	void getAllProductsTest() {
		List<Product> list = new ArrayList<Product>();
		Product product1 = new Product(1, "Mobile", 16000, "Black", "r12", "HD", "Ram", 2);
		Product product2 = new Product(2, "Tv", 30000, "Blue", "a15", "HD", "Ramu", 3);
		Product product3 = new Product(3, "AC", 36000, "White", "c22", "HD", "Raju", 4);
		list.add(product1);
		list.add(product2);
		list.add(product3);
		
		when(productRepository.findAll()).thenReturn(list);
		List<Product> productList = productService.viewAllProducts();
		assertEquals(3, productList.size());
		
	}
	
	//add product
	@Test
	void saveProductTest() {
		Product product = new Product(1, "Mobile", 16000, "Black", "r12", "HD", "Ram", 2);
		when(productRepository.save(product)).thenReturn(product);
		Product savedProduct = productService.addProduct(product);
		assertThat(savedProduct).isNotNull();
		assertEquals("Mobile",savedProduct.getProductName());
	}
	

}
