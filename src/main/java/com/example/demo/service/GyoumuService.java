package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Gyoumu;
import com.example.demo.repository.GyoumuRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class GyoumuService {

	@Autowired
	GyoumuRepository repository;

	public List<Gyoumu> findAll() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public Gyoumu findOne(Integer id) {
	    Optional<Gyoumu> gyoumu = repository.findById(id);
	    if(gyoumu.isPresent()) {
	       return gyoumu.get();
	    }else {
	       return null;
	    }
	}

	public Gyoumu save(Gyoumu gyoumu) {
		return repository.save(gyoumu);
	}

	public Gyoumu saveAll(List<Gyoumu> gyoumus) {
		repository.saveAll(gyoumus);
		return null;
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}