package com.ordermanagement.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ordermanagement.dto.CustomerDto;
import com.ordermanagement.entity.Customer;
import com.ordermanagement.repository.CustomerRepository;
import com.ordermanagement.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
    
	private final ModelMapper mapper;
	private final CustomerRepository customerRepository;
	

	public CustomerServiceImpl(ModelMapper mapper, CustomerRepository customerRepository) {
		super();
		this.mapper = mapper;
		this.customerRepository = customerRepository;
	}


	@Override
	public CustomerDto registerCustomer(CustomerDto customerDto) {
		Customer customer = mapToEntity(customerDto);
		Customer newCustomer=customerRepository.save(customer);
		CustomerDto customerDto1 =mapToDto(newCustomer);
		return customerDto1;
	}


	private Customer mapToEntity(CustomerDto customerDto) {
		Customer customer = mapper.map(customerDto, Customer.class);
		return customer;
	}


	private CustomerDto mapToDto(Customer customer) {
		CustomerDto customerDto = mapper.map(customer, CustomerDto.class);
		return customerDto;
	}
	
}
