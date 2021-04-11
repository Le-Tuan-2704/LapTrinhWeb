package com.models;

public class Book {
	private int ID;
	private String name;
	private String publisher;
	private int price;
	
	public Book(int iD, String name, String publisher, int price) {
		super();
		ID = iD;
		this.name = name;
		this.publisher = publisher;
		this.price = price;
	}

	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
