package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Syubetsu;
@Repository
	public interface SyubetsuRepository extends JpaRepository<Syubetsu, Integer> {

}