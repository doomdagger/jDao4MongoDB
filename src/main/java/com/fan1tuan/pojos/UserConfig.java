package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

/**
 * Created by Li He on 2014/4/23.
 * @author Li He
 */
public class UserConfig extends EntityObject{

    private boolean receiveAnonymousPost;//是否接受身边的匿名post信息

    private boolean exposeLocationInfo; //自己的位置信息是否希望他人可见

    private int secureStrategy; // enum枚举值，个人信息 包括对任何人可见，对好友可见，对任何人均不可见


    public boolean isReceiveAnonymousPost() {
        return receiveAnonymousPost;
    }

    public void setReceiveAnonymousPost(boolean receiveAnonymousPost) {
        this.receiveAnonymousPost = receiveAnonymousPost;
    }

    public boolean isExposeLocationInfo() {
        return exposeLocationInfo;
    }

    public void setExposeLocationInfo(boolean exposeLocationInfo) {
        this.exposeLocationInfo = exposeLocationInfo;
    }

    public int getSecureStrategy() {
        return secureStrategy;
    }

    public void setSecureStrategy(int secureStrategy) {
        this.secureStrategy = secureStrategy;
    }
}
