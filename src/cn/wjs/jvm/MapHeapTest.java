package cn.wjs.jvm;

import java.util.HashMap;

public class MapHeapTest {
    public static void main(String[] args) throws Exception {

        String userlabel="12345678998765432100";
        long start = 0;
        long end = 0;
        // 先垃圾回收
        System.gc();
        start = Runtime.getRuntime().freeMemory();
        HashMap map = new HashMap();
        for (int i = 0; i < 30000; i++) {
            map.put("1111,2222,3333"+String.valueOf(i), userlabel);
        }
        // 快要计算的时,再清理一次
        System.gc();
        end = Runtime.getRuntime().freeMemory();
        System.out.println("一个HashMap对象占内存:" + (end - start));
    }

}
