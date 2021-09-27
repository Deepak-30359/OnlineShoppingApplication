package com.shopping.services;

import java.util.List;

import com.shopping.entities.Product;

public interface IProductService {
	public List<Product> viewAllProducts();
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public Product viewProductByproductId(int productId);
	public List<Product> viewProductByCategory(String cname);
	public boolean removeProductByProductId(int productId);
}
