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
import com.example.beans.History;
import com.example.service.HistoryService;
@CrossOrigin
@RestController
@RequestMapping("api")
public class HistoryController {

	@Autowired
	HistoryService historyService;
	
	@PostMapping("/history")
	public ResponseEntity<History> postHistory(@RequestBody History history){
		return new ResponseEntity<History>(historyService.saveHistory(history), HttpStatus.OK);
	}
	
	@GetMapping("/history/{id}")
	public ResponseEntity<History> getById(@PathVariable int id){
		return new ResponseEntity<History>(historyService.getByID(id), HttpStatus.OK);
	}
	
	@GetMapping("/historys")
	public ResponseEntity<List<History>> getAll(){
		return new ResponseEntity<List<History>>(historyService.getAll(), HttpStatus.OK);
	}
}
