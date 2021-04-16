package cn.test;

import java.util.HashMap;
import java.util.Map;

public class test5 {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("a", "1");
        map.put("a", "2");
        map.put(null, "3");
        System.out.println(map);
        System.out.println(map.get(null));
        System.out.println(map.keySet());
    }
}
