package com.ordermanagement.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "userName" }) })
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customer_id;

	private String name;

	private String userName;

	private String email;

	private String password;

	private Integer discountPrice = 0;

	private String category = "Regular";

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Orders> orders = new HashSet<>();

	public Customer() {
		super();
	}

	public Customer(Long customer_id, String name, String userName, String email, String password,
			Integer discountPrice, String category, Set<Orders> orders) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.discountPrice = discountPrice;
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

	public Integer getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Integer discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", name=" + name + ", userName=" + userName + ", email=" + email
				+ ", password=" + password + ", discountPrice=" + discountPrice + ", category=" + category + ", orders="
				+ orders + "]";
	}

}
