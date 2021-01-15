package com.example.demo.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.example.demo.model.Csv;

public class CsvSpecifications {

	private CsvSpecifications() {

	}

    /**
     * 種別idが一致するデータを検索
     */
    public static Specification<Csv> sidStr(String sid) {

    	if (StringUtils.isBlank(sid)) {
    		return null;
    	}

        return new Specification<Csv>() {
            @Override
            public Predicate toPredicate(Root<Csv> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("sid"), sid);
            }
        };
    }

    /**
     * 事業所idが一致するデータを検索
     */
    public static Specification<Csv> gidStr(String gid) {

    	if (StringUtils.isBlank(gid)) {
    		return null;
    	}

        return new Specification<Csv>() {
            @Override
            public Predicate toPredicate(Root<Csv> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("gid"), gid);
            }
        };
    }

    /**
     * 年が一致するデータを検索
     */
    public static Specification<Csv> nenStr(String nen) {

    	if (StringUtils.isBlank(nen)) {
    		return null;
    	}

        return new Specification<Csv>() {
            @Override
            public Predicate toPredicate(Root<Csv> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            	return cb.equal(root.get("nen"), nen);
            }
        };
    }

    /**
     * 月が一致するデータを検索
     */
    public static Specification<Csv> tsukiStr(String tsuki) {

    	if (StringUtils.isBlank(tsuki)) {
    		return null;
    	}

        return new Specification<Csv>() {
            @Override
            public Predicate toPredicate(Root<Csv> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("tsuki"), tsuki);
            }
        };
    }
}
