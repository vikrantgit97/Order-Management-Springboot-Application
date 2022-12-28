package com.ordermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanagement.dto.CustomerDto;
import com.ordermanagement.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService custServ;
	
	@PostMapping("/register")
	public ResponseEntity<CustomerDto> registerCustomerHandle(@RequestBody CustomerDto custdto){
		return new ResponseEntity<>(custServ.registerCustomer(custdto),HttpStatus.CREATED);
	}
}
