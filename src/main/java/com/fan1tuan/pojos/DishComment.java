package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Li He on 2014/4/16.
 * @author Li He
 */
@Document
public class DishComment extends EntityObject{
    @Id
    private String id; //id of dishComment

    private String userId; //user id offer the comment
    private String username; // user name, not realname, username can be phone number, but not definitely are
    private String userAvatar; // user image path

    private String dishId; // dish id
    private String dishName;
    private String dishAvatar;

    private String shopId; // shop id
    private String shopName; //shop name

    private String comment; // comment content
    private int commentLevel; // offer comment level 1-5
    private Date date;// date of the offered comment

}
