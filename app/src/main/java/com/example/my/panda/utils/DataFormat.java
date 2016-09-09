package com.example.my.panda.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将字符串的是时间值转换成时间格式
 */
public class DataFormat {

    public static String dataFormat(String strDate){
        //定义日期模板
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
        //将传入的字符串转换成long类型的数值
        long time = Long.parseLong(strDate);
        //定义一个日期对象
        Date date = new Date();
        //为日期设置具体属性
        date.setTime(time * 1000);
        //通过日期模板日期转换成指定的样式
        return sdf.format(date);
    }
}
