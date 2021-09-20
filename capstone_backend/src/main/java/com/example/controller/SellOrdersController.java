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

import com.example.beans.MessageResponse;
import com.example.beans.SellOrders;
import com.example.service.ISellOrdersService;
@CrossOrigin
@RestController
@RequestMapping("api")
public class SellOrdersController {

	@Autowired
	ISellOrdersService ordersService;
	

	@PostMapping("/sellorder")
	public MessageResponse postOrder(@RequestBody SellOrders order){
		return ordersService.placeOrder(order);
	}
	
	@GetMapping("/sellorder/{id}")
	public ResponseEntity<SellOrders> getById(@PathVariable Integer id){
		return new ResponseEntity<SellOrders>(ordersService.getByID(id), HttpStatus.OK);
	}
	
	@GetMapping("/sellorders")
	public ResponseEntity<List<SellOrders>> getAll(){
		return new ResponseEntity<List<SellOrders>>(ordersService.getAllOrders(), HttpStatus.OK);
	}
}
