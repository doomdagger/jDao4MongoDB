package com.fan1tuan.business.support.enums;

/**
 * Created by Li He on 2014/4/22.
 * @author Li He
 */
public enum ShopType {
    ENTITY("实体店"),
    RETAILER("美食摊");

    private String message;

    private ShopType(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public static ShopType valueOf(int ordinal){
        ShopType shopType;
        switch (ordinal){
            case 0: shopType = ENTITY;break;
            case 1: shopType = RETAILER;break;
            default:throw new AssertionError("Not Supported Shop Type with given value:"+ordinal+". Please refer ShopType for detail.");
        }
        return shopType;
    }
}
