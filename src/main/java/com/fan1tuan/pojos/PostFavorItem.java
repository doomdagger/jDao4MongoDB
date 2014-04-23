package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

/**
 * Created by Li He on 2014/4/23.
 * @author Li He
 */
public class PostFavorItem extends EntityObject{
    private String userId;
    private String username;

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
}
