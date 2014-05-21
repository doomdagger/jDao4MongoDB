package com.fan1tuan.dao.impl;

import com.fan1tuan.dao.Fan1TuanDaoImpl;
import com.fan1tuan.pojos.DemoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Li He on 2014/5/21.
 * @author Li He
 */
@Repository("demoDao")
public class DemoDao extends Fan1TuanDaoImpl<DemoEntity>{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public MongoTemplate getMongoTemplate(){
        return mongoTemplate;
    }

}
