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
    private String avatar; //image path

    private String qq;
    private String renren;
    private String weibo;

    private int level;
    private int experience;

    private int fanGrain;  //fan li sub system

    private List<Coupon> coupons; // coupons

    private List<DishCollect> dishCollects;
    private List<ShopCollect> shopCollects;
    private List<UserAddress> userAddresses;

    private ShoppingCart shoppingCart;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getRenren() {
        return renren;
    }

    public void setRenren(String renren) {
        this.renren = renren;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getFanGrain() {
        return fanGrain;
    }

    public void setFanGrain(int fanGrain) {
        this.fanGrain = fanGrain;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    public List<DishCollect> getDishCollects() {
        return dishCollects;
    }

    public void setDishCollects(List<DishCollect> dishCollects) {
        this.dishCollects = dishCollects;
    }

    public List<ShopCollect> getShopCollects() {
        return shopCollects;
    }

    public void setShopCollects(List<ShopCollect> shopCollects) {
        this.shopCollects = shopCollects;
    }

    public List<UserAddress> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(List<UserAddress> userAddresses) {
        this.userAddresses = userAddresses;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
