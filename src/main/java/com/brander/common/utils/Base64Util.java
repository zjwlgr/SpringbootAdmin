package com.brander.common.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

/**
 * Base64加密、解密
 */
public class Base64Util {

    /**
     * Base64加密
     * @param str 要加密的字符串
     * @return String 加密后的字符串
     */
    public static String encodeBase64(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    /**
     * Base64解密
     * @param s 要解密的字符串
     * @return String 解密后的字符串
     */
    public static String decodeBase64(String s) {
        byte[] b = null;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // 测试主函数
    public static void main(String args[]) {
        String s = "xtwvfwlgr";
        String d = "eHR3dmZ3bGdy";
        System.out.println("加密：" + encodeBase64(s));
        System.out.println("解密：" + decodeBase64(d));
    }
}
