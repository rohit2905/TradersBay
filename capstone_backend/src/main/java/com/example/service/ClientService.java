package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.Client;

import com.example.repo.ClientRepositry;

@Service
public class ClientService implements IClientService {

	@Autowired
	ClientRepositry clientRepositry;
	
	@Override
	public Client saveClient(Client client) {
		if(client!=null){
		return clientRepositry.save(client);
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public Client getClientById(String id) {
		if(id!=null) {
		return clientRepositry.findById(id).get();
		}
		else
		{
			return null;
			
		}
	}
	
	@Override
	public List<Client> getAllClient(){
		return clientRepositry.findAll();
	}
	
	@Override
	public List<Client> getClientByCID(String id) {
		// TODO Auto-generated method stub
		List<Client> c = getAllClient();
		List<Client> v=new ArrayList<Client>();
		for(Client x: c) {
			if(x.getCust_id().equalsIgnoreCase(id)) {
				v.add(x);
			}
		}
		return v;
	}

	
}
