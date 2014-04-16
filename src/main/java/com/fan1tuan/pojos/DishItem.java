package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

/**
 * Created by Li He on 2014/4/17.
 * @author Li He
 */
public class DishItem extends EntityObject{

    private String dishId; //point to id of dish entity
    private String dishName; //dish name also needed
    private String dishAvatar; // the image path of dish

    private int count; //number of dish

    private double dishPrice;  // the real price of the single dish
    private double dishSumPrice; // the real sum prices of all the dishes

    private String remark;  //the remark from the user.
}
