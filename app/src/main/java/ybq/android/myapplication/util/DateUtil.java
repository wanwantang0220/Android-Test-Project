package ybq.android.myapplication.util;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {
    /**
     * 获取今天往后一周的日期（几月几号）
     */
    public static List<WeekDay> getSevendate() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));

        List<WeekDay> list = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            String mYear ,mMonth,mDay;
            mYear = String.valueOf(c.get(Calendar.YEAR));// 获取当前年份
            mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
            mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH) + i);// 获取当前日份的日期号码
            if(Integer.parseInt(mDay) > MaxDayFromDay_OF_MONTH(Integer.parseInt(mYear),(i+1))){
                mDay = String.valueOf(MaxDayFromDay_OF_MONTH(Integer.parseInt(mYear),(i+1)));
            }
            String str = mYear+"-"+mMonth+"-"+mDay;
            Log.i("TAG",str);

            WeekDay weekDay = new WeekDay();
            weekDay.week = getWeek(str);
            weekDay.day = str;//new SimpleDateFormat("MM-dd").format(calendar.getTime());

            list.add(weekDay);
        }


        return list;
    }

    /**
     * 根据当前日期获得是星期几
     * 
     * @return
     */
    public static String getWeek(String time) {
        String Week = "";

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            Week += "周天";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 2) {
            Week += "周一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 3) {
            Week += "周二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 4) {
            Week += "周三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 5) {
            Week += "周四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 6) {
            Week += "周五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 7) {
            Week += "周六";
        }
        return Week;
    }


    /**得到当年当月的最大日期**/
    public static int MaxDayFromDay_OF_MONTH(int year,int month){
        Calendar time=Calendar.getInstance();
        time.clear();
        time.set(Calendar.YEAR,year);
        time.set(Calendar.MONTH,month-1);//注意,Calendar对象默认一月为0                 
        int day=time.getActualMaximum(Calendar.DAY_OF_MONTH);//本月份的天数
        return day;
    }

    @SuppressLint("SimpleDateFormat")
    public static List<WeekDay> getWeekDay() {
        Calendar calendar = Calendar.getInstance();
        // 获取本周的第一天
        int firstDayOfWeek = calendar.getFirstDayOfWeek();
        List<WeekDay> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            calendar.set(Calendar.DAY_OF_WEEK, firstDayOfWeek + i);
            WeekDay weekDay = new WeekDay();
            // 获取星期的显示名称，例如：周一、星期一、Monday等等
            weekDay.week = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.ENGLISH);
            weekDay.day = new SimpleDateFormat("MM-dd").format(calendar.getTime());
            list.add(weekDay);
        }

        return list;
    }

    public static class WeekDay {
        /** 星期的显示名称*/
        public String week;
        /** 对应的日期*/
        public String day;

        @Override
        public String toString() {
            return "WeekDay{" +
                    "week='" + week + '\'' +
                    ", day='" + day + '\'' +
                    '}';
        }
    }

}
