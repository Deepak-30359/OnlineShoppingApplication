package com.shopping.controller;

import java.net.URI;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.shopping.entities.Product;
import com.shopping.services.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductServiceImpl productService;
	
	@GetMapping("/productid")
	public List<Product> viewAllProducts(){
		return productService.viewAllProducts();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product){
		Product product1 = productService.addProduct(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{productid}")
				.buildAndExpand(product1.getProductId())
				.toUri();
		return ResponseEntity.created(location).body(product1);
	}
	
	@PutMapping("/update")
	public Product updateProduct(Product product) {
		return productService.updateProduct(product) ;
		
	}
	
	@GetMapping("/{productid}")
	public Product viewProductByproductId(@RequestParam int productId) {
		try {
			return productService.viewProductByproductId(productId);
		}
		catch(EntityNotFoundException e) {
			throw new EntityNotFoundException("No product by the id ");
		}
	}
	
	@GetMapping("/{bycategory}")
	public List<Product> viewProductByCategory(String cname){
		return productService.viewProductByCategory(cname);
	}
	
	@DeleteMapping("/{addressid}")
	public ResponseEntity<String> removeProductByProductId(int productId){
		boolean flag = productService.removeProductByProductId(productId);
		if(flag) {
			return new ResponseEntity<>("product removed successfully",HttpStatus.OK);
		}
		else 
			return new ResponseEntity<>("product not removed successfully",HttpStatus.BAD_REQUEST);
	}
	
}
