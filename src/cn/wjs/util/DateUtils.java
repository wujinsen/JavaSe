package cn.wjs.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author 吴锦森
 * @version 创建时间：2015年5月19日
 * 类说明
 */
public class DateUtils {


//    public void static aaa(){
//        // 当前时间
//        LocalDateTime now = LocalDateTime.now();
//// 本周开始时间
//        Date startTimeInWeek = now.withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withDayOfWeek(DateTimeConstants.MONDAY).toDate();
//// 本周结束时间
//        Date endTimeInWeek = now.withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59).withDayOfWeek(DateTimeConstants.SUNDAY).toDate();
//    }

    public static void main(String[] args) throws Exception {
        //Date转换为LocalDateTime
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdFormatter.parse("2022-06-11 12:00:00");
        Date fiveDate = sdFormatter.parse("2022-06-11 12:05:01");

        //心跳时间
        LocalDateTime currentLocalDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());//当期时间
        LocalDateTime fiveCurrentLocalDateTime = LocalDateTime.ofInstant(fiveDate.toInstant(), ZoneId.systemDefault());//当期时间
        System.out.println("currentLocalDateTime: " + currentLocalDateTime + " fiveCurrentLocalDateTime: " + fiveCurrentLocalDateTime);
        if(fiveCurrentLocalDateTime.isAfter(currentLocalDateTime.plusMinutes(5))){
            System.out.println("aaa");
        }else{
            System.out.println("bbb");
        }

    }

}
