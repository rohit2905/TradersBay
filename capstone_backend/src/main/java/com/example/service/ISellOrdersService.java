package com.example.service;

import java.util.List;

import com.example.beans.MessageResponse;
import com.example.beans.SellOrders;

public interface ISellOrdersService {

	MessageResponse placeOrder(SellOrders sellOrders);

	SellOrders getByID(int id);

	List<SellOrders> getAllOrders();
	
	void removeOrder(SellOrders sellOrders) ;

}