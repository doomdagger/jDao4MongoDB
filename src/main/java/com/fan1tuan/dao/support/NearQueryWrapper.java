package com.fan1tuan.dao.support;

import com.fan1tuan.dao.support.common.CriteriaWrapper;
import com.fan1tuan.dao.support.common.NearCriteriaWrapper;
import com.fan1tuan.dao.support.common.Pageable;
import com.fan1tuan.dao.support.common.Sortable;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Geo Query Wrapper, add additional conditions for NearQuery Object
 * @author Li He
 */
public class NearQueryWrapper {
	public static NearQuery wrap(NearCriteriaWrapper criteriaWrapper){
		return criteriaWrapper.getNearQuery();
	}
	
	public static NearQuery wrap(NearCriteriaWrapper criteriaWrapper, Pageable pageable){
        return wrap(criteriaWrapper).skip(pageable.getOffset()).num(pageable.getPageSize());
	}
	
	public static NearQuery wrap(NearCriteriaWrapper criteriaWrapper, Pageable pageable, Sortable sortable){
        return wrap(criteriaWrapper,pageable).query(QueryWrapper.wrap((CriteriaWrapper)null).with(sortable.toSort()));
	}
	
	public static NearQuery wrap(NearCriteriaWrapper criteriaWrapper, Query query){
        return wrap(criteriaWrapper).query(query);
	}
}
