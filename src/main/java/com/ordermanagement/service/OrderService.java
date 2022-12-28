package com.ordermanagement.service;

import org.springframework.stereotype.Service;
import com.ordermanagement.dto.OrdersDto;


public interface OrderService {

	public OrdersDto placeOrder(OrdersDto ordersDto, long custId);
	
	
}
