package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * Created by Li He on 2014/4/16.
 * @author Li He
 */
@Document
public class Shop extends EntityObject{
    @Id
    private String id; //id of the shop
    private String name; //name of the shop

    private List<ShopTag> shopTags; //multiple types of tags for shop
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
    private boolean availableForOrder; //can receive order now or not
    private Date openTime; //open time daily
    private Date closeTime;//close time daily

    private int commentNum; //dish comments
    private double commentLevel; //dish comments now it is sum of the comment level, not the average
    private double avgCommentLevel;//average comment level

    //string path of avatar: img file
    private String avatar; //path of img file

    private Date createTime; //create time of the shop

    private List<Dish> dishes; // dish list of the shop


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ShopTag> getShopTags() {
        return shopTags;
    }

    public void setShopTags(List<ShopTag> shopTags) {
        this.shopTags = shopTags;
    }

    public List<String> getShopTastes() {
        return shopTastes;
    }

    public void setShopTastes(List<String> shopTastes) {
        this.shopTastes = shopTastes;
    }

    public int getShopType() {
        return shopType;
    }

    public void setShopType(int shopType) {
        this.shopType = shopType;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getSaleVolume() {
        return saleVolume;
    }

    public void setSaleVolume(int saleVolume) {
        this.saleVolume = saleVolume;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSupportDelivery() {
        return supportDelivery;
    }

    public void setSupportDelivery(boolean supportDelivery) {
        this.supportDelivery = supportDelivery;
    }

    public double getPriceForDelivery() {
        return priceForDelivery;
    }

    public void setPriceForDelivery(double priceForDelivery) {
        this.priceForDelivery = priceForDelivery;
    }

    public double getAvgDeliveryTime() {
        return avgDeliveryTime;
    }

    public void setAvgDeliveryTime(double avgDeliveryTime) {
        this.avgDeliveryTime = avgDeliveryTime;
    }

    public double getAvgPersonCost() {
        return avgPersonCost;
    }

    public void setAvgPersonCost(double avgPersonCost) {
        this.avgPersonCost = avgPersonCost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double[] getLocation() {
        return location;
    }

    public void setLocation(double[] location) {
        this.location = location;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<ShopSale> getShopSales() {
        return shopSales;
    }

    public void setShopSales(List<ShopSale> shopSales) {
        this.shopSales = shopSales;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isAvailableForOrder() {
        return availableForOrder;
    }

    public void setAvailableForOrder(boolean availableForOrder) {
        this.availableForOrder = availableForOrder;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public double getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(double commentLevel) {
        this.commentLevel = commentLevel;
    }

    public double getAvgCommentLevel() {
        return avgCommentLevel;
    }

    public void setAvgCommentLevel(double avgCommentLevel) {
        this.avgCommentLevel = avgCommentLevel;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
