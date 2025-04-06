package com.ecommerce.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
			//member variables
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name="id")
			private int id;
			@Column(name="name",length=20,nullable=false)
			private String name;
			@Column(name="price",precision=10,scale=2,nullable=false)
			private BigDecimal price;
			@Column(name="stockQuantity")
			private int stockQuantity;
			//Many to one relation with category
			//ManytoOne
			@ManyToOne
			@JoinColumn(name="categoryid")
			private Category category;
			//Non-paramterized constructor
			public Product()
			{
				this.id = 0;
				this.name = null;
				this.price = BigDecimal.ZERO;
				this.stockQuantity = 0;
			}
			//Parameterized constructor
			public Product(String name, BigDecimal price, int stockQuantity, Category category) {
				super();
				this.name = name;
				this.price = price;
				this.stockQuantity = stockQuantity;
				this.category = category;
			}
			//getters and setters
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public BigDecimal getPrice() {
				return price;
			}
			public void setPrice(BigDecimal price) {
				this.price = price;
			}
			public int getStockQuantity() {
				return stockQuantity;
			}
			public void setStockQuantity(int stockQuantity) {
				this.stockQuantity = stockQuantity;
			}
			public Category getCategory() {
				return category;
			}
			public void setCategory(Category category) {
				this.category = category;
			}
			@Override
			public String toString() {
				return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stockQuantity=" + stockQuantity
						+ ", category=" + category + "]";
			}
}