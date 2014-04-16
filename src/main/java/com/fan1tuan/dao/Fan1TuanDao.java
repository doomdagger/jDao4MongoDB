package com.fan1tuan.dao;


import com.fan1tuan.dao.support.aggregate.Group;
import com.fan1tuan.dao.support.aggregate.Project;
import com.fan1tuan.dao.support.common.CriteriaWrapper;
import com.fan1tuan.dao.support.common.Pageable;
import com.fan1tuan.dao.support.common.Sortable;
import com.fan1tuan.dao.support.query.FieldFilter;
import com.fan1tuan.dao.support.update.UpdateWrapper;
import com.mongodb.CommandResult;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.CollectionCallback;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoResults;
import org.springframework.data.mongodb.core.geo.Metric;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.core.index.IndexDefinition;
import org.springframework.data.mongodb.core.index.IndexInfo;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;

import java.util.Collection;
import java.util.List;


/**
 * revised interface for fan1tuan, update all comments here, add more flexibility for
 * DAO Access Object, feel free to put forward issues to me. Enjoy the class:) .
 * @author Li He
 * @param <T>
 */
public interface Fan1TuanDao<T> {

    /**
     * Add a entity
     * @param paramT entity
     */
	void add(T paramT);

    /**
     * add multiple entities belong to the generic type
     * @param paramTs multiple entities with same type
     */
	void addMulti(Collection<T> paramTs);

    /**
     * Add multiple entities belong to any type
     * the template class will decide that for you
     * @param paramTs multiple entities with different types
     */
    void addMultiMix(Collection<?> paramTs);

    /**
     * No use method
     * @param paramTs multiple entities with same type
     */
    @Deprecated
	void addMultiOneByOne(Collection<T> paramTs);


    /**
     * update entity according to its id
     * override all its attribute
     * @param paramT entity
     */
	void update(T paramT);

    /**
     * update first match entity with given criteria and update message
     * @param criteriaWrapper criteria
     * @param UpdateWrapper update message
     * @return object to record the db change
     */
	WriteResult updateFirstByParams(CriteriaWrapper criteriaWrapper, UpdateWrapper UpdateWrapper);
    WriteResult updateFirstByParams(String id, UpdateWrapper UpdateWrapper);

    /**
     * update multiple match entities with given criteria and update message
     * @param criteriaWrapper criteria
     * @param UpdateWrapper update message
     * @return object to record the db change
     */
	WriteResult updateMultiByParams(CriteriaWrapper criteriaWrapper, UpdateWrapper UpdateWrapper);
	WriteResult updateMultiByParams(CriteriaWrapper criteriaWrapper, UpdateWrapper updateWrapper, Pageable pageable, Sortable sortable);

    /**
     * insert entity if find nothing according to the criteria
     * @param criteriaWrapper criteria
     * @param UpdateWrapper update message
     * @return object to record the db change
     */
    WriteResult upsert(CriteriaWrapper criteriaWrapper, UpdateWrapper UpdateWrapper);
    WriteResult upsert(String id, UpdateWrapper UpdateWrapper);

    /**
     * remove an entity according to id
     * @param id id of the entity object
     */
	void delete(String id);

    /**
     * remove an entity according to id
     * @param paramT entity
     */
	void delete(T paramT);

    /**
     * remove multiple entities according to given criteria
     * @param criteriaWrapper criteria
     */
	void deleteByParams(CriteriaWrapper criteriaWrapper);

    /**
     * find entity by the given id
     * @param id id of the entity object
     * @return entity
     */
	T findOneById(String id);

    /**
     * find entity by the given id, and return only part of the entity for efficiency
     * @param id id of the entity object
     * @param fieldFilter fields should be returned
     * @return entity with partial fields has value
     */
	T findOneProjectedById(String id, FieldFilter fieldFilter);

    /**
     * find entity by the given criteria
     * @param criteriaWrapper criteria
     * @return entity
     */
	T findOneByParams(CriteriaWrapper criteriaWrapper);

    /**
     * find entity by the given id, and return only part of the entity for efficiency
     * @param criteriaWrapper criteria
     * @param filFieldFilter fields should be returned
     * @return entity with partial fields has value
     */
	T findOneProjectedByParams(CriteriaWrapper criteriaWrapper, FieldFilter filFieldFilter);


    /**
     * find multiple entities according to the given criteria
     * @param criteriaWrapper criteria
     * @return list of entities
     */
	List<T> findByParams(CriteriaWrapper criteriaWrapper);

    /**
     * find multiple entities according to the given criteria in a specific order
     * @param criteriaWrapper criteria
     * @param sortable sort message
     * @return list of entities
     */
	List<T> findByParamsInOrder(CriteriaWrapper criteriaWrapper, Sortable sortable);

    /**
     * find multiple entities according to the given criteria using skip and limit
     * @param criteriaWrapper criteria
     * @param pageable page message
     * @return list of entities
     */
	List<T> findByParamsInPage(CriteriaWrapper criteriaWrapper, Pageable pageable);

    /**
     * find multiple entities according to the given criteria using skip and limit in a specific order
     * @param criteriaWrapper criteria
     * @param pageable page message
     * @param sortable sort message
     * @return list of entities
     */
	List<T> findByParamsInPageInOrder(CriteriaWrapper criteriaWrapper, Pageable pageable, Sortable sortable);

    /**
     * same with above only has partial fields returned with value
     * @param criteriaWrapper criteria
     * @param filter fields should be returned
     * @return list of entities
     */
	List<T> findProjectedByParams(CriteriaWrapper criteriaWrapper, FieldFilter filter);
	List<T> findProjectedByParamsInOrder(CriteriaWrapper criteriaWrapper, FieldFilter filter, Sortable sortable);

	List<T> findProjectedByParamsInPage(CriteriaWrapper criteriaWrapper, FieldFilter filter, Pageable pageable);
	List<T> findProjectedByParamsInPageInOrder(CriteriaWrapper criteriaWrapper, FieldFilter filter, Pageable pageable, Sortable sortable);


    /**
     * using to list of id to execute find action
     * @param ids list of id
     * @return list of entities
     */
	List<T> findMultiByIds(String... ids);
	List<T> findMultiByIdsInOrder(Sortable sortable, String... ids);

    /**
     * find all entities in the collection
     * @return list of entities
     */
	List<T> findAll();
	List<T> findAllInOrder(Sortable sortable);


	List<T> findAllInPage(Pageable pageable);
	List<T> findAllInPageInOrder(Pageable pageable, Sortable sortable);

	

	List<T> findProjectedAll(String... fields);
	List<T> findProjectedAllInOrder(Sortable sortable, String... fields);

	List<T> findProjectedAll(FieldFilter filter);
	List<T> findProjectedAllInOrder(FieldFilter filter, Sortable sortable);


	List<T> findProjectedAllInPage(Pageable pageable, String... fields);
	List<T> findProjectedAllInPageInOrder(Pageable pageable, Sortable sortable, String... fields);

	List<T> findProjectedAllInPage(Pageable pageable, FieldFilter filter);
	List<T> findProjectedAllInPageInOrder(Pageable pageable, FieldFilter filter, Sortable sortable);


    /**
     * get count according to the given criteria
     * @param criteriaWrapper criteria
     * @return long value stands for number of items
     */
	long getCount(CriteriaWrapper criteriaWrapper);

    /**
     * given the specified page size and criteria, tell me number of pages
     * @param criteriaWrapper criteria
     * @param pageSize number of items per page
     * @return long value stands for number of pages
     */
	long getPageCount(CriteriaWrapper criteriaWrapper, int pageSize);

    /**
     * the collection represented by the generic type exists or not
     * @return boolean value, true for yes, false for no.
     */
    boolean collectionExists();

    /**
     * drop the collection represented by the generic type
     */
    void dropCollection();

    /**
     * according to the given criteria, are there any record fulfill the criteria in the collection
     * @param criteriaWrapper criteria
     * @return true or false. true: at lease has one. false: 0.
     */
    boolean exists(CriteriaWrapper criteriaWrapper);

    /**
     * want to get the original dbCollection object
     * @return dbCollection object in mongodb driver
     */
    DBCollection getCollection();

    /**
     * want to get the collection name in mongodb
     * @return name of collection represented by the generic type
     */
    String getCollectionName();


    /***************************** advanced **********************************/
    /**
     *
     * execute with collection callback
     *
     * execute with db callback
     *
     * execute original command object
     *
     * execute origin command string
     *
     * execute mass write operations in single session

     */
    T execute(CollectionCallback<T> callback);

    T execute(DbCallback<T> action);

    CommandResult executeCommand(DBObject command);
    CommandResult executeCommand(String jsonCommand);

    T executeInSession(DbCallback<T> action);


    /**
     * map reduce framework
     * @param mapFunction map function -- content
     * @param reduceFunction reduce function -- content
     * @param outCls output class type
     * @return map reduce results
     * @see com.fan1tuan.dao.support.mapReduce.JavaScriptExtractor
     */
    MapReduceResults<?> mapReduceAll(String mapFunction, String reduceFunction, Class<?> outCls);
    MapReduceResults<?> mapReduceAll(String mapFunction, String reduceFunction, MapReduceOptions mapReduceOptions, Class<?> outCls);

    MapReduceResults<?> mapReduceByParam(CriteriaWrapper criteria, String mapFunction, String reduceFunction, Class<?> outCls);
    MapReduceResults<?> mapReduceByParam(CriteriaWrapper criteria, String mapFunction, String reduceFunction, MapReduceOptions mapReduceOptions, Class<?> outCls);

    MapReduceResults<?> mapReduceByParamInPage(CriteriaWrapper criteria, Pageable pageable, String mapFunction, String reduceFunction, Class<?> outCls);
    MapReduceResults<?> mapReduceByParamInPage(CriteriaWrapper criteria, Pageable pageable, String mapFunction, String reduceFunction, MapReduceOptions mapReduceOptions, Class<?> outCls);

    MapReduceResults<?> mapReduceByParamInPageInOrder(CriteriaWrapper criteria, Pageable pageable, Sortable sortable, String mapFunction, String reduceFunction, Class<?> outCls);
    MapReduceResults<?> mapReduceByParamInPageInOrder(CriteriaWrapper criteria, Pageable pageable, Sortable sortable, String mapFunction, String reduceFunction, MapReduceOptions mapReduceOptions, Class<?> outCls);

    /**
     * aggregate operation
     * @param group group info
     * @param outCls output class type
     * @return aggregation result type wrap a list of output entity
     */
    AggregationResults<?> aggregate(Group group, Class<?> outCls);
    AggregationResults<?> aggregate(Group group, Project project, Class<?> outCls);
    AggregationResults<?> aggregate(CriteriaWrapper criteria, Group group, Class<?> outCls);
    AggregationResults<?> aggregate(CriteriaWrapper criteria, Group group, Project project, Class<?> outCls);

    /**
     * all params are nullable
     * @param criteria criteria
     * @param group group
     * @param project project
     * @param pageable page
     * @param sortable sort
     * @param outCls output class type
     * @return list of output class type wrap in AggregationResults
     */
    AggregationResults<?> aggregate(CriteriaWrapper criteria, Group group, Project project, Pageable pageable, Sortable sortable, Class<?> outCls);


    /**
     * drop all index on the collection
     */
    void dropAllIndexes();

    /**
     * drop the index on the collection has the given name
     * @param indexName index name
     */
    void dropIndex(String indexName);

    /**
     * ensure the existence of the index according to the indexDefinition
     * @param indexDefinition contains the original object defined by mongodb driver
     */
    void ensureIndex(IndexDefinition indexDefinition);

    /**
     * get all the index info on the collection
     * @return list of index info object
     */
    List<IndexInfo> getIndexInfo();

    /**
     * clear all the no use index on the collection
     */
    void resetIndexCache();
    /**
     * geo search
     * @param x center x
     * @param y center y
     * @param distance max distance
     * @param metric distance unit
     * @return list of Entity Contain Position info
     */
    GeoResults<T> findByPointAndDistance(double x, double y, double distance, Metric metric);
    GeoResults<T> findByPointAndDistance(Point center, Distance maxDistance);
    GeoResults<T> findByPointAndDistanceInPage(double x, double y, double distance, Metric metric, Pageable pageable);
    GeoResults<T> findByPointAndDistanceInPage(Point center, Distance maxDistance, Pageable pageable);
    GeoResults<T> findByPointAndDistanceInPageInOrder(double x, double y, double distance, Metric metric, Pageable pageable, Sortable sortable);
    GeoResults<T> findByPointAndDistanceInPageInOrder(Point center, Distance maxDistance, Pageable pageable, Sortable sortable);

    GeoResults<T> findByPointAndDistanceWithParam(Point center, Distance maxDistance, CriteriaWrapper criteriaWrapper);
    GeoResults<T> findByPointAndDistanceWithParamInPage(Point center, Distance maxDistance, CriteriaWrapper criteriaWrapper, Pageable pageable);
    GeoResults<T> findByPointAndDistanceWithParamInPageInOrder(Point center, Distance maxDistance, CriteriaWrapper criteriaWrapper, Pageable pageable, Sortable sortable);

    /**
     * save this message for child class invocation
     * @return generic entity class
     */
    Class<T> getParameterizedClass();
}
