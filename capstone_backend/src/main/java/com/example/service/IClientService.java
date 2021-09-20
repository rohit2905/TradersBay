package com.example.service;

import java.util.List;

import com.example.beans.Client;

public interface IClientService {

	Client saveClient(Client client);

	Client getClientById(String id);

	List<Client> getAllClient();

	List<Client> getClientByCID(String id);

}