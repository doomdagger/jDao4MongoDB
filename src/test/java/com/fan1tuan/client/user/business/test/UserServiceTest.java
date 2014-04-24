package com.fan1tuan.client.user.business.test;

import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.business.support.enums.ResultStatus;
import com.fan1tuan.client.user.business.UserService;
import com.fan1tuan.config.Fan1TuanConfig;
import com.fan1tuan.dao.impl.UserDao;
import com.fan1tuan.dao.support.aggregate.Group;
import com.fan1tuan.dao.support.aggregate.Project;
import com.fan1tuan.dao.support.common.CriteriaWrapper;
import com.fan1tuan.dao.support.common.Pageable;
import com.fan1tuan.dao.support.common.Sortable;
import com.fan1tuan.dao.support.query.FieldFilter;
import com.fan1tuan.dao.support.update.UpdateWrapper;
import com.fan1tuan.pojos.User;
import org.hibernate.sql.Update;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Li He on 2014/4/22.
 * @author Li He
 */

public class UserServiceTest {
    /*@Test
    public void test(){
        System.setProperty("path.log", Fan1TuanConfig.getProperty("path.log"));

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");

        UserService userService = context.getBean("userService",UserService.class);

        StatusAwareResult<User> result = userService.test();

        System.out.println(result);

        System.out.println(result.getRet().toJSON());


    }*/

    @Test
    public void test2(){
        ResultStatus resultStatus = ResultStatus.FAIL;

        System.out.println(resultStatus.ordinal());
    }
}
