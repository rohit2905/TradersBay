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

import com.example.beans.Client;
import com.example.beans.Custodian;
import com.example.service.IClientService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class ClientController {
	
	@Autowired
	IClientService clientService;
	
	@PostMapping("/client")
	public ResponseEntity<Client> postClient(@RequestBody Client client){
		return new ResponseEntity<Client>(clientService.saveClient(client), HttpStatus.OK);
	}
	
	@GetMapping("/client/{id}")
	public ResponseEntity<Client> getById(@PathVariable String id){
		return new ResponseEntity<Client>(clientService.getClientById(id), HttpStatus.OK);
	}
	
	@GetMapping("/clients")
	public ResponseEntity<List<Client>> getAll(){
		return new ResponseEntity<List<Client>>(clientService.getAllClient(), HttpStatus.OK);
	}
	@GetMapping("/clients/custodian/{id}")
	public ResponseEntity<List<Client>> getByCustodianID(@PathVariable String id){
		return new ResponseEntity<List<Client>>(clientService.getClientByCID(id), HttpStatus.OK);
	}

}
