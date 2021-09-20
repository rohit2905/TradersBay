package com.example.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="custodian")
public class Custodian {
    @Id
   private String cust_id;
    private String cust_name;
    private String password;
	public Custodian() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Custodian(String cust_id, String cust_name, String password) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.password = password;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Custodian [cust_id=" + cust_id + ", cust_name=" + cust_name + ", password=" + password + "]";
	}
}
