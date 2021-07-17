package model;

import java.util.Date;

public class StockRequest {

	private int id;
	private String name;
	private Date time;
	private String type;
	private int quantity;
	private double price;

	public StockRequest(int id, Date time, String name, String type, int quantity, double price) {
		this.id = id;
		this.name = name;
		this.time = time;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
	}

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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
