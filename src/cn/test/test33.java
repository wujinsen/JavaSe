package cn.test;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class test33 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(85);//0秒
        list.add(80);
        list.add(60);
        list.add(82);
        list.add(83);
        list.add(71);
        list.add(50);//6秒
        //... list.add();//依次累计存放数据
        int resultCount = 0;//累加记录cpu大于80%
        int halfPeriod = 1800;// 1800秒半数周期
        int totalPeriod = 3600;// 3600秒一个周期
        int cpuUsed = 80;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > cpuUsed) {
                resultCount++;
            }
            //cpu使用率大于80%累加超过1800打印，3600秒开始统计
            if (resultCount >= halfPeriod && i >= totalPeriod) {
                System.out.println("resultCount: " + resultCount);
                System.out.println("起始秒: " + (i - 3600));
                System.out.println("结束秒: " + i);
                NumberFormat numberFormat = NumberFormat.getInstance();
                String result = numberFormat.format((float) resultCount / (float) 6 * 100);
                System.out.println("cpu大于80%的比例: " + result + "%");
                //前一个CPU使用率记录数大于80%，统计减1
                if (list.get((i - 3600)) > 80) {
                    resultCount--;
                }
            }

        }
    }
}
