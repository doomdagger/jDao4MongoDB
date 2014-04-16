package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Li He on 2014/4/16.
 * @author Li He
 */
@Document
public class User extends EntityObject{
    @Id
    private String id;
    private String username;
    private String password;
    private String cellphone;
    private String email;
    private String realName;

    private String qq;
    private String avatar; //image path

    private int level;

    private int fanGrain;  //fan li sub system

    private List<Coupon> coupons; // coupons

    private List<DishCollect> dishCollects;
    private List<ShopCollect> shopCollects;
    private List<UserAddress> userAddresses;

    private ShoppingCart shoppingCart;


}
