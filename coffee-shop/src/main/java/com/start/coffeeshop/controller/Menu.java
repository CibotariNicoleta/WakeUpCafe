package com.start.coffeeshop.controller;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Menu")
public class Menu {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Name") 
   private String name;
	@Column(name="Description") 
   private String description;
	@Column(name="Type") 
   private String type;
	@Column(name="Price") 
   private float price;
   
  
	public Menu(String name, String description, String type, float price) {
		this.name=name;
		this.description=description;
		this.type=type;
		this.price=price;
	}

	public Menu() {
		super();
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


public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
}


public float getPrice() {
	return price;
}


public void setPrice(float price) {
	this.price = price;
}
   
   

}
