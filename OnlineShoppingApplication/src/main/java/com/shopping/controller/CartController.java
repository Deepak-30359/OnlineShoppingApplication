package com.shopping.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.shopping.entities.Cart;
import com.shopping.entities.Product;
import com.shopping.services.CartServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CartServiceImpl cartService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cart> addProductToCart(@Valid @RequestBody Cart cart,Product p,int quantity){
		Cart cart1 = cartService.addProductToCart(cart, p, quantity);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cartid}")
				.buildAndExpand(cart.getCartId())
				.toUri();
		return ResponseEntity.created(location).body(cart1);
	}
	
	@PutMapping
	public Cart updateProductQuantity(@RequestBody Cart cart,Product p,int quantity) {
		return cartService.updateProductQuantity(cart, p, quantity);
	}
	
	@DeleteMapping("/{cartid}")
	public ResponseEntity<String> removeProductFromCart(Cart cart,Product p){
		boolean flag = (cartService.removeProductFromCart(cart, p));
		if(flag)
			return new ResponseEntity<>("product removed successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("product not removed successfully", HttpStatus.BAD_REQUEST);
	}	
	@GetMapping
	public Cart removeAllProducts(Cart cart){
		return cartService.removeAllProducts(cart);
	}
	
	@GetMapping("/{cartid}")
	public List<Cart> viewAllProducts() {
		//System.out.println(cart);
		return cartService.viewAllProducts();
	}
}