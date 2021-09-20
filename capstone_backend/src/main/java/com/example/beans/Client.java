package com.example.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="client")
public class Client {
	 @Id
	 private String client_id;
     private String client_name;
     private String cust_id;
     private double transaction_limit;
     private double amount;
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public double getTransaction_limit() {
		return transaction_limit;
	}
	public void setTransaction_limit(double transaction_limit) {
		this.transaction_limit = transaction_limit;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Client(String client_id, String client_name, String cust_id, double transaction_limit, double amount) {
		super();
		this.client_id = client_id;
		this.client_name = client_name;
		this.cust_id = cust_id;
		this.transaction_limit = transaction_limit;
		this.amount = amount;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
     
}
