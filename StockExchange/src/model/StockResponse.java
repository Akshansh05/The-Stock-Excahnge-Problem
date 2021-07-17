package model;

public class StockResponse {

	private int sellerId;
	private int buyerId;
	private int quantity;
	private double price;

	public StockResponse(int sellerId, int buyerId, int quantity, double price) {
		super();
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.quantity = quantity;
		this.price = price;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
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
