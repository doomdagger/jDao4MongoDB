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
public class DishComment extends EntityObject{
    @Id
    private String id; //id of dishComment

    private String userId; //user id offer the comment
    private String username; // user name, not realname, username can be phone number, but not definitely are
    private String userAvatar; // user image path

    private String dishId; // dish id
    private String dishName;
    private String dishAvatar;

    private String shopId; // shop id
    private String shopName; //shop name

    private String comment; // comment content
    private int commentLevel; // offer comment level 1-5
    private List<String> commentImage; //image for comment, user take picture of the food


    private Date date;// date of the offered comment


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishAvatar() {
        return dishAvatar;
    }

    public void setDishAvatar(String dishAvatar) {
        this.dishAvatar = dishAvatar;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(int commentLevel) {
        this.commentLevel = commentLevel;
    }

    public List<String> getCommentImage() {
        return commentImage;
    }

    public void setCommentImage(List<String> commentImage) {
        this.commentImage = commentImage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
