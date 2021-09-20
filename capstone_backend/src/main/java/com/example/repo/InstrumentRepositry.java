package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.beans.Instrument;

public interface InstrumentRepositry extends JpaRepository<Instrument, String> {

}
