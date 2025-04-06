package com.ecommerce.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
		//member variable
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		@Column(name="name",length=200,nullable=false,unique=true)
		private String name;
		@Column(name="description",length=200,nullable=false)
		private String description;
		@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
		private List<Product> products;
		//Non-Parameterized Constructor
		public Category()
		{
			this.id = 0;
			this.name = null;
			this.description = null;
		}
		//Parameterized Constructor
		public Category(String name, String description) {
			super();
			this.name = name;
			this.description = description;
		}
		//getter and setter
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		@Override
		public String toString() {
			return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
		}
}