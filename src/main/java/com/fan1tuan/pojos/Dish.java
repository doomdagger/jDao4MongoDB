package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

import java.util.Date;
import java.util.List;

/**
 * Created by Li He on 2014/4/16.
 * @author Li He
 */
public class Dish extends EntityObject{
    private String dishId; //id for dish

    private String dishCategory; // dish category goes here

    private List<DishTag> dishTags; //tag for the dish, may be a empty list

    private String name; // dish name

    private double price; // dish current price
    private double originalPrice; // dish original price

    private int saleVolume; // sale volume of dish until now

    private String avatar; // image path of dish

    private int commentNum; // comment num - whole
    private double commentLevel; //now it is sum of the comment level, not the average
    private double avgCommentLevel; // average comment level

    private int status; //0可预订，其他为不可预订 1卖完了 2暂不提供 3...  the dish status: sold out? deleted? not supplied temporarily?
    private String description; // dish description

    private Date createTime; // create time of dish

    private boolean feature; //is the dish recommended by the shop owner

    public List<DishTag> getDishTags() {
        return dishTags;
    }

    public void setDishTags(List<DishTag> dishTags) {
        this.dishTags = dishTags;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getDishCategory() {
        return dishCategory;
    }

    public void setDishCategory(String dishCategory) {
        this.dishCategory = dishCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getSaleVolume() {
        return saleVolume;
    }

    public void setSaleVolume(int saleVolume) {
        this.saleVolume = saleVolume;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isFeature() {
        return feature;
    }

    public void setFeature(boolean feature) {
        this.feature = feature;
    }
}
