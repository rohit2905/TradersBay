package com.example.utilities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.ClientType;
import org.springframework.stereotype.Service;

import com.example.beans.BuyOrders;
import com.example.beans.Client;
import com.example.beans.History;
import com.example.beans.SellOrders;
import com.example.repo.BuyOrdersRepository;
import com.example.repo.ClientRepositry;
import com.example.repo.HistoryRepository;
import com.example.repo.SellOrdersRepository;



 
@Service
@Configurable
public class OrderMatchingService {

	@Autowired
	SellOrdersRepository sellOrdersService;
	
	@Autowired
	BuyOrdersRepository buyOrdersService;
	
	
	@Autowired
	HistoryRepository historyService;
	

	@Autowired
	ClientRepositry clientRepositry;
	
	public History checkBuy(BuyOrders buyOrder) {
		History hist=new History();
	 System.out.print("hello");
		List<SellOrders> sellOrders=sellOrdersService.findAll();
		Client client=clientRepositry.findById(buyOrder.getClient_id()).get();
	
		for(SellOrders sellOrder:sellOrders) {
			 System.out.println(sellOrder.getInstrument_id());
			 if(client.getTransaction_limit()>0) {
			if(sellOrder.getInstrument_id().equals(buyOrder.getInstrument_id())) {
				
			
				if((sellOrder.getQuantity()==buyOrder.getQuantity()) && (sellOrder.getPrice()==buyOrder.getPrice()) ) {
					//quantity and price for sell and buy orders is same. 
					//so, add both to history and remove records from their respective tables
					
					client.setAmount(client.getAmount()+ buyOrder.getPrice());
					System.out.println(client.getAmount());
					clientRepositry.save(client);
					hist.setOrder_bid(buyOrder.getClient_id());
					hist.setOrder_sid(buyOrder.getInstrument_id());
					hist.setStatus("Success");
					historyService.save(hist);
			
					buyOrdersService.delete(buyOrder);
					sellOrdersService.delete(sellOrder);
				
					return hist;
				}
				else if(buyOrder.getQuantity()<sellOrder.getQuantity())
				{
					for(SellOrders sellO:sellOrders) {
						// System.out.println(sellOrder.getInstrument_id());
						if(sellO.getInstrument_id().equals(buyOrder.getInstrument_id())) {
						   if(sellO.getQuantity()>buyOrder.getQuantity()) {
				   
					
					client.setAmount(client.getAmount()+ buyOrder.getPrice());
					clientRepositry.save(client);
					int res=sellO.getQuantity()-buyOrder.getQuantity();
					double sum=sellO.getPrice()-buyOrder.getPrice();
					hist.setOrder_bid(buyOrder.getClient_id());
					hist.setOrder_sid(buyOrder.getInstrument_id());
					hist.setStatus("Success");
					historyService.save(hist);
			
				
					sellO.setPrice(sum);
					sellO.setQuantity(res);
					
					buyOrdersService.delete(buyOrder);
				    
				    sellOrdersService.save(sellO);
				
						   }}}
					return hist;
					
				}else if(buyOrder.getQuantity()>sellOrder.getQuantity())
				{
				
					for(SellOrders sellO:sellOrders) {
						// System.out.println(sellOrder.getInstrument_id());
						if(sellO.getInstrument_id().equals(buyOrder.getInstrument_id())) {
						   if(sellO.getQuantity()<buyOrder.getQuantity()) {
				   
					client.setAmount(client.getAmount()+ buyOrder.getPrice());
					System.out.println(client.getAmount());
					clientRepositry.save(client);
					int res=buyOrder.getQuantity()-sellO.getQuantity();
					double sum=buyOrder.getPrice()-sellO.getPrice();
					hist.setOrder_bid(buyOrder.getClient_id());
					hist.setOrder_sid(buyOrder.getInstrument_id());
					hist.setStatus("Success");
					historyService.save(hist);
			
					buyOrder.setPrice(sum);
					buyOrder.setQuantity(res);
					sellOrdersService.delete(sellO);
				    buyOrdersService.save(buyOrder);
				
					}}}
					return hist;
				}
				}
			}
		
		}
		return hist;
	}
	public History checkSell(SellOrders sellOrder) {
		History hist=new History();
	 System.out.print("hello");
		List<BuyOrders> buyOrders=buyOrdersService.findAll();
		Client client=clientRepositry.findById(sellOrder.getClient_id()).get();
		for(BuyOrders buyOrder:buyOrders) {
			 System.out.println(sellOrder.getInstrument_id());
			 if(client.getTransaction_limit()>0) {
			if(sellOrder.getInstrument_id().equals(buyOrder.getInstrument_id())) {
				System.out.println("hello");
				if((sellOrder.getQuantity()==buyOrder.getQuantity()) && (sellOrder.getPrice()==buyOrder.getPrice()) ) {
					//quantity and price for sell and buy orders is same. 
					//so, add both to history and remove records from their respective tables
					hist.setOrder_bid(buyOrder.getClient_id());
					hist.setOrder_sid(buyOrder.getInstrument_id());
					hist.setStatus("Success");
					historyService.save(hist);
				
					buyOrdersService.delete(buyOrder);
					sellOrdersService.delete(sellOrder);
					
					return hist;
				}
				else if(sellOrder.getQuantity()<buyOrder.getQuantity())
				{
					for(BuyOrders buyO:buyOrders) {
					
						if(sellOrder.getInstrument_id().equals(buyO.getInstrument_id())) {
						   if(sellOrder.getQuantity()<buyO.getQuantity()) {
				   
					int res=buyO.getQuantity()-sellOrder.getQuantity();
					double sum=buyO.getPrice()-sellOrder.getPrice();
					hist.setOrder_bid(buyOrder.getClient_id());
					hist.setOrder_sid(buyOrder.getInstrument_id());
					hist.setStatus("Success");
			
					historyService.save(hist);
					buyO.setPrice(sum);
					buyO.setQuantity(res);
					
					sellOrdersService.delete(sellOrder);
				    
				    buyOrdersService.save(buyO);
				
					return hist;}}}
					
				}
				else if(sellOrder.getQuantity()>buyOrder.getQuantity())
				{

					for(BuyOrders buyO:buyOrders) {
						// System.out.println(sellOrder.getInstrument_id());
						if(sellOrder.getInstrument_id().equals(buyO.getInstrument_id())) {
						   if(sellOrder.getQuantity()>buyO.getQuantity()) {
							   int remainq=sellOrder.getQuantity()-buyO.getQuantity();
								double remains=sellOrder.getPrice()-buyO.getPrice();
								hist.setOrder_bid(buyOrder.getClient_id());
								hist.setOrder_sid(buyOrder.getInstrument_id());
								hist.setStatus("Success");
								historyService.save(hist);
								sellOrder.setPrice(remains);
								sellOrder.setQuantity(remainq);
								
								buyOrdersService.delete(buyO);
								sellOrdersService.save(sellOrder);
								
						   }
						}
					}
					return hist;
					
				}
			}
			 }
		}
		return hist;
	
	}
}
