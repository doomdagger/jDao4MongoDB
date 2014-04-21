package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    //if user jump into a shop that does not near enough for ordering, the warning should appear on the screen
    //also, add a step that a robot program will first check the validity of the order, and then dispatch the order
    //to the shop owner

    private String shopId;  //用户提供
    private String shopName;
    private String shopAvatar;
    private List<String> shopTastes; //tags of tastes for the shop

    private List<DishItem> dishItems;  //用户提供部分，dishId, number

    private Date date;

    private double price;   // the real price user has to pay for,
    //this price may be altered by the shop owner or
    //the user use coupons to offset the prices

    /**
     * Status here
     * 下单成功   店铺受理   美食派送   店铺确认美食送达（买家确认美食送达）   买家点评（照片？！）
     */
    private int status; // the status of the order, 1 2 3 4 5 6 many many

    private String address; //用户提供
    private String receiver;// 用户提供
    private String phone;//用户提供

    private Date deliveryTime;//用户提供

    private int chargeType;//用户提供


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public double[] getLocation() {
        return location;
    }

    public void setLocation(double[] location) {
        this.location = location;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAvatar() {
        return shopAvatar;
    }

    public void setShopAvatar(String shopAvatar) {
        this.shopAvatar = shopAvatar;
    }

    public List<String> getShopTastes() {
        return shopTastes;
    }

    public void setShopTastes(List<String> shopTastes) {
        this.shopTastes = shopTastes;
    }

    public List<DishItem> getDishItems() {
        return dishItems;
    }

    public void setDishItems(List<DishItem> dishItems) {
        this.dishItems = dishItems;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getChargeType() {
        return chargeType;
    }

    public void setChargeType(int chargeType) {
        this.chargeType = chargeType;
    }
}
