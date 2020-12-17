package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Csv;
@Repository
	public interface CsvRepository extends JpaRepository<Csv, Integer> {

}