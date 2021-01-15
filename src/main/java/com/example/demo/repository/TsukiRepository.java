package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tsuki;
@Repository
	public interface TsukiRepository extends JpaRepository<Tsuki, Integer> {

}