package com.shopping.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shopping.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {
	
	//@Query(value = "select p.name from product p, category c where p.catid = c.catid and c.name = :cname", nativeQuery=true)
	@Query("select distinct p from Product p join fetch p.category c where c.categoryName = :cname")
	List<Product> findByCategory(@Param("cname") String cname);
	@Query(value = "select * from product ",nativeQuery=true)
	List<Product> findAllProducts();
}
