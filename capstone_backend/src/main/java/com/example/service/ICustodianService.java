package com.example.service;

import java.util.List;

import com.example.beans.Custodian;

public interface ICustodianService {

	Custodian saveCustodian(Custodian custodian);

	Custodian getCustodianById(String id);

	List<Custodian> getAllCustodians();

}