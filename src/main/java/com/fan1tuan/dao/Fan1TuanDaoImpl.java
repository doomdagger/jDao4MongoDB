package com.fan1tuan.dao;


import com.fan1tuan.dao.support.AggregateWrapper;
import com.fan1tuan.dao.support.NearQueryWrapper;
import com.fan1tuan.dao.support.QueryWrapper;
import com.fan1tuan.dao.support.aggregate.Group;
import com.fan1tuan.dao.support.aggregate.Project;
import com.fan1tuan.dao.support.common.CriteriaWrapper;
import com.fan1tuan.dao.support.common.NearCriteriaWrapper;
import com.fan1tuan.dao.support.common.Pageable;
import com.fan1tuan.dao.support.common.Sortable;
import com.fan1tuan.dao.support.query.FieldFilter;
import com.fan1tuan.dao.support.update.UpdateWrapper;
import com.mongodb.CommandResult;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.mongodb.core.CollectionCallback;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoResults;
import org.springframework.data.mongodb.core.geo.Metric;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.core.index.IndexDefinition;
import org.springframework.data.mongodb.core.index.IndexInfo;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

/**
 * Fan1TuanDaoImpl, implementation of Dao Interface
 * @param <T>
 */
public class Fan1TuanDaoImpl<T> implements Fan1TuanDao<T>{

	private Logger logger; 
	
	protected MongoTemplate mongoTemplate;

	public MongoTemplate getMongoTemplate(){
		return mongoTemplate;
	}
	
	
	private Class<T> cls;
	/**
	 * Default constructor. 构造函数不传参，但是很重要，为继承的子类抽出泛型的Class对象，以便于 传给DAO方法
	 */
	@SuppressWarnings("unchecked")
	public Fan1TuanDaoImpl() {
		@SuppressWarnings("rawtypes")
		Class clazz = getClass();

		while (clazz != Object.class) {
			Type t = clazz.getGenericSuperclass();
			if (t instanceof ParameterizedType) {
				Type[] args = ((ParameterizedType) t).getActualTypeArguments();
				if (args[0] instanceof Class) {
					this.cls = (Class<T>) args[0];
					break;
				}
			}
			clazz = clazz.getSuperclass();
		}
		
		logger = LogManager.getLogger(getClass().getName());
		

	}
	
	
	@Override
	public void add(T paramT) {
		logger.entry(paramT);
		logger.info("In "+getClass().getName());
		getMongoTemplate().insert(paramT);
		logger.exit();
	}

	@Override
	public void addMulti(Collection<T> paramTs) {
		logger.entry(paramTs);
		logger.info("In "+getClass().getName());
		getMongoTemplate().insert(paramTs);
		logger.exit();
	}

    /**
     * Add multiple entities belong to any type
     * the template class will decide that for you
     *
     * @param paramTs multiple entities with different types
     */
    @Override
    public void addMultiMix(Collection<?> paramTs) {
        getMongoTemplate().insertAll(paramTs);
    }

    @Override
    @Deprecated
	public void addMultiOneByOne(Collection<T> paramTs){
		logger.entry(paramTs);
		logger.info("In "+getClass().getName());
		for(T param : paramTs){
			getMongoTemplate().insert(param);
		}
		logger.exit();
	}

	@Override
	public void update(T paramT) {
		logger.entry(paramT);
		logger.info("In "+getClass().getName());
		getMongoTemplate().save(paramT);
		logger.exit();
	}
	@Override
	public WriteResult updateFirstByParams(CriteriaWrapper criteriaWrapper,
			UpdateWrapper updateWrapper) {
		logger.entry(criteriaWrapper,updateWrapper);
		logger.info("In "+getClass().getName());
		return logger.exit(getMongoTemplate().updateFirst(QueryWrapper.wrap(criteriaWrapper), updateWrapper.getUpdate(), cls));
	}
	@Override
	public WriteResult updateFirstByParams(String id, UpdateWrapper updateWrapper) {
		logger.entry(id,updateWrapper);
		logger.info("In "+getClass().getName());
		return logger.exit(getMongoTemplate().updateFirst(QueryWrapper.wrap(id), updateWrapper.getUpdate(), cls));
	}
	@Override
	public WriteResult updateMultiByParams(CriteriaWrapper criteriaWrapper,
			UpdateWrapper updateWrapper) {
		return getMongoTemplate().updateMulti(QueryWrapper.wrap(criteriaWrapper), updateWrapper.getUpdate(), cls);
	}

    @Override
    public WriteResult updateMultiByParams(CriteriaWrapper criteriaWrapper, UpdateWrapper updateWrapper, Pageable pageable, Sortable sortable) {
        return getMongoTemplate().updateMulti(QueryWrapper.wrap(criteriaWrapper,null,pageable).with(sortable.toSort()),updateWrapper.getUpdate(),cls);
    }

	@Override
	public WriteResult upsert(String id, UpdateWrapper updateWrapper) {
		return getMongoTemplate().upsert(QueryWrapper.wrap(id), updateWrapper.getUpdate(), cls);
	}
	@Override
	public WriteResult upsert(CriteriaWrapper criteriaWrapper,
			UpdateWrapper updateWrapper) {
		return getMongoTemplate().upsert(QueryWrapper.wrap(criteriaWrapper), updateWrapper.getUpdate(), cls);

	}
	@Override
	public void delete(String id) {
		getMongoTemplate().remove(QueryWrapper.wrap(id), cls);
	}
	@Override
	public void delete(T paramT) {
		getMongoTemplate().remove(paramT);
	}
	@Override
	public void deleteByParams(CriteriaWrapper criteriaWrapper) {
		getMongoTemplate().remove(QueryWrapper.wrap(criteriaWrapper), cls);
	}
	@Override
	public T findOneById(String id) {
		logger.entry(id);
		logger.info("In "+getClass().getName());
		return logger.exit(getMongoTemplate().findOne(QueryWrapper.wrap(id), cls));
	}
	@Override
	public T findOneByParams(CriteriaWrapper criteriaWrapper) {
		return getMongoTemplate().findOne(QueryWrapper.wrap(criteriaWrapper), cls);
	}
	@Override
	public List<T> findByParams(CriteriaWrapper criteriaWrapper) {
		return getMongoTemplate().find(QueryWrapper.wrap(criteriaWrapper), cls);
	}
	@Override
	public List<T> findByParamsInPage(CriteriaWrapper criteriaWrapper,
			Pageable pageable) {
		return getMongoTemplate().find(QueryWrapper.wrap(criteriaWrapper, null, pageable), cls);

	}
	@Override
	public List<T> findProjectedByParams(CriteriaWrapper criteriaWrapper,
			FieldFilter filter) {
		return getMongoTemplate().find(QueryWrapper.wrap(criteriaWrapper, filter, null), cls);

	}
	@Override
	public List<T> findProjectedByParamsInPage(CriteriaWrapper criteriaWrapper,
			FieldFilter filter, Pageable pageable) {
		return getMongoTemplate().find(QueryWrapper.wrap(criteriaWrapper, filter, pageable), cls);
	}
	@Override
	public List<T> findMultiByIds(String... ids) {
		return getMongoTemplate().find(QueryWrapper.wrap(CriteriaWrapper.instance().in("id", (Object[])ids)), cls);
	}
	@Override
	public List<T> findAll() {
		return getMongoTemplate().findAll(cls);
	}
	@Override
	public List<T> findAllInPage(Pageable pageable) {
		return getMongoTemplate().find(QueryWrapper.wrap(null, null, pageable), cls);
	}
	@Override
	public List<T> findProjectedAll(String... fields) {
		return getMongoTemplate().find(QueryWrapper.wrap(FieldFilter.instance().include(fields)), cls);
	}
	@Override
	public List<T> findProjectedAll(FieldFilter filter) {
		return getMongoTemplate().find(QueryWrapper.wrap(filter), cls);

	}
	@Override
	public List<T> findProjectedAllInPage(Pageable pageable, String... fields) {
		return getMongoTemplate().find(QueryWrapper.wrap(FieldFilter.instance().include(fields), pageable), cls);
	}
	@Override
	public List<T> findProjectedAllInPage(Pageable pageable, FieldFilter filter) {
		return getMongoTemplate().find(QueryWrapper.wrap(filter, pageable), cls);
	}
	@Override
	public Class<T> getParameterizedClass() {
		return cls;
	}
	@Override
	public long getCount(CriteriaWrapper criteriaWrapper) {
		return getMongoTemplate().count(QueryWrapper.wrap(criteriaWrapper), cls);
	}
	
	
	@Override
	public List<T> findByParamsInOrder(CriteriaWrapper criteriaWrapper,
			Sortable sortable) {
		return getMongoTemplate().find(QueryWrapper.wrap(criteriaWrapper).with(sortable.toSort()), cls);
	}
	@Override
	public List<T> findByParamsInPageInOrder(CriteriaWrapper criteriaWrapper,
			Pageable pageable, Sortable sortable) {
		return getMongoTemplate().find(QueryWrapper.wrap(criteriaWrapper,null, pageable).with(sortable.toSort()), cls);
	}
	@Override
	public List<T> findProjectedByParamsInOrder(
			CriteriaWrapper criteriaWrapper, FieldFilter filter,
			Sortable sortable) {
		return getMongoTemplate().find(QueryWrapper.wrap(criteriaWrapper, filter, null).with(sortable.toSort()), cls);
	}
	@Override
	public List<T> findProjectedByParamsInPageInOrder(CriteriaWrapper criteriaWrapper,
			FieldFilter filter, Pageable pageable, Sortable sortable) {
		return getMongoTemplate().find(QueryWrapper.wrap(criteriaWrapper, filter, pageable).with(sortable.toSort()), cls);
	}
	@Override
	public List<T> findMultiByIdsInOrder(Sortable sortable, String... ids) {
		return getMongoTemplate().find(QueryWrapper.wrap(CriteriaWrapper.instance().in("id", (Object[])ids)).with(sortable.toSort()), cls);

	}
	@Override
	public List<T> findAllInOrder(Sortable sortable) {
		return getMongoTemplate().find(QueryWrapper.wrap(null, null, null).with(sortable.toSort()), cls);
	}
	@Override
	public List<T> findAllInPageInOrder(Pageable pageable, Sortable sortable) {
		return getMongoTemplate().find(QueryWrapper.wrap(null, null, pageable).with(sortable.toSort()), cls);

	}
	@Override
	public List<T> findProjectedAllInOrder(Sortable sortable, String... fields) {
		return getMongoTemplate().find(QueryWrapper.wrap(FieldFilter.instance().include(fields)).with(sortable.toSort()), cls);

	}
	@Override
	public List<T> findProjectedAllInOrder(FieldFilter filter, Sortable sortable) {
		return getMongoTemplate().find(QueryWrapper.wrap(filter).with(sortable.toSort()), cls);

	}
	@Override
	public List<T> findProjectedAllInPageInOrder(Pageable pageable,
			Sortable sortable, String... fields) {
		return getMongoTemplate().find(QueryWrapper.wrap(FieldFilter.instance().include(fields), pageable).with(sortable.toSort()), cls);

	}
	@Override
	public List<T> findProjectedAllInPageInOrder(Pageable pageable,
			FieldFilter filter, Sortable sortable) {
		return getMongoTemplate().find(QueryWrapper.wrap(filter, pageable).with(sortable.toSort()), cls);

	}
	@Override
	public T findOneProjectedById(String id, FieldFilter fieldFilter) {
		return getMongoTemplate().findOne(QueryWrapper.wrap(CriteriaWrapper.instance().is("id", id), fieldFilter, null), cls);
	}
	@Override
	public T findOneProjectedByParams(CriteriaWrapper criteriaWrapper, FieldFilter fieldFilter) {
		return getMongoTemplate().findOne(QueryWrapper.wrap(criteriaWrapper, fieldFilter, null), cls);

	}
	
	@Override
	public long getPageCount(CriteriaWrapper criteriaWrapper,int pageSize){
		long total = getCount(criteriaWrapper);
		return (total<pageSize)?1:((total%pageSize==0)?(total/pageSize):(total/pageSize+1));
	}

    /**
     * the collection represented by the generic type exists or not
     *
     * @return boolean value, true for yes, false for no.
     */
    @Override
    public boolean collectionExists() {
        return getMongoTemplate().collectionExists(cls);
    }

    /**
     * drop the collection represented by the generic type
     */
    @Override
    public void dropCollection() {
        getMongoTemplate().dropCollection(cls);
    }

    /**
     * according to the given criteria, are there any record fulfill the criteria in the collection
     *
     * @param criteriaWrapper criteria
     * @return true or false. true: at lease has one. false: 0.
     */
    @Override
    public boolean exists(CriteriaWrapper criteriaWrapper) {
        return getMongoTemplate().exists(QueryWrapper.wrap(criteriaWrapper),cls);
    }

    /**
     * want to get the original dbCollection object
     *
     * @return dbCollection object in mongodb driver
     */
    @Override
    public DBCollection getCollection() {
        return getMongoTemplate().getCollection(getCollectionName());
    }

    /**
     * want to get the collection name in mongodb
     *
     * @return name of collection represented by the generic type
     */
    @Override
    public String getCollectionName() {
        return getMongoTemplate().getCollectionName(cls);
    }

    /**
     * execute with collection callback
     * <p/>
     * execute with db callback
     * <p/>
     * execute original command object
     * <p/>
     * execute origin command string
     * <p/>
     * execute mass write operations in single session
     *
     * @param callback callback
     */
    @Override
    public T execute(CollectionCallback<T> callback) {
        return getMongoTemplate().execute(cls,callback);
    }

    @Override
    public T execute(DbCallback<T> action) {
        return getMongoTemplate().execute(action);
    }

    @Override
    public CommandResult executeCommand(DBObject command) {
        return getMongoTemplate().executeCommand(command);
    }

    @Override
    public CommandResult executeCommand(String jsonCommand) {
        return getMongoTemplate().executeCommand(jsonCommand);
    }

    @Override
    public T executeInSession(DbCallback<T> action) {
        return getMongoTemplate().executeInSession(action);
    }

    /**
     * map reduce framework
     *
     * @param mapFunction    map function -- content
     * @param reduceFunction reduce function -- content
     * @param outCls         output class type
     * @return map reduce results
     * @see com.fan1tuan.dao.support.mapReduce.JavaScriptExtractor
     */
    @Override
    public MapReduceResults<?> mapReduceAll(String mapFunction, String reduceFunction, Class<?> outCls) {
        return getMongoTemplate().mapReduce(getCollectionName(),mapFunction,reduceFunction,outCls);
    }

    @Override
    public MapReduceResults<?> mapReduceAll(String mapFunction, String reduceFunction, MapReduceOptions mapReduceOptions, Class<?> outCls) {
        return getMongoTemplate().mapReduce(getCollectionName(),mapFunction,reduceFunction,mapReduceOptions,outCls);
    }

    @Override
    public MapReduceResults<?> mapReduceByParam(CriteriaWrapper criteria, String mapFunction, String reduceFunction, Class<?> outCls) {
        return getMongoTemplate().mapReduce(QueryWrapper.wrap(criteria),getCollectionName(),mapFunction,reduceFunction,outCls);
    }

    @Override
    public MapReduceResults<?> mapReduceByParam(CriteriaWrapper criteria, String mapFunction, String reduceFunction, MapReduceOptions mapReduceOptions, Class<?> outCls) {
        return getMongoTemplate().mapReduce(QueryWrapper.wrap(criteria),getCollectionName(),mapFunction,reduceFunction,mapReduceOptions,outCls);
    }

    @Override
    public MapReduceResults<?> mapReduceByParamInPage(CriteriaWrapper criteria, Pageable pageable, String mapFunction, String reduceFunction, Class<?> outCls) {
        return getMongoTemplate().mapReduce(QueryWrapper.wrap(criteria,null,pageable),getCollectionName(),mapFunction,reduceFunction,outCls);
    }

    @Override
    public MapReduceResults<?> mapReduceByParamInPage(CriteriaWrapper criteria, Pageable pageable, String mapFunction, String reduceFunction, MapReduceOptions mapReduceOptions, Class<?> outCls) {
        return getMongoTemplate().mapReduce(QueryWrapper.wrap(criteria,null,pageable),getCollectionName(),mapFunction,reduceFunction,mapReduceOptions,outCls);
    }

    @Override
    public MapReduceResults<?> mapReduceByParamInPageInOrder(CriteriaWrapper criteria, Pageable pageable, Sortable sortable, String mapFunction, String reduceFunction, Class<?> outCls) {
        return getMongoTemplate().mapReduce(QueryWrapper.wrap(criteria,null,pageable).with(sortable.toSort()),getCollectionName(),mapFunction,reduceFunction,outCls);
    }

    @Override
    public MapReduceResults<?> mapReduceByParamInPageInOrder(CriteriaWrapper criteria, Pageable pageable, Sortable sortable, String mapFunction, String reduceFunction, MapReduceOptions mapReduceOptions, Class<?> outCls) {
        return getMongoTemplate().mapReduce(QueryWrapper.wrap(criteria,null,pageable).with(sortable.toSort()),getCollectionName(),mapFunction,reduceFunction,mapReduceOptions,outCls);
    }

    /**
     * aggregate operation
     *
     * @param group  group info
     * @param outCls output class type
     * @return aggregation result type wrap a list of output entity
     */
    @Override
    public AggregationResults<?> aggregate(Group group, Class<?> outCls) {
        return getMongoTemplate().aggregate(AggregateWrapper.wrap(null, group, null, null, null, null),cls,outCls);
    }

    @Override
    public AggregationResults<?> aggregate(Group group, Project project, Class<?> outCls) {
        return getMongoTemplate().aggregate(AggregateWrapper.wrap(null,group,project,null,null,null),cls,outCls);
    }

    @Override
    public AggregationResults<?> aggregate(CriteriaWrapper criteria, Group group, Class<?> outCls) {
        return getMongoTemplate().aggregate(AggregateWrapper.wrap(criteria,group,null,null,null,null),cls,outCls);
    }

    @Override
    public AggregationResults<?> aggregate(CriteriaWrapper criteria, Group group, Project project, Class<?> outCls) {
        return getMongoTemplate().aggregate(AggregateWrapper.wrap(criteria,group,project,null,null,null),cls,outCls);
    }

    /**
     * all params are nullable
     *
     * @param criteria criteria
     * @param group    group
     * @param project  project
     * @param pageable page
     * @param sortable sort
     * @param outCls   output class type
     * @return list of output class type wrap in AggregationResults
     */
    @Override
    public AggregationResults<?> aggregate(CriteriaWrapper criteria, Group group, Project project, Pageable pageable, Sortable sortable, Class<?> outCls) {
        return getMongoTemplate().aggregate(AggregateWrapper.wrap(criteria,group,project,pageable,sortable,null),cls,outCls);
    }

    /**
     * drop all index on the collection
     */
    @Override
    public void dropAllIndexes() {
        getMongoTemplate().indexOps(cls).dropAllIndexes();
    }

    /**
     * drop the index on the collection has the given name
     *
     * @param indexName index name
     */
    @Override
    public void dropIndex(String indexName) {
        getMongoTemplate().indexOps(cls).dropIndex(indexName);
    }

    /**
     * ensure the existence of the index according to the indexDefinition
     *
     * @param indexDefinition contains the original object defined by mongodb driver
     */
    @Override
    public void ensureIndex(IndexDefinition indexDefinition) {
        getMongoTemplate().indexOps(cls).ensureIndex(indexDefinition);
    }

    /**
     * get all the index info on the collection
     *
     * @return list of index info object
     */
    @Override
    public List<IndexInfo> getIndexInfo() {
        return getMongoTemplate().indexOps(cls).getIndexInfo();
    }

    /**
     * clear all the no use index on the collection
     */
    @Override
    public void resetIndexCache() {
        getMongoTemplate().indexOps(cls).resetIndexCache();
    }

    /**
     * geo search
     *
     * @param x        center x
     * @param y        center y
     * @param distance max distance
     * @param metric   distance unit
     * @return list of Entity Contain Position info
     */
    @Override
    public GeoResults<T> findByPointAndDistance(double x, double y, double distance, Metric metric) {
        return getMongoTemplate().geoNear(NearQueryWrapper.wrap(NearCriteriaWrapper.near(x, y).maxDistance(distance, metric)),cls);
    }

    @Override
    public GeoResults<T> findByPointAndDistance(Point center, Distance maxDistance) {
        return getMongoTemplate().geoNear(NearQueryWrapper.wrap(NearCriteriaWrapper.near(center).maxDistance(maxDistance)),cls);
    }

    @Override
    public GeoResults<T> findByPointAndDistanceInPage(double x, double y, double distance, Metric metric, Pageable pageable) {
        return getMongoTemplate().geoNear(NearQueryWrapper.wrap(NearCriteriaWrapper.near(x,y).maxDistance(distance,metric),pageable),cls);
    }

    @Override
    public GeoResults<T> findByPointAndDistanceInPage(Point center, Distance maxDistance, Pageable pageable) {
        return getMongoTemplate().geoNear(NearQueryWrapper.wrap(NearCriteriaWrapper.near(center).maxDistance(maxDistance),pageable),cls);
    }

    @Override
    public GeoResults<T> findByPointAndDistanceInPageInOrder(double x, double y, double distance, Metric metric, Pageable pageable, Sortable sortable) {
        return getMongoTemplate().geoNear(NearQueryWrapper.wrap(NearCriteriaWrapper.near(x,y).maxDistance(distance,metric),pageable,sortable),cls);
    }

    @Override
    public GeoResults<T> findByPointAndDistanceInPageInOrder(Point center, Distance maxDistance, Pageable pageable, Sortable sortable) {
        return getMongoTemplate().geoNear(NearQueryWrapper.wrap(NearCriteriaWrapper.near(center).maxDistance(maxDistance),pageable,sortable),cls);
    }

    @Override
    public GeoResults<T> findByPointAndDistanceWithParam(Point center, Distance maxDistance, CriteriaWrapper criteriaWrapper) {
        return getMongoTemplate().geoNear(NearQueryWrapper.wrap(NearCriteriaWrapper.near(center).maxDistance(maxDistance)).query(QueryWrapper.wrap(criteriaWrapper)),cls);
    }

    @Override
    public GeoResults<T> findByPointAndDistanceWithParamInPage(Point center, Distance maxDistance, CriteriaWrapper criteriaWrapper, Pageable pageable) {
        return getMongoTemplate().geoNear(NearQueryWrapper.wrap(NearCriteriaWrapper.near(center).maxDistance(maxDistance),pageable).query(QueryWrapper.wrap(criteriaWrapper)),cls);
    }

    @Override
    public GeoResults<T> findByPointAndDistanceWithParamInPageInOrder(Point center, Distance maxDistance, CriteriaWrapper criteriaWrapper, Pageable pageable, Sortable sortable) {
        return getMongoTemplate().geoNear(NearQueryWrapper.wrap(NearCriteriaWrapper.near(center).maxDistance(maxDistance),pageable,sortable).query(QueryWrapper.wrap(criteriaWrapper)),cls);
    }

}
