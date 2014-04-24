package com.fan1tuan.business.support.enums;

/**
 * Created by Li He on 2014/4/24.
 * @author Li He
 */
public enum PostSource {
    WEB,
    ANDROID,
    IPHONE,
    IPAD,
    WINPHONE;

    public static PostSource valueOf(int ordinal){
        PostSource postSource;
        switch (ordinal){
            case 0: postSource = WEB;break;
            case 1: postSource = ANDROID;break;
            case 2: postSource = IPHONE;break;
            case 3: postSource = IPAD;break;
            case 4: postSource = WINPHONE;break;
            default:throw new AssertionError("Not Supported Post Source with given value:"+ordinal+". Please refer PostSource for detail.");
        }
        return postSource;
    }

}
