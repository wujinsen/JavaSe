package cn.wjs.sql;

import java.text.SimpleDateFormat;

public class TimestampTest {
    public static void main(String[] args) throws Exception {
        byte a = 127;
        byte b = 127;
        // a = a + b;
        System.out.println(a);
        String str = "20200805";
        System.out.println(str.substring(0, 4));
        System.out.println(str.substring(4, 8));
        // System.out.println(str.substring(8, 12));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(new java.sql.Timestamp(sdf.parse("2020-08-05").getTime()));

    }

}
