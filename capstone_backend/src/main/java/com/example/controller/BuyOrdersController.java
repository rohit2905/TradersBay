package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.BuyOrders;
import com.example.beans.History;
import com.example.beans.MessageResponse;
import com.example.service.IBuyOrdersService;
import com.example.utilities.OrderMatchingService;
@CrossOrigin
@RestController
@RequestMapping("api")
public class BuyOrdersController<T> {

	@Autowired
	IBuyOrdersService ordersService;
	

	
	@PostMapping("buyorder")
	public MessageResponse postOrder(@RequestBody BuyOrders order){
		return ordersService.placeOrder(order);
		
		//new ResponseEntity<BuyOrders>(ordersService.placeOrder(order), HttpStatus.OK);
	}
	
	@GetMapping("/buyorder/{id}")
	public ResponseEntity<BuyOrders> getById(@PathVariable int id){
		return new ResponseEntity<BuyOrders>(ordersService.getOrderById(id), HttpStatus.OK);
	}
	
	@GetMapping("/buyorders")
	public ResponseEntity<List<BuyOrders>> getAll(){
		return new ResponseEntity<List<BuyOrders>>(ordersService.getAllOrders(), HttpStatus.OK);
	}
	
		
}
