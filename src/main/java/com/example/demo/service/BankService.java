package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Bank;
import com.example.demo.repository.BankRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class BankService {

	@Autowired
	BankRepository repository;

	public List<Bank> findAll() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public Bank findOne(Integer id) {
	    Optional<Bank> bank = repository.findById(id);
	    if(bank.isPresent()) {
	       return bank.get();
	    }else {
	       return null;
	    }
	}

	public Bank save(Bank bank) {
		return repository.save(bank);
	}

	public Bank saveAll(List<Bank> banks) {
		repository.saveAll(banks);
		return null;
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}