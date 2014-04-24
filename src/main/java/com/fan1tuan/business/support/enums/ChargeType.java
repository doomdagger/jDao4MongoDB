package com.fan1tuan.business.support.enums;

/**
 * Created by Li He on 2014/4/24.
 * @author Li He
 */
public enum ChargeType {
    CASH_ON_DELIVERY, //货到付款
    ALIPAY, //支付宝付款
    WECHATPAY; // 微信付款

    public static ChargeType valueOf(int ordinal){
        ChargeType chargeType;
        switch (ordinal){
            case 0: chargeType = CASH_ON_DELIVERY;break;
            case 1: chargeType = ALIPAY;break;
            case 2: chargeType = WECHATPAY;break;
            default:throw new AssertionError("Not Supported Charge Type with given value:"+ordinal+". Please refer ChargeType for detail.");
        }
        return chargeType;
    }

}
