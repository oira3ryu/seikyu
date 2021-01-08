package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.test;
import com.example.demo.repository.testRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class testService {

	@Autowired
	private testRepository repository;

	public List<test> findAll() {
		return repository.findAll();
	}

	public test findOne(Integer id) {
	    Optional<test> test = repository.findById(id);
	    if(test.isPresent()) {
	       return test.get();
	    }else {
	       return null;
	    }
	}

	public void save(test test) {
		repository.save(test);
	}

	public void saveAll(List<test> tests) {
		repository.saveAll(tests);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}

