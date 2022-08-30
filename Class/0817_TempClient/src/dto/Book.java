package dto;

import java.io.Serializable;

public class Book implements Serializable {
	private String name;
	private int price;
	
	
	
	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + "]";
	}


	public Book(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}


	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}