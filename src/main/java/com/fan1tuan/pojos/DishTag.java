package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;

/**
 * Created by Li He on 2014/4/22.
 * @author Li He
 */
public class DishTag extends EntityObject{

    private String name;
    private String description;

    private String alias;

    private int type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
