package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.beans.SellOrders;

@Repository
public interface SellOrdersRepository extends JpaRepository<SellOrders,Integer> {

}
