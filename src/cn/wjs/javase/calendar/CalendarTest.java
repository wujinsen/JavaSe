package cn.wjs.javase.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = df.parse("2020-08-08 08:08:08");   //当前系统时间
        Date firstTime = df.parse("2020-07-07 07:07:07");     //查询的数据时间
        String str = getTime(currentTime, firstTime);
        System.out.println("获取的年月日时分秒时间差为：" + str);

    }

    //获取时间差方法
    public static String getTime(Date currentTime, Date firstTime) {
        long diff = currentTime.getTime() - firstTime.getTime();//这样得到的差值是微秒级别
        Calendar currentTimes = dataToCalendar(currentTime);//当前系统时间转Calendar类型
        Calendar firstTimes = dataToCalendar(firstTime);//查询的数据时间转Calendar类型
        int year = currentTimes.get(Calendar.YEAR) - firstTimes.get(Calendar.YEAR);//获取年
        int month = currentTimes.get(Calendar.MONTH) - firstTimes.get(Calendar.MONTH);
        int day = currentTimes.get(Calendar.DAY_OF_MONTH) - firstTimes.get(Calendar.DAY_OF_MONTH);
        if (day < 0) {
            month -= 1;
            currentTimes.add(Calendar.MONTH, -1);
            day = day + currentTimes.getActualMaximum(Calendar.DAY_OF_MONTH);//获取日
        }
        if (month < 0) {
            month = (month + 12) % 12;//获取月
            year--;
        }
        System.out.println("diff: " + diff);
        long days = diff / (1000 * 60 * 60 * 24);
        System.out.println("days: " + days);
        long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60); //获取时
        long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);  //获取分钟
        long s = (diff / 1000 - days * 24 * 60 * 60 - hours * 60 * 60 - minutes * 60);//获取秒
        String CountTime = "" + year + "年" + month + "月" + day + "天" + hours + "小时" + minutes + "分" + s + "秒";
        return CountTime;
    }

    //Date类型转Calendar类型
    public static Calendar dataToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
