package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Syubetsu;
import com.example.demo.repository.SyubetsuRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class SyubetsuService {

	@Autowired
	private SyubetsuRepository repository;

	public List<Syubetsu> findAll() {
		return repository.findAll();
	}

	public Syubetsu findOne(Integer id) {
	    Optional<Syubetsu> Syubetsu = repository.findById(id);
	    if(Syubetsu.isPresent()) {
	       return Syubetsu.get();
	    }else {
	       return null;
	    }
	}

	public void save(Syubetsu Syubetsu) {
		repository.save(Syubetsu);
	}

	public void saveAll(List<Syubetsu> Syubetsus) {
		repository.saveAll(Syubetsus);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
