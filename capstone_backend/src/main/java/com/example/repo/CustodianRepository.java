package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.beans.Custodian;

@Repository
public interface CustodianRepository extends JpaRepository<Custodian, String> {

}
