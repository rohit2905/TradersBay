package com.example.service;

import java.util.List;

import com.example.beans.History;

public interface IHistoryService {

	History saveHistory(History h);

	History getByID(int id);

	List<History> getAll();

}