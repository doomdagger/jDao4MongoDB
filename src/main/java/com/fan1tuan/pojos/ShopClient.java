package com.fan1tuan.pojos;

import com.fan1tuan.pojos.support.EntityObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Li He on 2014/4/16.
 * @author Li He
 */
@Document
public class ShopClient extends EntityObject{
    @Id
    private String id; //id of the shop client
    private String username; //shop client sign in name
    private String password; //shop client sign in password

    private List<String> shopIds; //owned shops' ids

}
