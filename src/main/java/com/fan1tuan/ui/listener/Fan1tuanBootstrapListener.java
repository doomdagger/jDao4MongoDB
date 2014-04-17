package com.fan1tuan.ui.listener;

import com.fan1tuan.config.Fan1TuanConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.reflect.Field;

/**
 * Created by Li He on 2014/4/16.
 * @author  Li He
 */
public class Fan1tuanBootstrapListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //ensuring log path in System Property
        System.setProperty("path.log", Fan1TuanConfig.getProperty("path.log"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {


    }
}
