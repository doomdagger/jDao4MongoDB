package com.fan1tuan.business.support.enums;

/**
 * Created by Li He on 2014/4/22.
 * @author Li He
 */
public enum ShopTagType {
    RANK_TAG,
    AFFAIR_TAG;

    public static ShopTagType valueOf(int ordinal){
        ShopTagType shopTagType;
        switch (ordinal){
            case 0: shopTagType = RANK_TAG;break;
            case 1: shopTagType = AFFAIR_TAG;break;
            default:throw new AssertionError("Not Supported Shop Tag Type with given value:"+ordinal+". Please refer ShopTagType for detail.");
        }
        return shopTagType;
    }
}
