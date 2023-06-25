package com.app.entities;

import javax.persistence.*;



@Entity
@Table(name="products")
public class Product extends BaseEntity {
	
	@Column(length=20 )
	private String name;
	
	
	private int qty;
	
	
	private double price;
	
	@Column(length=50 )
	private String description;
	
	public Product() {
		
	}

	public Product(String name, int qty, double price, String description) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	///=======================
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", qty=" + qty + ", price=" + price + ", description=" + description + "]";
	}
	
	//==================
	
	
	

}
