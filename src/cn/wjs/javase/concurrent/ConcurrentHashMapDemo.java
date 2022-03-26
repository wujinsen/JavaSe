package cn.wjs.javase.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author 吴锦森
 * @version 创建时间：2015年5月27日
 * 类说明
 */
public class ConcurrentHashMapDemo {
	//ConcurrentHashMap和HashMap的一个不同点就是ConcurrentHashMap里不能存放key和value为空的值
    public static void main(String[] args) {
        ConcurrentMap map = new ConcurrentHashMap();
        Map hashMap = new HashMap();

    }

}
