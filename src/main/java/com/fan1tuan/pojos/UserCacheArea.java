package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

/**
 * Created by Li He on 2014/4/25.
 * @author Li He
 */
public class UserCacheArea extends EntityObject{

    private String cacheAreaId;
    private String name;
    private double[] location;

    public String getCacheAreaId() {
        return cacheAreaId;
    }

    public void setCacheAreaId(String cacheAreaId) {
        this.cacheAreaId = cacheAreaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getLocation() {
        return location;
    }

    public void setLocation(double[] location) {
        this.location = location;
    }
}
