package com.fan1tuan.business.support.enums;

/**
 * Created by Li He on 2014/4/24.
 * @author Li He
 */
public enum DishStatus {
    AVAILABLE("菜品可以购买"),
    SOLD_OUT("菜品已经售完"),
    NOT_AVAILABLE("菜品暂不提供"),
    SHOP_CLOSED("店铺已经休息"),
    SHOP_NOT_AVAILABLE("店铺不接受订餐");

    private String message;

    private DishStatus(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public static DishStatus valueOf(int ordinal){
        DishStatus dishStatus;
        switch (ordinal){
            case 0: dishStatus = AVAILABLE;break;
            case 1: dishStatus = SOLD_OUT;break;
            case 2: dishStatus = NOT_AVAILABLE;break;
            case 3: dishStatus = SHOP_CLOSED;break;
            case 4: dishStatus = SHOP_NOT_AVAILABLE;break;
            default:throw new AssertionError("Not Supported Dish Status with given value:"+ordinal+". Please refer DishStatus for detail.");
        }
        return dishStatus;
    }
}
