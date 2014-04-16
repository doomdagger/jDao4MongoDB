package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

import java.util.Date;

/**
 * Created by Li He on 2014/4/17.
 * @author Li He
 */
public class ShopCollect extends EntityObject{

    private String shopId;
    private String shopName;
    private String shopAvatar; //image path


    private Date date;
    private int status; //是否失效

}
