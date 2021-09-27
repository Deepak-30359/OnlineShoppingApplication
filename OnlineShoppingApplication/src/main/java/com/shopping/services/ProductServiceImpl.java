package com.shopping.services;

import javax.persistence.EntityNotFoundException;
import com.shopping.dao.IProductRepository;
import com.shopping.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductRepository repository;
	
	@Override
	public List<Product> viewAllProducts() {
		return repository.findAll();
	}
	
	@Override
	public Product addProduct(Product product) {
		return repository.save(product);
	}
	
	@Override
	public Product updateProduct(Product product) {
		Product product1= repository.findById(product.getProductId()).orElseThrow(
				()-> new EntityNotFoundException("No product exists"));
		product1.setQuantity(product.getQuantity());
		product1.setProductName(product.getProductName());
		product1.setPrice(product.getPrice());
		product1.setColor(product.getColor());
		product1.setDimension(product.getDimension());
		product1.setSpecification(product.getSpecification());
		product1.setManufacturer(product.getManufacturer());
		return repository.save(product1);
	}

	@Override
	public Product viewProductByproductId(@RequestParam int productId) {
		try {
			return repository.findById(productId).get();
		}
			catch(NoSuchElementException e) {
				throw new NoSuchElementException("The Id does not exist");
			}
		}
	
	
	@Override
	public List<Product> viewProductByCategory(String cname) {
		return (List<Product>) repository.findByCategory(cname);
	}
    
	@Override
	public boolean removeProductByProductId(int productId) {
		repository.findById(productId).orElseThrow(
				() -> new EntityNotFoundException("No product found, check id"));
		repository.deleteById(productId);
		return true;
		
	}

}
