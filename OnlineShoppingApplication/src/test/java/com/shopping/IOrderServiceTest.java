package com.shopping;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.shopping.dao.IOrderRepository;
import com.shopping.entities.Order;
import com.shopping.services.OrderServiceImpl;


 class IOrderServiceTest {
	@Mock
	private IOrderRepository orderRepository;
	@InjectMocks
	private OrderServiceImpl orderService;
	
//	@Test
//	void getAllOrderTest() {
//		List<Order> list = new ArrayList<Order>();
//		Order order1 = new Order(1, "Success");
//		Order order2 = new Order(2, "Success");
//		//Order order3 = new Order(3, );
//		list.add(order1);
//		list.add(order2);
//		//list.add(order3);
//		
//		when(orderRepository.findAll()).thenReturn(list);
//		List<Order> orderList = orderService.viewAllOrders(LocalDate orderdate);
//		assertEquals(2, orderList.size());
//		
//	}
	
	//add order  
	@Test
	void saveOrderTest() {
		Order order = new Order(1, "Success");
		when(orderRepository.save(order)).thenReturn(order);
		Order savedOrder = orderService.addOrder(order);
		assertThat(savedOrder).isNotNull();
		assertEquals("Success",savedOrder.getOrderStatus());
	}
	

}
