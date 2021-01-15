package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Nen;
import com.example.demo.repository.NenRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class NenService {

	@Autowired
	NenRepository repository;

	public List<Nen> findAll() {
		return repository.findAll();
	}

	public Nen findOne(Integer id) {
	    Optional<Nen> nen = repository.findById(id);
	    if(nen.isPresent()) {
	       return nen.get();
	    }else {
	       return null;
	    }
	}

	public Nen save(Nen nen) {
		return repository.save(nen);
	}

	public Nen saveAll(List<Nen> nens) {
		repository.saveAll(nens);
		return null;
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}