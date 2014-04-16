package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

import java.util.Date;

/**
 * Created by Li He on 2014/4/17.
 * @author Li He
 */
public class Coupon extends EntityObject{

    private String code;
    private int faceValue;

    private boolean used;

    private Date expireDate;

}
