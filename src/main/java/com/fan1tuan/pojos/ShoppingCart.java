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

    private boolean validForSubmit; // check the delivery charge fulfilled or not, or other conditions not meet


    public List<ShopItem> getShopItems() {
        return shopItems;
    }

    public void setShopItems(List<ShopItem> shopItems) {
        this.shopItems = shopItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public boolean isValidForSubmit() {
        return validForSubmit;
    }

    public void setValidForSubmit(boolean validForSubmit) {
        this.validForSubmit = validForSubmit;
    }
}
