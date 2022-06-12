package cn.wjs.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        //获得系统的时间，单位为毫秒,转换为妙
        long totalMilliSeconds = System.currentTimeMillis();

        DateFormat dateFormatterChina = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);//格式化输出
        TimeZone timeZoneChina = TimeZone.getTimeZone("Asia/Shanghai");//获取时区 这句加上，很关键。
        dateFormatterChina.setTimeZone(timeZoneChina);//设置系统时区
        long totalSeconds = totalMilliSeconds / 1000;

        //求出现在的秒
        long currentSecond = totalSeconds % 60;

        //求出现在的分
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;

        //求出现在的小时
        long totalHour = totalMinutes / 60;
        long currentHour = totalHour % 24;

        //显示时间
        System.out.println("总毫秒为： " + totalMilliSeconds);
        System.out.println(currentHour + ":" + currentMinute + ":" + currentSecond + " GMT");

        Date nowTime = new Date(totalMilliSeconds);
        System.out.println("原来: "+totalMilliSeconds);

        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        String retStrFormatNowDate = sdFormatter.format(nowTime);
        System.out.println("时分秒: " + retStrFormatNowDate);
        LocalDateTime localDateTime =  LocalDateTime.ofEpochSecond(totalMilliSeconds/1000, 0, ZoneOffset.ofHours(8));
        LocalDateTime currentLocalDateTime  = LocalDateTime.now();
        if(currentLocalDateTime.plusMinutes(5).isAfter(localDateTime)){
            System.out.println(currentLocalDateTime.plusMinutes(5));
        }else{
            System.out.println(localDateTime);
        }
        System.out.println(localDateTime);



    }
}
