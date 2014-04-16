package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

import java.util.List;

/**
 * Created by Li He on 2014/4/17.
 * @author Li He
 */
public class ShoppingCart extends EntityObject{

    private List<ShopItem> shopItems;
    private double totalPrice;  //sum price of all shop items
    private int itemCount;//份数

}
