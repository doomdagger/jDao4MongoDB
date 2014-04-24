package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

/**
 * Created by Li He on 2014/4/23.
 * @author Li He
 */
public class UserConfig extends EntityObject{

    private boolean receiveAnonymousPost;//是否接受身边的匿名post信息

    private boolean exposeLocationInfo; //自己的位置信息是否希望他人可见

    private boolean anonymousInSocial; //是否在post以及回复中暴露个人用户名以及个人信息

    private boolean autoPostOrderInfo; //是否在下订单后自动发布post信息

    private int secureStrategy; // enum枚举值，个人信息 包括对任何人可见，对好友可见，对任何人均不可见


    public boolean isAutoPostOrderInfo() {
        return autoPostOrderInfo;
    }

    public void setAutoPostOrderInfo(boolean autoPostOrderInfo) {
        this.autoPostOrderInfo = autoPostOrderInfo;
    }

    public boolean isAnonymousInSocial() {
        return anonymousInSocial;
    }

    public void setAnonymousInSocial(boolean anonymousInSocial) {
        this.anonymousInSocial = anonymousInSocial;
    }

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
