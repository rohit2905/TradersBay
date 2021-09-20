package com.example.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="history")
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String order_bid;
	private String order_sid;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrder_bid() {
		return order_bid;
	}
	public void setOrder_bid(String order_bid) {
		this.order_bid = order_bid;
	}
	public String getOrder_sid() {
		return order_sid;
	}
	public void setOrder_sid(String order_sid) {
		this.order_sid = order_sid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public History(int id, String order_bid, String order_sid, String status) {
		super();
		this.id = id;
		this.order_bid = order_bid;
		this.order_sid = order_sid;
		this.status = status;
	}
	public History() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
