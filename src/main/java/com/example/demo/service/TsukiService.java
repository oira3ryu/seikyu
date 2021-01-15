package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Tsuki;
import com.example.demo.repository.TsukiRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class TsukiService {

	@Autowired
	TsukiRepository repository;

	public List<Tsuki> findAll() {
		return repository.findAll();
	}

	public Tsuki findOne(Integer id) {
	    Optional<Tsuki> tsuki = repository.findById(id);
	    if(tsuki.isPresent()) {
	       return tsuki.get();
	    }else {
	       return null;
	    }
	}

	public Tsuki save(Tsuki tsuki) {
		return repository.save(tsuki);
	}

	public Tsuki saveAll(List<Tsuki> tsukis) {
		repository.saveAll(tsukis);
		return null;
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}