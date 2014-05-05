package com.fan1tuan.client.user.business.test;

import com.fan1tuan.config.Fan1TuanConfig;
import com.fan1tuan.util.gen.DataGenerator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Li He on 2014/5/6.
 * @author Li He
 */
public class DataGeneratorUnitTest {

    @Test
    public void test(){
        System.setProperty("path.log", Fan1TuanConfig.getProperty("path.log"));

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");

        DataGenerator dataGenerator = context.getBean("dataGenerator", DataGenerator.class);

        dataGenerator.generateData();

    }

}
