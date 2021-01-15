package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Syubetsu;
import com.example.demo.repository.SyubetsuRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class SyubetsuService {

	@Autowired
	SyubetsuRepository repository;

	public List<Syubetsu> findAll() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public Syubetsu findOne(Integer id) {
	    Optional<Syubetsu> syubetsu = repository.findById(id);
	    if(syubetsu.isPresent()) {
	       return syubetsu.get();
	    }else {
	       return null;
	    }
	}

	public Syubetsu save(Syubetsu syubetsu) {
		return repository.save(syubetsu);
	}

	public void saveAll(List<Syubetsu> syubetsus) {
		repository.saveAll(syubetsus);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
