package com.fan1tuan.business.support.enums;

/**
 * Created by Li He on 2014/4/24.
 * @author Li He
 */
public enum CollectStatus {
    AVAILABLE //收藏仍然有效
    ,NOT_AVAILABLE; //收藏已经失效

    public static CollectStatus valueOf(int ordinal){
        CollectStatus collectStatus;
        switch (ordinal){
            case 0: collectStatus = AVAILABLE;break;
            case 1: collectStatus = NOT_AVAILABLE;break;
            default:throw new AssertionError("Not Supported Collect Status with given value:"+ordinal+". Please refer CollectStatus for detail.");
        }
        return collectStatus;
    }
}
