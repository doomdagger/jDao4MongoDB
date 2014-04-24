package com.fan1tuan.business.support.enums;

/**
 * Created by Li He on 2014/4/22.
 * @author Li He
 */
public enum UserSecureStrategy {
    OPEN_TO_ALL("对所有人可见"),
    OPEN_TO_FRIENDS("仅对好友可见"),
    OPEN_TO_NULL("对所有人不可见");

    private String message;

    private UserSecureStrategy(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public static UserSecureStrategy valueOf(int ordinal){
        UserSecureStrategy userSecureStrategy;
        switch (ordinal){
            case 0: userSecureStrategy = OPEN_TO_ALL;break;
            case 1: userSecureStrategy = OPEN_TO_FRIENDS;break;
            case 2: userSecureStrategy = OPEN_TO_NULL;break;
            default:throw new AssertionError("Not Supported User Secure Strategy with given value:"+ordinal+". Please refer UserSecureStrategy for detail.");
        }
        return userSecureStrategy;
    }
}
