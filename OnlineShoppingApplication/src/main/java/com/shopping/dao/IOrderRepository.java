package com.shopping.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.shopping.entities.Order;


public interface IOrderRepository extends JpaRepository<Order, Integer> {
	
	
	
	@Query(value = "Select o.orderid from order_mast o, address_master a where order_mast.addressid = a.addressid and a.pincode = :loc", nativeQuery=true)
	List<Order> viewAllOrdersByLocation(String loc);
	
	@Query(value = "select * from order_mast o where o.customerid in (select u.userid from user_mast u where u.userid = :userId)", nativeQuery=true)
	List<Order> findOrdersByUserId(int userId);
	
	@Query(value = "select * from order_mast o where o.date = :date",nativeQuery = true)
	List<Order> findOrdersByDate(String  date);
}
