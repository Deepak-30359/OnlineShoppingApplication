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
import com.shopping.dao.ICartRepository;
import com.shopping.entities.Cart;
import com.shopping.entities.Product;
import com.shopping.services.CartServiceImpl;


@ExtendWith(MockitoExtension.class)
 class ICartServiceTest {
	@Mock
	private ICartRepository cartRepository;
	@InjectMocks
	private CartServiceImpl cartService;
	
	@Test
	void getAllProductsTest() {
		List<Cart> list = new ArrayList<Cart>();
		Cart cart1 = new Cart(1);
//		Cart cart2 = new Cart(2);
//		Cart cart3 = new Cart(3);
		list.add(cart1);
//		list.add(cart2);
//		list.add(cart3);
		
		when(cartRepository.findAll()).thenReturn(list);
		List<Cart> cartList = cartService.viewAllProducts();
		assertEquals(1, cartList.size());
		
	}
	
	//add product to cart
//	@Test
//	void saveCartTest() {
//		Product cart = new Product(1, "Mobile", 16000, "Black", "r12", "HD", "Ram", 2);
//		when(cartRepository.save(cart)).thenReturn(cart);
//		Cart savedCart = cartService.addProductToCart(cart);
//		assertThat(savedCart).isNotNull();
//		assertEquals("Mobile",savedCart.getProducts());
//	}
	

}