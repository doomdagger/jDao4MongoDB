package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

import java.util.Date;

/**
 * Created by Li He on 2014/4/23.
 * @author Li He
 */
public class Response extends EntityObject{

    private String responseId;
    private String userId;  //user id
    private String username; //user name

    private String content; // content of the response
    private Date responseDate; // response of the date
    private int postSource; //是在哪种平台上发布的，Android or iPhone or iPad

    private boolean anonymous; //回复是否匿名

    private boolean hasReference;  //is the response has reference to another user -- sub response
    private String referredResponse;

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public String getReferredResponse() {
        return referredResponse;
    }

    public void setReferredResponse(String referredResponse) {
        this.referredResponse = referredResponse;
    }

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
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

}
