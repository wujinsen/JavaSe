package cn.wjs.javase.jihe;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 吴锦森
 * 保存了记录的插入顺序
 * @date 2016年6月15日
 */
public class LinkedHashMapDemo {
	public static void main(String[] args) {
		   System.out.println("*************************LinkedHashMap*************");
		   Map<Integer,String> map = new LinkedHashMap<Integer,String>();
		   map.put(6, "apple");
		   map.put(3, "banana");
		   map.put(2,"pear");
		   for(Iterator it = map.keySet().iterator();it.hasNext();){
			   Object key = it.next();
			   System.out.println(key + "=" + map.get(key));
		   }
	}
}
