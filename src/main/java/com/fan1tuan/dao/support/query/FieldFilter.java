package com.fan1tuan.dao.support.query;


import com.fan1tuan.dao.support.common.Pair;

import java.util.*;

/**
 * Projection message, return partial fields of an document
 * @author Li He
 */
public class FieldFilter {

    private List<String> includedFields = new ArrayList<>();
	private List<String> excludedFields = new ArrayList<>();

    private Map<String,Integer> positions = new HashMap<>();
    private Map<String,Pair<Integer,Integer>> slices = new HashMap<>();

	private FieldFilter() {
	}
	
	private FieldFilter(String field){
		includedFields.add(field);
	}
	
    public static FieldFilter instance(){
        return new FieldFilter();
    }

    public FieldFilter include(String... fields){
        includedFields.addAll(Arrays.asList(fields));
        return this;
    }

    public FieldFilter exclude(String... fields){
        excludedFields.addAll(Arrays.asList(fields));
        return this;
    }

    public FieldFilter position(String key, int position){
        positions.put(key,position);
        return this;
    }

    public FieldFilter slice(String key, int start, int end){
        slices.put(key, new Pair<Integer, Integer>(start,end));
        return this;
    }

    /*************************** Deprecate old method ***************************/
    @Deprecated
	public static FieldFilter instance(String field){
		FieldFilter filter = new FieldFilter(field);
		return filter;
	}
    @Deprecated
	public static FieldFilter instance(Collection<String> fields){
		FieldFilter filter = new FieldFilter();
		filter.addAll(fields);
		return filter;
	}
    @Deprecated
    public static FieldFilter instance(String... fields){
		FieldFilter filter = new FieldFilter();
		filter.addAll(Arrays.asList(fields));
		return filter;
	}
    @Deprecated
	public FieldFilter add(String field){
		this.includedFields.add(field);
		return this;
	}
    @Deprecated
	public FieldFilter addAll(Collection<String> fields){
		this.includedFields.addAll(fields);
		return this;
	}
    @Deprecated
	public FieldFilter addAll(String... fields){
		this.includedFields.addAll(Arrays.asList(fields));
		return this;
	}
    /**
     * use getIncludedFields() instead
     * @return includedFields list
     */
    @Deprecated
	public List<String> getParams(){
		return this.includedFields;
	}

    /*********************************** Deprecate method end **********************************************/


    public List<String> getIncludedFields() {return this.includedFields;}

    public Map<String, Integer> getPositions() {
        return positions;
    }

    public Map<String, Pair<Integer, Integer>> getSlices() {
        return slices;
    }

    public List<String> getExcludedFields() {
        return excludedFields;
    }
}
