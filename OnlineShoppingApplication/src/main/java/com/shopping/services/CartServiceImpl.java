package com.shopping.services;

import org.springframework.stereotype.Service;
import com.shopping.dao.ICartRepository;
import com.shopping.entities.Cart;
import com.shopping.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	private ICartRepository repository;

	@Override
	public Cart addProductToCart(Cart cart, Product p, int quantity) {
		return repository.save(cart);
	}
	
	@Override
	public boolean removeProductFromCart(Cart cart, Product p) {
		repository.findById(cart.getCartId()).orElseThrow(
				() -> new EntityNotFoundException("No card found , check id"));
		repository.deleteById(cart.getCartId());
		return true;
	}
	@Override
	public Cart updateProductQuantity(Cart cart, Product p, int quantity){
		Cart cart1 =repository.findById(cart.getCartId()).orElseThrow(
				() -> new EntityNotFoundException("no cart found by the id"));
		cart1.setCartId(cart.getCartId());
		return repository.save(cart);
	}
	
	@Override
	public Cart removeAllProducts(Cart cart) {
		return repository.save(cart);
	
	}
	
	@Override
	public List<Cart> viewAllProducts(){
		return repository.findAll();
	}
}