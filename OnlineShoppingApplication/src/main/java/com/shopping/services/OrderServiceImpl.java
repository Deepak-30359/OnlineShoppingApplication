package com.shopping.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.shopping.dao.IOrderRepository;
import com.shopping.entities.Order;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityNotFoundException;

@Service
public class OrderServiceImpl implements IOrderService{
	@Autowired
	private IOrderRepository repository;
	
	@Override
	public Order addOrder(Order order) {
		return repository.save(order);
	}
	
	@Override
	public Order updateOrder(Order order) {
		Order order1 =repository.findById(order.getOrderId()).orElseThrow(
				() -> new EntityNotFoundException("no order found by the id"));
		return repository.save(order);
	}
	
	@Override
	public boolean removeOrderByOrderId(int orderId) {
		repository.findById(orderId).orElseThrow(
				() -> new EntityNotFoundException("No order found, check id"));
		repository.deleteById(orderId);
		return true;
		
	}
	
	
	@Override
	public Order viewOrderByOrderId(int orderId) {
		return repository.findById(orderId).get();
	}
	
	@Override
	public List<Order> viewAllOrders(LocalDate date) {
		return (List<Order>)repository.findAll();
	}
	@Override
	public List<Order> viewAllOrdersByLocation(String loc) {
		return (List<Order>)repository.findAll();
	}
	public List<Order> viewAllOrdersByUserId(int userId) {
		return repository.findOrdersByUserId(userId);
	}
}
