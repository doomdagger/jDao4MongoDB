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

    private String remark;  //the remark from the user. leave it null if the dish item is used in shopping cart


    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishAvatar() {
        return dishAvatar;
    }

    public void setDishAvatar(String dishAvatar) {
        this.dishAvatar = dishAvatar;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }

    public double getDishSumPrice() {
        return dishSumPrice;
    }

    public void setDishSumPrice(double dishSumPrice) {
        this.dishSumPrice = dishSumPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
