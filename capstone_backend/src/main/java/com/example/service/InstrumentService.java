package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.beans.Instrument;
import com.example.repo.InstrumentRepositry;

@Service
public class InstrumentService implements IInstrumentService {
	
	@Autowired
	InstrumentRepositry instrumentRepositry;
	
	@Override
	public Instrument getInstrument(Instrument instrument) {
		if(instrument!=null) {
		return instrumentRepositry.save(instrument);
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public Instrument getInstrumentyId(String id) {
		if(id!=null) {
		return instrumentRepositry.findById(id).get();
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public List<Instrument> getAllInstruments(){
		return instrumentRepositry.findAll();
	}
	@Override
	public Instrument saveInstrument(Instrument instrument) {
		if(instrument!=null){
		return instrumentRepositry.save(instrument);
		}
		else {
			return null;
		}
	}

}
