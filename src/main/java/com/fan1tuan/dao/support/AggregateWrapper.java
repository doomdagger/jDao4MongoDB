package com.fan1tuan.dao.support;

import com.fan1tuan.dao.support.aggregate.Group;
import com.fan1tuan.dao.support.aggregate.Project;
import com.fan1tuan.dao.support.common.CriteriaWrapper;
import com.fan1tuan.dao.support.common.Pageable;
import com.fan1tuan.dao.support.common.Sortable;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Li He on 2014/4/11.
 * @author Li He
 */
public class AggregateWrapper {

    private List<AggregationOperation> operations;

    /**
     * wrap the Aggregation Object
     * @param match Criteria
     * @param group Group info
     * @param project Project Info
     * @param pageable page info
     * @param sortable sort info
     * @param field unwind field("" or null will be omitted)
     * @return Aggregation Object
     */
    public static Aggregation wrap(CriteriaWrapper match, Group group, Project project, Pageable pageable, Sortable sortable, String field){
        List<AggregationOperation> oper = AggregateWrapper.instance().match(match).group(group).project(project).page(pageable).sort(sortable).unwind(field).getOperations();
        return Aggregation.newAggregation(oper.toArray(new AggregationOperation[oper.size()]));
    }

    private AggregateWrapper(){
        operations = new ArrayList<>();
    }

    private static AggregateWrapper instance(){
        return new AggregateWrapper();
    }

    private AggregateWrapper match(CriteriaWrapper criteriaWrapper){
        if(criteriaWrapper!=null){
            operations.add(Aggregation.match(criteriaWrapper.getCriteria()));
        }
        return this;
    }

    private AggregateWrapper group(Group group){
        if(group!=null)
            operations.add(group.getGroupOperation());
        return this;
    }

    private AggregateWrapper page(Pageable pageable){
        if(pageable!=null) {
            operations.add(Aggregation.limit(pageable.getPageSize()));
            operations.add(Aggregation.skip(pageable.getOffset()));
        }
        return this;
    }

    private AggregateWrapper project(Project project){
        if(project!=null) {
            operations.add(project.getProjectionOperation());
        }
        return this;
    }

    private AggregateWrapper sort(Sortable sortable){
        if(sortable!=null) {
            operations.add(Aggregation.sort(sortable.toSort()));
        }
        return this;
    }

    private  AggregateWrapper unwind(String field){
        if(field!=null&&!"".equals(field)) {
            operations.add(Aggregation.unwind(field));
        }
        return this;
    }

    private List<AggregationOperation> getOperations(){
        return operations;
    }
}
