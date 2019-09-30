package com.white.utils;

import java.text.DecimalFormat;

public class TimeShowUtils {
    public static String newSetTime(int time) {
        StringBuilder sb = new StringBuilder();
        //时
        int hour = time / 3600;
        DecimalFormat decimalFormat = new DecimalFormat("00");
        sb.append(decimalFormat.format(hour) + ":");
        //分
        int minute = (time % 3600) / 60;
        sb.append(decimalFormat.format(minute) + ":");
        //秒
        int second = time % 60;
        sb.append(decimalFormat.format(second));
        return sb.toString();
    }

}
