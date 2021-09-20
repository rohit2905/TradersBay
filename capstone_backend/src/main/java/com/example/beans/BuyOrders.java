package com.example.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="buyorders")
public class BuyOrders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int order_bid;
	private String instrument_id;
	private String client_id;
	private int quantity;
	double price;
	public int getOrder_bid() {
		return order_bid;
	}
	public void setOrder_bid(int order_bid) {
		this.order_bid = order_bid;
	}
	public String getInstrument_id() {
		return instrument_id;
	}
	public void setInstrument_id(String instrument_id) {
		this.instrument_id = instrument_id;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
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
	public BuyOrders(int order_bid, String instrument_id, String client_id, int quantity, double price) {
		super();
		this.order_bid = order_bid;
		this.instrument_id = instrument_id;
		this.client_id = client_id;
		this.quantity = quantity;
		this.price = price;
	}
	public BuyOrders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
