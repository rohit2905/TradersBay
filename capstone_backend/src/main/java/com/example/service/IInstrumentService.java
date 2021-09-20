package com.example.service;

import java.util.List;

import com.example.beans.Instrument;

public interface IInstrumentService {

	Instrument getInstrument(Instrument instrument);

	Instrument getInstrumentyId(String id);

	List<Instrument> getAllInstruments();
	
	public Instrument saveInstrument(Instrument instrument);

}