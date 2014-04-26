package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

import java.util.Date;

/**
 * Coupon Item是用来留给店铺作为代金卷存根的，同时也作为验证代金卷是否合法的另一个因素，
 * 每张代金卷的消费，都应与在卖家这里验证，此实体字段与Coupon的字段类似，但是不尽相同，
 * 此实体作为一个子文档，保存在shop集合中的每一个文档中。
 * Created by Li He on 2014/4/24.
 * @author Li He
 */
public class CouponItem extends EntityObject{

    private String code; //代金卷的编码，也是代金卷的消费凭据

    private String exchangeCode; //代金券的兑换码

    private int faceValue; //面值

    private boolean used; //是否使用过

    private Date expireDate; //过期的日期

    private boolean valid; // used or expired coupon will be set to be invalid

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
