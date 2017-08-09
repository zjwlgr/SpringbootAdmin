package com.brander.common.utils;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Random;

/**
 * 探针类
 */
public class EnvServlet {

    public long timeUse=0;
    public Hashtable htParam=new Hashtable();
    private Hashtable htShowMsg=new Hashtable();
    public void setHashtable()
    {
        Properties me=System.getProperties();
        Enumeration em=me.propertyNames();
        while(em.hasMoreElements())
        {
            String strKey=(String)em.nextElement();
            String strValue=me.getProperty(strKey);
            htParam.put(strKey,strValue);
        }
    }
    public void getHashtable(String strQuery)
    {
        Enumeration em=htParam.keys();
        while(em.hasMoreElements())
        {
            String strKey=(String)em.nextElement();
            String strValue=new String();
            if(strKey.indexOf(strQuery,0)>=0)
            {
                strValue=(String)htParam.get(strKey);
                htShowMsg.put(strKey,strValue);
            }
        }
    }
    public String queryHashtable(String strKey)
    {
        strKey=(String)htParam.get(strKey);
        return strKey;
    }
    public long test_int()
    {
        long timeStart = System.currentTimeMillis();
        int i=0;
        while(i<3000000)i++;
        long timeEnd = System.currentTimeMillis();
        long timeUse=timeEnd-timeStart;
        return timeUse;
    }
    public long test_sqrt()
    {
        long timeStart = System.currentTimeMillis();
        int i=0;
        double db=(double)new Random().nextInt(1000);
        while(i<200000){db=Math.sqrt(db);i++;}
        long timeEnd = System.currentTimeMillis();
        long timeUse=timeEnd-timeStart;
        return timeUse;
    }

}
