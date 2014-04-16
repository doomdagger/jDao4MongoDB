package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * Created by Li He on 2014/4/16.
 * @author Li He
 */
public class Shop extends EntityObject{
    @Id
    private String id; //id of the shop
    private String name; //name of the shop

    private List<ShopTag> shopTags;
    private List<String> shopTastes; //the flavors the shop have

    private int shopType;  //a entity shop or a retailer
    private int orderType; //way to order: online or phone call

    private int popularity; //popularity
    private int saleVolume; //total dishes' sale volume


    private String announcement; //announcement temporarily, this field may change a lot
    private String description; //description of the shop

    private boolean supportDelivery; //this shop support delivery or not?
    private double priceForDelivery; //start price for delivery
    private double avgDeliveryTime; // average delivery time

    private double avgPersonCost; // average person cost, computed from users' orders

    private String address; // address of the shop

    private double[] location; //location in array, latitude and longitude
    private double radius; //the max distance willing to delivery

    private List<String> phoneNumbers; //phone number list

    private List<ShopSale> shopSales; //dish sale info

    private boolean open; //is open now??
    private Date openTime; //open time daily
    private Date closeTime;//close time daily

    private int commentNum; //dish comments
    private double commentLevel; //dish comments now it is sum of the comment level, not the average
    private double avgCommentLevel;//average comment level

    //string path of avatar: img file
    private String avatar; //path of img file

    private Date createTime; //create time of the shop

    private List<Dish> dishes; // dish list of the shop
}
