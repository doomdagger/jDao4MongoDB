package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

import java.util.List;

/**
 * Created by Li He on 2014/4/17.
 * @author Li He
 */
public class ShopItem extends EntityObject{

    private List<DishItem> dishItems;

    private String shopId;
    private String shopName;
    private String shopAvatar;

    private double shopSumPrice;

    private double deliveryCharge; //新加字段，为了保证起送价限制与店铺的事务标签提醒


    public List<DishItem> getDishItems() {
        return dishItems;
    }

    public void setDishItems(List<DishItem> dishItems) {
        this.dishItems = dishItems;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAvatar() {
        return shopAvatar;
    }

    public void setShopAvatar(String shopAvatar) {
        this.shopAvatar = shopAvatar;
    }

    public double getShopSumPrice() {
        return shopSumPrice;
    }

    public void setShopSumPrice(double shopSumPrice) {
        this.shopSumPrice = shopSumPrice;
    }

    public double getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(double deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }
}
