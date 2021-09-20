package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.beans.Client;

public interface ClientRepositry extends JpaRepository<Client, String> {

}
