package com.example.demo.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.model.Csv;

public class CsvSpecifications {

	private CsvSpecifications() {

	}

    /**
     * 事業所idが一致するデータを検索
     */
    public static Specification<Csv> ofidEqual(String ofid) {

    	if (ofid == null) {
    		return null;
    	}

        return new Specification<Csv>() {
            @Override
            public Predicate toPredicate(Root<Csv> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("ofid"), ofid);
            }
        };
    }

    /**
     * 種別idが一致するデータを検索
     */
    public static Specification<Csv> sidEqual(String sid) {

    	if (sid == null) {
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
     * 業務idが一致するデータを検索
     */
    public static Specification<Csv> gidEqual(String gid) {

    	if (gid == null) {
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
    public static Specification<Csv> nenEqual(String nen) {

    	if (nen == null) {
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
    public static Specification<Csv> tsukiEqual(String tsuki) {

    	if (tsuki == null) {
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
