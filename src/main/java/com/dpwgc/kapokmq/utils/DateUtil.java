package com.dpwgc.kapokmq.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取当前时间
 */
public class DateUtil {



    public String getDateTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        return sdf.format(date);
    }
}
