package com.example.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="sellorders")
public class SellOrders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int order_sid;
	private String instrument_id;
	private String client_id;
	private int quantity;
	private double price;
	public int getOrder_sid() {
		return order_sid;
	}
	public void setOrder_sid(int order_sid) {
		this.order_sid = order_sid;
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
	public SellOrders(int order_sid, String instrument_id, String client_id, int quantity, double price) {
		super();
		this.order_sid = order_sid;
		this.instrument_id = instrument_id;
		this.client_id = client_id;
		this.quantity = quantity;
		this.price = price;
	}
	public SellOrders() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SellOrders [order_sid=" + order_sid + ", instrument_id=" + instrument_id + ", client_id=" + client_id
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
}
