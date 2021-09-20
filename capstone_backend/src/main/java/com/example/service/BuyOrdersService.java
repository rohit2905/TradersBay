package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.BuyOrders;
import com.example.beans.History;
import com.example.beans.MessageResponse;
import com.example.repo.BuyOrdersRepository;
import com.example.utilities.OrderMatchingService;

@Service
public class BuyOrdersService implements IBuyOrdersService {
	
	@Autowired
	BuyOrdersRepository buyOrdersRepository;
	
	@Autowired
	OrderMatchingService orderMatchingService;
	
	@Override
	public void removeOrder(BuyOrders order) {
		buyOrdersRepository.delete(order);
	}
	
	@Override
	public MessageResponse placeOrder(BuyOrders buyOrders) {
		if(buyOrders!=null) {
			BuyOrders order = new BuyOrders();
			order.setClient_id(buyOrders.getClient_id());
			order.setInstrument_id(buyOrders.getInstrument_id());
			order.setOrder_bid(buyOrders.getOrder_bid());
			order.setPrice(buyOrders.getPrice());
			order.setQuantity(buyOrders.getQuantity());
		 buyOrdersRepository.save(order);
		orderMatchingService.checkBuy(buyOrders);
		 return new MessageResponse("Buy Request Submitted","Reference ID: "+buyOrders.getOrder_bid());
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public BuyOrders getOrderById(int id) {
		if(id>0){
		return buyOrdersRepository.findById(id).get();
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public List<BuyOrders> getAllOrders(){
		return buyOrdersRepository.findAll();
	}

}
