package hebei.engineery.univercity.utils;

import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/12/10.
 * 获取md5
 */
public class MD5Util {
    public static String getMD5(String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5= MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String value=base64en.encode(md5.digest(key.getBytes("utf-8")));
        return value;
    }
}
