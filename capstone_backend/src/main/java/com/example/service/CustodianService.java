package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.BuyOrders;
import com.example.beans.Custodian;
import com.example.repo.CustodianRepository;

@Service
public class CustodianService implements ICustodianService {

	@Autowired
	CustodianRepository custodianRepo;
	
	@Override
	public Custodian saveCustodian(Custodian custodian) {
		if(custodian!=null){
		return custodianRepo.save(custodian);
		}
		else {
			return null;
		}
	}
	
	@Override
	public Custodian getCustodianById(String id) {
		if(id!=null) {
		return custodianRepo.findById(id).get();
		}
		else {
			return null;
		}
	}
	
	@Override
	public List<Custodian> getAllCustodians(){
		return custodianRepo.findAll();
	}

	
}
