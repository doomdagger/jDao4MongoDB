package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

/**
 * Created by Li He on 2014/4/16.
 * @author Li He
 */
public class UserAddress extends EntityObject{

    private String addressId; //如果用户想要删除一个地址，凭借此id唯一标识一个用户地址
    private String receiver;
    private String address; //address
    private String phone;


    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
