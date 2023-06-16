package com.ordermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanagement.dto.OrdersDto;
import com.ordermanagement.service.OrderService;



@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

	@Autowired
	private OrderService ordersService;
	
	
	@PostMapping("/{Id}")
	public ResponseEntity<OrdersDto> placeOrderHandle(@RequestBody OrdersDto ordersDto,
			@PathVariable ("Id") Integer Id){
		
		return new ResponseEntity<OrdersDto>(ordersService.placeOrder(ordersDto, Id)
				,HttpStatus.CREATED);
	}
}
