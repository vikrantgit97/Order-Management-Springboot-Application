package com.ordermanagement.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.ordermanagement.entity.Orders;

public class CustomerDto {

	private Long customer_id;

	private String name;

	@NotNull(message = "Username should not be null or empty..")
	private String userName;

	@NotNull(message = "Email should not be null or empty..")
	@Email
	private String email;

	@NotNull(message = "Password should not be null or empty..")
	private String password;

	private String category = "Regular";

	private List<Orders> orders;

	public CustomerDto() {
		super();
	}

	public CustomerDto(Long customer_id, String name,
			@NotNull(message = "Username should not be null or empty..") String userName,
			@NotNull(message = "Email should not be null or empty..") @Email String email,
			@NotNull(message = "Password should not be null or empty..") String password, String category,
			List<Orders> orders) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.category = category;
		this.orders = orders;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "CustomerDto [customer_id=" + customer_id + ", name=" + name + ", userName=" + userName + ", email="
				+ email + ", password=" + password + ", category=" + category + ", orders=" + orders + "]";
	}
}
