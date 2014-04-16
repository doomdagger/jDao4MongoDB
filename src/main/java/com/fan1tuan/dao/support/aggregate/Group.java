package com.fan1tuan.dao.support.aggregate;

import org.springframework.data.mongodb.core.aggregation.ExposedFields;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;

/**
 * Group Class for aggregate operation
 * Equals to Group by fields in SQL Grammar
 * @author Li He
 */
public class Group {
    private GroupOperation groupOperation;

    private Group(String... fields){
        groupOperation = new GroupOperation(Fields.fields(fields));
    }
    private Group(Fields fields){
        groupOperation = new GroupOperation(fields);
    }

    public static Group instance(String... fields){
        return new Group(fields);
    }

    public static Group instance(Fields fields){
        return new Group(fields);
    }

    /**
     *  $add_to_set-expression for the given value
     * @param value given value
     * @param alias alias name
     * @return group object
     */
    public Group addToSet(Object value, String alias){
        groupOperation.addToSet(value).as(alias);
        return this;
    }

    /**
     * $add_to_set-expression for the given field-reference.
     * @param reference reference field
     * @param alias alias name
     * @return group object
     */
    public Group addToSet(String reference, String alias){
        groupOperation.addToSet(reference).as(alias);
        return this;
    }

    /**
     * $avg-expression for the given field-reference.
     * @param reference reference field
     * @param alias alias name
     * @return group object
     */
    public Group avg(String reference, String alias){
        groupOperation.avg(reference).as(alias);
        return this;
    }
    /**
     * $count-expression
     * @param alias alias name
     * @return group object
     */
    public Group count(String alias){
        groupOperation.count().as(alias);
        return this;
    }

    /**
     * $first-expression for the given field-reference.
     * @param reference reference field
     * @param alias alias name
     * @return group object
     */
    public Group first(String reference, String alias){
        groupOperation.first(reference).as(alias);
        return this;
    }
    /**
     * $last-expression for the given field-reference.
     * @param reference reference field
     * @param alias alias name
     * @return group object
     */
    public Group last(String reference, String alias){
        groupOperation.last(reference).as(alias);
        return this;
    }

    /**
     * $max-expression for the given field-reference.
     * @param reference reference field
     * @param alias alias name
     * @return group object
     */
    public Group max(String reference, String alias){
        groupOperation.max(reference).as(alias);
        return this;
    }

    /**
     * $min-expression for the given field-reference.
     * @param reference reference field
     * @param alias alias name
     * @return group object
     */
    public Group min(String reference, String alias){
        groupOperation.min(reference).as(alias);
        return this;
    }

    /**
     *  $push-expression for the given value
     * @param value given value
     * @param alias alias name
     * @return group object
     */
    public Group push(Object value, String alias){
        groupOperation.push(value).as(alias);
        return this;
    }

    /**
     * $push-expression for the given field-reference.
     * @param reference reference field
     * @param alias alias name
     * @return group object
     */
    public Group push(String reference, String alias){
        groupOperation.push(reference).as(alias);
        return this;
    }

    /**
     * $sum-expression for the given field-reference.
     * @param reference reference field
     * @param alias alias name
     * @return group object
     */
    public Group sum(String reference, String alias){
        groupOperation.sum(reference).as(alias);
        return this;
    }


    public ExposedFields getFields(){
        return groupOperation.getFields();
    }
    public GroupOperation getGroupOperation(){
        return groupOperation;
    }
}
