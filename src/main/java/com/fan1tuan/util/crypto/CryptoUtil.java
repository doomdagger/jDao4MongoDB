package com.fan1tuan.util.crypto;

/**
 * Created by Li He on 2014/4/25.
 * @author Li He
 */
public class CryptoUtil {

    public static String encode_md5(String origin){
        return MD5Digest.encode(origin);
    }
}
