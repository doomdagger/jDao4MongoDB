package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

import java.util.Date;

/**
 * Created by Li He on 2014/4/17.
 * @author Li He
 */
public class DishCollect extends EntityObject{

    private String dishId;
    private String shopId;

    private String dishName;
    private String dishAvatar;

    private Date date;
    private int status; // 是否失效

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

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
