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
public class ShopClient extends EntityObject{
    @Id
    private String id; //id of the shop client
    private String username; //shop client sign in name
    private String password; //shop client sign in password

    private List<String> shopIds; //owned shops' ids

    private String wechatPayId; //微信支付端账号
    private String alipayId; //支付宝支付端账号

    public String getWechatPayId() {
        return wechatPayId;
    }

    public void setWechatPayId(String wechatPayId) {
        this.wechatPayId = wechatPayId;
    }

    public String getAlipayId() {
        return alipayId;
    }

    public void setAlipayId(String alipayId) {
        this.alipayId = alipayId;
    }

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

    public List<String> getShopIds() {
        return shopIds;
    }

    public void setShopIds(List<String> shopIds) {
        this.shopIds = shopIds;
    }
}
