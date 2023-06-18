package com.ordermanagement.service.Impl;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagement.dto.OrdersDto;
import com.ordermanagement.entity.Customer;
import com.ordermanagement.entity.Orders;
import com.ordermanagement.exception.CustomerException;
import com.ordermanagement.repository.CustomerRepository;
import com.ordermanagement.repository.OrderRepository;
import com.ordermanagement.service.OrderService;

@Service
public class OrdersServiceImpl  implements OrderService{

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private OrderRepository ordersRepo;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public OrdersDto placeOrder(OrdersDto ordersDto, long custId) {
		Orders order = mapToentity(ordersDto);
		Customer customer = customerRepository.findById(custId)
				 .orElseThrow(()->new CustomerException("Customer Not register, please register first..."));
		 
		Set<Orders> orderSet= customer.getOrders();
		orderSet.add(order);

		Integer amount=0;
		for(Orders ord :orderSet) {
			amount =amount+ord.getTotalPrice();
		}
		
		if(orderSet.size()==10) {
			customer.setCategory("Gold");
			customer.setDiscountPrice(amount*10/100);
		}
		if (orderSet.size()==20) {
			customer.setCategory("platinum");
			customer.setDiscountPrice(amount*20/100);
		}
		
	
		order.setCustomer(customer);
		Orders newOrder= ordersRepo.save(order);
		customerRepository.save(customer);
		return mapToDto(newOrder);
	
	}

	private Orders mapToentity(OrdersDto ordersDto) {
		Orders orders =mapper.map(ordersDto, Orders.class);
		return orders;
	}
	
	private OrdersDto mapToDto (Orders orders) {
		OrdersDto ordersDto =mapper.map(orders, OrdersDto.class);
		return ordersDto;
	}
}
