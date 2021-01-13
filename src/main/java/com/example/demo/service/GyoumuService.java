package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Gyoumu;
import com.example.demo.repository.GyoumuRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class GyoumuService {

	@Autowired
	private GyoumuRepository repository;

	public List<Gyoumu> findAll() {
		return repository.findAll();
	}

	public Gyoumu findOne(Integer id) {
	    Optional<Gyoumu> Gyoumu = repository.findById(id);
	    if(Gyoumu.isPresent()) {
	       return Gyoumu.get();
	    }else {
	       return null;
	    }
	}

	public void save(Gyoumu Gyoumu) {
		repository.save(Gyoumu);
	}

	public void saveAll(List<Gyoumu> Gyoumus) {
		repository.saveAll(Gyoumus);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}