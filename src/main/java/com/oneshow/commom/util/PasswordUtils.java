package com.oneshow.commom.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordUtils {
    public static String saltAndMd5(String userName,String password){
        //加密算法
        String algorithmName = "MD5";
        //原密码
        String source = password;
        //盐值（需要唯一，一般为用户ID）
        Object salt = ByteSource.Util.bytes(userName);
        //加密次数
        int hashIterations = 10;
        SimpleHash hash = new SimpleHash(algorithmName, source, salt, hashIterations);
        return hash.toString();	//32位
    }
}
