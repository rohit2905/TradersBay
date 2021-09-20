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
import com.example.beans.Custodian;
import com.example.service.ICustodianService;
@CrossOrigin
@RestController
@RequestMapping("api")
public class CustodianController {
	@Autowired
	ICustodianService custodianService;
	

	@PostMapping("/custodian")
	public ResponseEntity<Custodian> postCustodian(@RequestBody Custodian custodian){
		return new ResponseEntity<Custodian>(custodianService.saveCustodian(custodian), HttpStatus.OK);
	}
	
	@GetMapping("/custodian/{id}")
	public ResponseEntity<Custodian> getById(@PathVariable String id){
		return new ResponseEntity<Custodian>(custodianService.getCustodianById(id), HttpStatus.OK);
	}
	
	@GetMapping("/custodians")
	public ResponseEntity<List<Custodian>> getAll(){
		return new ResponseEntity<List<Custodian>>(custodianService.getAllCustodians(), HttpStatus.OK);
	}
	

}
