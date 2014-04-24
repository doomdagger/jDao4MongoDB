package com.fan1tuan.business.support.enums;

/**
 * Created by Li He on 2014/4/22.
 * @author Li He
 */
public enum OrderStatus {
    PRE_CONFIRM("订单未确认"), CONFIRM("订单已确认"),  // 0:订单已创建，还未被用户确认, 1:订单已被用户确认
    SHOP_ACCEPT("店铺受理订单"), SHOP_DELIVERY("美食已派送"), USER_ACCEPT("用户确认收货"), USER_EVALUATE("用户已评价"), //2:店铺确认接受订单, 3:店铺派送中, 4:用户接受订单, 5:用户已经全部评价完毕订单中的所有菜品
    USER_DECLINE("用户取消订单"), // 6:用户取消订单
    SHOP_DECLINE("店铺取消订单"); // 7:店铺取消订单

    private String message;

    private OrderStatus(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public static OrderStatus valueOf(int ordinal){
        OrderStatus orderStatus;
        switch (ordinal){
            case 0: orderStatus = PRE_CONFIRM;break;
            case 1: orderStatus = CONFIRM;break;
            case 2: orderStatus = SHOP_ACCEPT;break;
            case 3: orderStatus = SHOP_DELIVERY;break;
            case 4: orderStatus = USER_ACCEPT;break;
            case 5: orderStatus = USER_EVALUATE;break;
            case 6: orderStatus = USER_DECLINE;break;
            case 7: orderStatus = SHOP_DECLINE;break;
            default:throw new AssertionError("Not Supported Order Status with given value:"+ordinal+". Please refer OrderStatus for detail.");
        }
        return orderStatus;
    }
}
