package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.beans.History;


@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {

}
