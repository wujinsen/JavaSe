package cn.wjs.javase.jihe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 吴锦森
 * @date 2016年1月22日
 */
public class HashMapDemo {
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap();
		map.put("Hello", 100);
		map.put("Hello", 900); // key重复，新的内容替换掉旧的内容
		map.put("World", 200);
		
		keyvalue(map);
		
	}
	/*
	 * 输出map的key和value
	 */
	public static void keyvalue(Map map) {
		map.put("Hello", 100);
		map.put("Hello", 900); // key重复，新的内容替换掉旧的内容
		map.put("World", 200);
		Set<Map.Entry<String, Integer>> set = map.entrySet(); // 变为Set集合,不允许重复
		Iterator<Map.Entry<String, Integer>> iter = set.iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Integer> me = iter.next();
			System.out.println(me.getKey() + " --> " + me.getValue());
		}
	}

}
