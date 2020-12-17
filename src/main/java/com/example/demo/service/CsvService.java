package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Csv;
import com.example.demo.repository.CsvRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class CsvService {

	@Autowired
	private CsvRepository repository;

	public List<Csv> findAll() {
		return repository.findAll();
	}

	public Csv findOne(Integer id) {
	    Optional<Csv> csv = repository.findById(id);
	    if(csv.isPresent()) {
	       return csv.get();
	    }else {
	       return null;
	    }
	}

	public void save(Csv csv) {
		repository.save(csv);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
