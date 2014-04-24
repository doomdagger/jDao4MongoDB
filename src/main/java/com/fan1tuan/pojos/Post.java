package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * Created by Li He on 2014/4/23.
 * @author Li He
 */
@Document
public class Post extends EntityObject{

    @Id
    private String id;

    private String userId;
    private String username;

    private String content;  //cache markdown or other rich text
    private Date postDate;
    private int postSource; //是在哪种平台上发布的，Android or iPhone or iPad

    private boolean anonymous; //是否匿名，无法看见用户名
    //匿名不是留给用户选择的，是系统用来控制的，每当用户进行以下行为：
    //为菜品评价，上传图片，新下订单，都会自动生成一个post，这些post均为匿名的
    //将会推送给其他周边用户，用户无需主动post，但是周边用户也可以禁止掉这种推送功能

    private List<String> imagePaths;

    private int visitorNum;

    private List<Response> responses;
    private List<PostFavorItem> favorItems;

    private double[] location;
    private String locationName; //地点的简短介绍

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public int getPostSource() {
        return postSource;
    }

    public void setPostSource(int postSource) {
        this.postSource = postSource;
    }

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }

    public List<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(List<String> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public int getVisitorNum() {
        return visitorNum;
    }

    public void setVisitorNum(int visitorNum) {
        this.visitorNum = visitorNum;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    public List<PostFavorItem> getFavorItems() {
        return favorItems;
    }

    public void setFavorItems(List<PostFavorItem> favorItems) {
        this.favorItems = favorItems;
    }

    public double[] getLocation() {
        return location;
    }

    public void setLocation(double[] location) {
        this.location = location;
    }
}
