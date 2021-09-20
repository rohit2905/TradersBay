package com.example.service;

import java.util.List;

import com.example.beans.BuyOrders;
import com.example.beans.MessageResponse;

public interface IBuyOrdersService {

	MessageResponse placeOrder(BuyOrders buyOrders);

	BuyOrders getOrderById(int id);

	List<BuyOrders> getAllOrders();

	void removeOrder(BuyOrders order);
}