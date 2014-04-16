package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Li He on 2014/4/17.
 * @author Li He
 */
@Document
public class Order extends EntityObject{
    @Id
    private String id;
    private String orderNo;

    private String userId;
    private String username;
    private String userAvatar;

    private double[] location; //the location that order was made by user

    private String shopId;  //用户提供
    private String shopName;
    private String shopAvatar;

    private List<DishItem> dishItems;  //用户提供部分，dishId, number

    private Date date;

    private double price;   // the real price user has to pay for

    private int status; // the status of the order, 1 2 3 4 5 6 many many

    private String address; //用户提供
    private String receiver;// 用户提供

    private Date deliveryTime;//用户提供

    private int chargeType;//用户提供

    private String phone;//用户提供

}
