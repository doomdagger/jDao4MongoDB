package com.fan1tuan.dao.impl;

import com.fan1tuan.dao.Fan1TuanDaoImpl;
import com.fan1tuan.pojos.DishComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by JOE on 2014/4/17.
 * @author JOE
 */
@Repository("dishCommentDao")
public class DishCommentDao extends Fan1TuanDaoImpl<DishComment> {
    @Autowired
    private MongoTemplate mongoTemplate;
}
