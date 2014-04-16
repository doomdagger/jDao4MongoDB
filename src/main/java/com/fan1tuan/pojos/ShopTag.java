package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Li He on 2014/4/16.
 * @author Li He
 */
public class ShopTag extends EntityObject{

    private String name;
    private String description;

    private int type;
}
