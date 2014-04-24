package com.fan1tuan.business.support.enums;

/**
 * Created by Li He on 2014/4/22.
 * @author Li He
 */
public enum OrderType {
    PHONE_CALL,
    ONLINE;

    public static OrderType valueOf(int ordinal){
        OrderType orderType;
        switch (ordinal){
            case 0: orderType = PHONE_CALL;break;
            case 1: orderType = ONLINE;break;
            default:throw new AssertionError("Not Supported Order Type with given value:"+ordinal+". Please refer OrderType for detail.");
        }
        return orderType;
    }
}
