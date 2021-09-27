package com.shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shopping.entities.Cart;


public interface ICartRepository extends JpaRepository<Cart, Integer> {

}
