package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.BuyOrders;
import com.example.beans.MessageResponse;
import com.example.beans.SellOrders;
import com.example.repo.SellOrdersRepository;
import com.example.utilities.OrderMatchingService;

@Service
public class SellOrdersService implements ISellOrdersService {

	@Autowired
	SellOrdersRepository sellOrdersRepository;
	
	@Autowired
	OrderMatchingService orderMatchingService;
	
	@Override
	public void removeOrder(SellOrders sellOrders) {
		sellOrdersRepository.delete(sellOrders);
	}
	
	@Override
	public MessageResponse placeOrder(SellOrders sellOrders) {
		if(sellOrders!=null) {
			SellOrders order = new SellOrders();
			order.setClient_id(sellOrders.getClient_id());
			order.setInstrument_id(sellOrders.getInstrument_id());
			order.setOrder_sid(sellOrders.getOrder_sid());
			order.setPrice(sellOrders.getPrice());
			order.setQuantity(sellOrders.getQuantity());
			sellOrdersRepository.save(sellOrders);
			orderMatchingService.checkSell(sellOrders);
		 return new MessageResponse("Sell Request Submitted","Reference ID: "+sellOrders.getOrder_sid());
			
		
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public SellOrders getByID(int id) {
		if(id>0) {
		return sellOrdersRepository.findById(id).get();
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public List<SellOrders> getAllOrders(){
		return sellOrdersRepository.findAll();
	}
}
