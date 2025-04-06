package com.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetail 
{
	//member variables
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="quantity",nullable=false)
	private int quantity;
	@Column(name="unitPrice",nullable=false)
	private Double unitPrice;
	//ManytoOne with orders
	@ManyToOne
	@JoinColumn(name="orders id")
	private Order orders;
	//ManytoOne with Product
	@ManyToOne
	@JoinColumn(name="productid")
	private Product product;
	//non-parametrized constructor
	public OrderDetail()
	{
		this.id = 0;
		this.quantity = 0;
		this.unitPrice = 0.0;
	}
	//Parameterized constructor
	public OrderDetail(int quantity, Double unitPrice, Order o1, Product product) {
		super();
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.orders = o1;
		this.product = product;
	}
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Order getOrders() {
		return orders;
	}
	public void setOrders(Order orders) {
		this.orders = orders;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", orders=" + orders
				+ ", product=" + product + "]";
	}
}
