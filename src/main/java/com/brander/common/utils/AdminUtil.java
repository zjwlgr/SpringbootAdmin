package com.brander.common.utils;

/**
 * 后台功能所用工具类
 */
public class AdminUtil {

    /**
     * 管理员分组添加与编辑，checkbox 接收，处理返回 fid列表与 zid列表
     * @param arrcheckbos 接收到的checkbox数组
     * @param type fid返回fid字符串，zid返回zid字符串
     * */
    public static String managerGroupCheckbox(String[] arrcheckbos,String type){
        String zid = "",fid = "";
        for(String str : arrcheckbos){
            //拆开 fid与zid
            String [] idArr = str.split("_");
            fid = fid + idArr[0]+",";
            zid = zid + idArr[1]+",";
        }
        String [] fidArr = fid.split(",");
        String [] newFidArr = MyArrayUtil.ArrayRemove(fidArr);//fid排重
        String newFid = "";
        for(String ar : newFidArr){
            newFid = newFid + ar+",";
        }
        if(type.equals("fid")){
            return newFid;
        }else{
            return zid;
        }
    }
}
