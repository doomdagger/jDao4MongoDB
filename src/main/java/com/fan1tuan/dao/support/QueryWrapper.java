package com.fan1tuan.dao.support;


import com.fan1tuan.dao.support.common.CriteriaWrapper;
import com.fan1tuan.dao.support.common.Pageable;
import com.fan1tuan.dao.support.common.Pair;
import com.fan1tuan.dao.support.query.FieldFilter;
import org.springframework.data.mongodb.core.query.Field;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Map;

/**
 * Wrap Query Object
 * @author Li He
 */
public class QueryWrapper {

	public static Query wrap(String id){
		return wrap(CriteriaWrapper.instance().is("id", id), null, null);
	}
	
	public static Query wrap(CriteriaWrapper criteriaWrapper){
		return wrap(criteriaWrapper, null, null);
	}
	

	public static Query wrap(FieldFilter fieldFilter){
		return wrap(null, fieldFilter, null);
	}
	
	public static Query wrap(FieldFilter fieldFilter, Pageable pageable){
		return wrap(null, fieldFilter, pageable);
	}
	
	public static Query wrap(CriteriaWrapper criteriaWrapper, FieldFilter fieldFilter, Pageable pageable){
		Query query = null;
		if(criteriaWrapper==null||criteriaWrapper.getCriteria()==null){
			query = new Query();
		}else{
			query = new Query(criteriaWrapper.getCriteria());
		}
		
		if(fieldFilter!=null){

            Field field = query.fields();
            for(String include : fieldFilter.getIncludedFields()){
                field.include(include);
            }

            for(String exclude : fieldFilter.getExcludedFields()){
                field.exclude(exclude);
            }

            for(Map.Entry<String,Integer> entry : fieldFilter.getPositions().entrySet()){
                field.position(entry.getKey(),entry.getValue());
            }

            for(Map.Entry<String, Pair<Integer,Integer>> entry : fieldFilter.getSlices().entrySet()){
                field.slice(entry.getKey(),entry.getValue().getName(), entry.getValue().getValue());
            }

		}
		
		if(pageable!=null){
			query.skip(pageable.getOffset()).limit(pageable.getPageSize());
		}
		
		return query;

	}
	
}
