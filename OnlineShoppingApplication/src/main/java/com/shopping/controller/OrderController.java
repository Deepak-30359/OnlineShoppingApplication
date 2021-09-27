package com.shopping.controller;

import java.net.URI;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.time.LocalDate;
import com.shopping.entities.Order;
import com.shopping.services.OrderServiceImpl;


@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderServiceImpl orderService;
	
	@PostMapping("/order")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Order> addOrder(@Valid @RequestBody Order order){
		Order order1 = orderService.addOrder(order);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/orderid}")
				.buildAndExpand(order1.getOrderId())
				.toUri();
		  return ResponseEntity.created(location).body(order1);
	}
	
	@PutMapping
	public  Order updateOrder(@RequestBody Order order) {
		return orderService.updateOrder(order);
	}
	
	@DeleteMapping("/{orderid}")
	public ResponseEntity<String> removeOrderByOrderId(@PathVariable int orderId){
		boolean flag = orderService.removeOrderByOrderId(orderId);
		if(flag)
			return new ResponseEntity<>("order removed successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("order not removed successfully", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{orderid}")
	public Order viewOrderByOrderId(@PathVariable int orderId) {
		System.out.println(orderId);
		return orderService.viewOrderByOrderId(orderId);
	}

	@GetMapping("order/{date}")
	public List<Order> viewAllOrders(@PathVariable LocalDate date){
		return orderService.viewAllOrders(date);
	}
	
	@GetMapping("order/{loc}")
	public List<Order> viewAllOrdersByLocation(@PathVariable String loc){
		return orderService.viewAllOrdersByLocation(loc);
	}
	@GetMapping("order/{useId}")
	public List<Order> viewAllOrdersByUserId(@PathVariable int userId){
		return orderService.viewAllOrdersByUserId(userId);
	}
}
