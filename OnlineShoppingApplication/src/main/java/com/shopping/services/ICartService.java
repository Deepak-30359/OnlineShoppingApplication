package com.shopping.services;

import java.util.List;

import com.shopping.entities.Cart;
import com.shopping.entities.Product;

public interface ICartService {
	
	public Cart addProductToCart(Cart cart,Product p,int quantity);
	public boolean removeProductFromCart(Cart cart,Product p);
	public Cart updateProductQuantity(Cart cart,Product p,int quantity);
	public Cart removeAllProducts(Cart cart);
	public List<Cart>viewAllProducts();
}

