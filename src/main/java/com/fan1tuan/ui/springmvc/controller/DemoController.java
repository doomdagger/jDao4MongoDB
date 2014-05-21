package com.fan1tuan.ui.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Li He on 2014/4/17.
 * @author Li He
 */
@RestController
@RequestMapping("/demo/webservice")
public class DemoController {

    @RequestMapping("/converter/json")
    public Area json(@RequestParam String message){
        Area area = new Area();
        area.setId("123456");
        area.setName("Hello");
        area.setRadius(25.1);
        area.setLocation(new double[]{2.0,1.0});
        return area;
    }

}
