package com.fan1tuan.business.support.enums;

import com.fan1tuan.dao.support.common.Sortable;
import sun.misc.Sort;

/**
 * Created by Li He on 2014/4/26.
 * @author Li He
 */
public enum ShopRankAccord {

    COMMENT_LEVEL(Sortable.DESCEND),
    SALE_VOLUME(Sortable.DESCEND),
    PERSON_COST(Sortable.ASCEND),
    POPULARITY(Sortable.DESCEND),
    DELIVERY_PRICE(Sortable.ASCEND),
    DELIVERY_TIME(Sortable.ASCEND);

    private int order;

    private ShopRankAccord(int order){
        this.order = order;
    }

    public static ShopRankAccord valueOf(int ordinal){
        ShopRankAccord shopRankAccord;
        switch (ordinal){
            case 0: shopRankAccord = COMMENT_LEVEL;break;
            case 1: shopRankAccord = SALE_VOLUME;break;
            case 2: shopRankAccord = PERSON_COST;break;
            case 3: shopRankAccord = POPULARITY;break;
            case 4: shopRankAccord = DELIVERY_PRICE;break;
            case 5: shopRankAccord = DELIVERY_TIME;break;
            default:throw new AssertionError("Not Supported Shop Rank Accord with given value:"+ordinal+". Please refer ShopRankAccord for detail.");
        }
        return shopRankAccord;
    }

}
