package com.ordermanagement.dto;

import java.time.LocalDateTime;

public class OrdersDto {

	private Long orderId;
	private LocalDateTime date = LocalDateTime.now();
	private Integer totalPrice;
	private String description;
	private String productName;
	private Integer quantity;

	public OrdersDto() {
		super();
	}

	public OrdersDto(Long orderId, LocalDateTime date, Integer totalPrice, String description, String productName,
			Integer quantity) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.totalPrice = totalPrice;
		this.description = description;
		this.productName = productName;
		this.quantity = quantity;
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

	@Override
	public String toString() {
		return "OrdersDto [orderId=" + orderId + ", date=" + date + ", totalPrice=" + totalPrice + ", description="
				+ description + ", productName=" + productName + ", quantity=" + quantity + "]";
	}
}
