package com.example.my.panda.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by virgil on 2016/8/6.
 * email 841864388@qq.com
 */
public class Tools {

    private static final long ONE_MINUTE = 60000L;//分钟
    private static final long ONE_HOUR = 3600000L;//小时
    private static final long ONE_DAY = 86400000L;//天数
    private static final long ONE_WEEK = 604800000L;//周数

    private static final String ONE_SECOND_AGO = "秒前";//几秒前
    private static final String ONE_MINUTE_AGO = "分钟前";//几分钟前
    private static final String ONE_HOUR_AGO = "小时前";//几小时前
    private static final String ONE_DAY_AGO = "天前";//几天前
    private static final String ONE_MONTH_AGO = "月前";//几月前
    private static final String ONE_YEAR_AGO = "年前";//几年前

    /**
     * 毫秒转为yyyy-MM-dd的日期格式
     *
     * @param milli
     * @return
     */
    public static String milliToDate(String milli) {
        //获取Long型的事件
        long timeLong = Long.parseLong(milli) * 1000;
        //创建Date对象那个
        Date date = new Date(timeLong);
        //时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(date);
    }


    /**
     * 获取几月、天、小时、分钟前
     *
     * @param milli
     * @return
     */
    public static String RelativeDateFormat(String milli) {
        //获取时间
        String post_time = milliToDate(milli);
        String formatTime = "";
        //时间格式
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            //装换成Date类型
            Date date = format.parse(post_time);
            //格式化时间
            formatTime = format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatTime;
    }

    /**
     * 获取几时、分、秒前
     * @param date
     * @return
     */
    public static String format(Date date) {
        long delta = new Date().getTime() - date.getTime();
        if (delta < 1L * ONE_MINUTE) {
            long seconds = toSeconds(delta);
            //几分钟前
            return (seconds <= 0 ? 1 : seconds) + ONE_SECOND_AGO;
        }
        if (delta < 45L * ONE_MINUTE) {
            long minutes = toMinutes(delta);
            //几分钟前
            return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
        }
        if (delta < 24L * ONE_HOUR) {
            long hours = toHours(delta);
            //几小时前
            return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
        }
        if (delta < 48L * ONE_HOUR) {
            return "昨天";
        }
        if (delta < 30L * ONE_DAY) {
            long days = toDays(delta);
            //几天前
            return (days <= 0 ? 1 : days) + ONE_DAY_AGO;
        }
        if (delta < 12L * 4L * ONE_WEEK) {
            long months = toMonths(delta);
            //几月前
            return (months <= 0 ? 1 : months) + ONE_MONTH_AGO;
        } else {
            long years = toYears(delta);
            //几年前
            return (years <= 0 ? 1 : years) + ONE_YEAR_AGO;
        }
    }

    private static long toSeconds(long date) {
        return date / 1000L;
    }

    private static long toMinutes(long date) {
        return toSeconds(date) / 60L;
    }

    private static long toHours(long date) {
        return toMinutes(date) / 60L;
    }

    private static long toDays(long date) {
        return toHours(date) / 24L;
    }

    private static long toMonths(long date) {
        return toDays(date) / 30L;
    }

    private static long toYears(long date) {
        return toMonths(date) / 365L;
    }


    /**
     * 判断字符串是否为全数字
     *
     * @param num
     * @return
     */
    public static boolean matchNumber(String num) {
        //正则匹配数字
        Pattern pattern = Pattern.compile("^[0-9]+$");
        //匹配器
        Matcher matcher = pattern.matcher(num);
        //是否匹配
        return matcher.matches();
    }
}
