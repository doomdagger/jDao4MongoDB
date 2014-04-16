package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

import java.util.Date;
import java.util.List;

/**
 * Created by Li He on 2014/4/16.
 * @author Li He
 */
public class ShopSale extends EntityObject{

    private String description; //sale description
    private List<String> pictures; //sale optional image paths
    private Date startDate; //sale start date
    private Date endDate; //sale end date
    private String tips; //sale tips


}
