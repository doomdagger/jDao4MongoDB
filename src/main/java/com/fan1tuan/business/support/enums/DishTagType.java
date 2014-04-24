package com.fan1tuan.business.support.enums;

/**
 * Created by Li He on 2014/4/22.
 * @author Li He
 */
public enum DishTagType {

    RANK_TAG, //本店周销量冠军
    SALE_TAG,  //此菜品有什么活动啦，正在打折
    AFFAIR_TAG, //此菜品是新菜，此菜为掌柜推荐
    TASTE_TAG; //辣（狠辣），甜（甜口味）

    public static DishTagType valueOf(int ordinal){
        DishTagType dishTagType;
        switch (ordinal){
            case 0: dishTagType = RANK_TAG;break;
            case 1: dishTagType = SALE_TAG;break;
            case 2: dishTagType = AFFAIR_TAG;break;
            case 3: dishTagType = TASTE_TAG;break;
            default:throw new AssertionError("Not Supported Dish Tag Type with given value:"+ordinal+". Please refer DishTagType for detail.");
        }
        return dishTagType;
    }
}
