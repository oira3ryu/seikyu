package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Office;
import com.example.demo.repository.OfficeRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class OfficeService {

	@Autowired
	OfficeRepository repository;

	public List<Office> findAll() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public Office findOne(Integer id) {
	    Optional<Office> office = repository.findById(id);
	    if(office.isPresent()) {
	       return office.get();
	    }else {
	       return null;
	    }
	}

	public Office save(Office office) {
		return repository.save(office);
	}

	public Office saveAll(List<Office> offices) {
		repository.saveAll(offices);
		return null;
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}