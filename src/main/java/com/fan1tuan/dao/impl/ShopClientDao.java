package com.fan1tuan.dao.impl;

import com.fan1tuan.dao.Fan1TuanDaoImpl;
import com.fan1tuan.pojos.ShopClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Li He on 2014/4/17.
 * @author Li He
 */
@Repository("shopClientDao")
public class ShopClientDao extends Fan1TuanDaoImpl<ShopClient> {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public MongoTemplate getMongoTemplate(){
        return mongoTemplate;
    }

}
