package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.History;
import com.example.repo.HistoryRepository;

@Service
public class HistoryService implements IHistoryService {

	@Autowired
	HistoryRepository historyRepository;
	
	@Override
	public History saveHistory(History h) {
		if(h!=null) {
		 return historyRepository.save(h);
		}
		else
		{
			return  null;
		}
	}
	
	@Override
	public History getByID(int id) {
		if(id>0) {
		return historyRepository.findById(id).get();
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public List<History> getAll(){
		return historyRepository.findAll();
	}
	
}
