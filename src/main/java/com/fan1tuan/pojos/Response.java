package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

import java.util.Date;

/**
 * Created by Li He on 2014/4/23.
 * @author Li He
 */
public class Response extends EntityObject{

    private String userId;
    private String username;

    private String content;
    private Date responseDate;
    private int postSource; //是在哪种平台上发布的，Android or iPhone or iPad

    private boolean hasReference;
    private String referredUserId;
    private String referredUserName;


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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }

    public int getPostSource() {
        return postSource;
    }

    public void setPostSource(int postSource) {
        this.postSource = postSource;
    }

    public boolean isHasReference() {
        return hasReference;
    }

    public void setHasReference(boolean hasReference) {
        this.hasReference = hasReference;
    }

    public String getReferredUserId() {
        return referredUserId;
    }

    public void setReferredUserId(String referredUserId) {
        this.referredUserId = referredUserId;
    }

    public String getReferredUserName() {
        return referredUserName;
    }

    public void setReferredUserName(String referredUserName) {
        this.referredUserName = referredUserName;
    }
}
