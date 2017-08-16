package com.brander.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组工具类
 */
public class MyArrayUtil {

    /**
     * 字符数组排重操作
     * @param arr 要去重的数组
     * @return String[] 返回去重后的数组
     * */
    public static String[] ArrayRemove(String[] arr){
        String[] array = arr;
        List<String> result = new ArrayList<>();
        boolean flag;
        for(int i=0;i<array.length;i++){
            flag = false;
            for(int j=0;j<result.size();j++){
                if(array[i].equals(result.get(j))){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                result.add(array[i]);
            }
        }
        String[] arrayResult = (String[]) result.toArray(new String[result.size()]);
        return arrayResult;
    }

    /**
     * 判断数组中是否包含某元素
     * @param arr 数组
     * @param targetValue 要查找的元素
     * */
    public static boolean useLoop(String[] arr,String targetValue){
        for(String s:arr){
            if(s.equals(targetValue))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
