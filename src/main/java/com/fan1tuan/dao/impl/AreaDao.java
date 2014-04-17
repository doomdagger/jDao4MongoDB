package com.fan1tuan.dao.impl;

import com.fan1tuan.dao.Fan1TuanDaoImpl;
import com.fan1tuan.pojos.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;


/**
 * Created by JOE on 2014/4/17.
 * @author JOE
 */
@Repository("areaDao")
public class AreaDao extends Fan1TuanDaoImpl<Area>{

    @Autowired
    private MongoTemplate mongoTemplate;
}
