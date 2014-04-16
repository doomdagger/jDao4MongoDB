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

}
