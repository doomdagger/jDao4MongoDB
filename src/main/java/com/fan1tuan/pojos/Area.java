package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Li He on 2014/4/16.
 * @author Li He
 */
@Document
public class Area extends EntityObject{
    @Id
    private String id;  //id for area
    private String name; //name for area
    private double[] location; //location in array, latitude and longitude
    private double radius; //the max distance willing to delivery

}
