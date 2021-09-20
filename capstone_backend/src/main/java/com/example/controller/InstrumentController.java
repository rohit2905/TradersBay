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


import com.example.beans.Instrument;

import com.example.service.IInstrumentService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class InstrumentController {
	@Autowired
	IInstrumentService instrumentService;
	

	@PostMapping("/instrument")
	public ResponseEntity<Instrument> postInstrument(@RequestBody Instrument instrument){
		return new ResponseEntity<Instrument>(instrumentService.saveInstrument(instrument), HttpStatus.OK);
	}
	
	@GetMapping("/instrument/{id}")
	public ResponseEntity<Instrument> getById(@PathVariable String id){
		return new ResponseEntity<Instrument>(instrumentService.getInstrumentyId(id), HttpStatus.OK);
	}
	
	@GetMapping("/instruments")
	public ResponseEntity<List<Instrument>> getAll(){
		return new ResponseEntity<List<Instrument>>(instrumentService.getAllInstruments(), HttpStatus.OK);
	}
	

}
