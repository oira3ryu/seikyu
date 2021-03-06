package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.example.demo.form.CsvSearchForm;
import com.example.demo.model.Csv;
import com.example.demo.repository.CsvRepository;
import com.example.demo.specification.CsvSpecifications;

@Service
@Transactional(rollbackOn=Exception.class)
public class CsvService {

	@Autowired
	CsvRepository repository;

	@PersistenceContext
	private EntityManager em;

	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

	public List<Csv> findAll() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public Csv findOne(Integer id) {
	    Optional<Csv> csv = repository.findById(id);
	    if(csv.isPresent()) {
	       return csv.get();
	    }else {
	       return null;
	    }
	}

	public List<Csv> findByForm(CsvSearchForm searchParam) {

        if (searchParam == null) {
            return findAll();
        }

        return repository.findAll(Specification
    			.where(CsvSpecifications.ofidEqual(searchParam.getOfid()))
    			.and(CsvSpecifications.sidEqual(searchParam.getSid()))
        		.and(CsvSpecifications.gidEqual(searchParam.getGid()))
        		.and(CsvSpecifications.nenEqual(searchParam.getNen()))
        		.and(CsvSpecifications.tsukiEqual(searchParam.getTsuki()))
        		, Sort.by(Sort.Direction.ASC, "id"));
    }

	public Csv save(Csv csv) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(csv);
		if (csv.getId() == null) {
			return null;
		}else {
			jdbcTemplate.update(
                    "UPDATE csv SET nen = :nen, tsuki = :tsuki, ofid = :ofid, sid = :sid, gid = :gid WHERE id = :id",
                    param);
		}
		return repository.save(csv);
	}

	public List<Csv> saveAll(List<Csv> csvs) {
		return repository.saveAll(csvs);

	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
