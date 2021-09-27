package com.shopping.services;

import java.time.LocalDate;
import java.util.List;

import com.shopping.entities.Order;

public interface IOrderService {
	public Order addOrder(Order order);
	public Order updateOrder(Order order);
	public boolean removeOrderByOrderId(int orderid);
	public Order viewOrderByOrderId(int orderid);
	public List<Order> viewAllOrders(LocalDate date);
	public List<Order> viewAllOrdersByLocation(String loc);
	public List<Order> viewAllOrdersByUserId(int userId);



}