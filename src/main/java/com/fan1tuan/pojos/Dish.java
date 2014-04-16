package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

import java.util.Date;
import java.util.List;

/**
 * Created by Li He on 2014/4/16.
 * @author Li He
 */
public class Dish extends EntityObject{
    private String dishId; //id for dish

    private String dishCategory; // dish category goes here

    private String name; // dish name

    private double price; // dish current price
    private double originalPrice; // dish original price

    private int saleVolume; // sale volume of dish until now

    private String avatar; // image path of dish

    private int commentNum; // comment num - whole
    private double commentLevel; //now it is sum of the comment level, not the average
    private double avgCommentLevel; // average comment level

    private int status; //0可预订，其他为不可预订 1卖完了 2暂不提供 3...  the dish status: sold out? deleted? not supplied temporarily?
    private String description; // dish description

    private Date createTime; // create time of dish

    private boolean feature; //is the dish recommended by the shop owner
}
