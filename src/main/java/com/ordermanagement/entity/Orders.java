package com.ordermanagement.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private LocalDateTime date = LocalDateTime.now();
	private Integer totalPrice;
	private String description;
	private String productName;

	private Integer quantity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cust_id", nullable = false)
	@JsonIgnore
	private Customer customer;

	public Orders() {
		super();
	}

	public Orders(Long orderId, LocalDateTime date, Integer totalPrice, String description, String productName,
			Integer quantity, Customer customer) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.totalPrice = totalPrice;
		this.description = description;
		this.productName = productName;
		this.quantity = quantity;
		this.customer = customer;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", date=" + date + ", totalPrice=" + totalPrice + ", description="
				+ description + ", productName=" + productName + ", quantity=" + quantity + ", customer=" + customer
				+ "]";
	}
}
