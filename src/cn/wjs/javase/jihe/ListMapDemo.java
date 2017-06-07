package cn.wjs.javase.jihe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 吴锦森 
 * @version 创建时间：2015年5月8日
 * 类说明 List<Map<Striing, Object>>
 * list的输入值和输出值
 * map的输入值和输出值
 * list和map的输入和输出值
 * 利用迭代器将list里的值取出来
 */
public class ListMapDemo {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("dd");
		list.add("aa");
		list.add("aa");
		list.add("cc");
		for(Iterator<String> ite=list.iterator();ite.hasNext();){
			Object o = ite.next();
			System.out.println(o);
		}
//		Iterator<String> ite = list.iterator();
//		while(ite.hasNext()){
//			System.out.println(ite.next());
//		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 007);
		map.put("name", "zhangsan");
		System.out.println(map.get("id") + " " + map.get("name"));
		Set<String> all = map.keySet(); // 取得全部的key
		Iterator<String> iter = all.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + ",");//输出全部的key
			
		}
		System.out.println();
		//Iterator输出Map接口
		Set<Map.Entry<String, Object>> set = map.entrySet();// 变为Set集合
		Iterator<Map.Entry<String, Object>> ite2 = set.iterator();
		while(ite2.hasNext()){
			Map.Entry<String, Object> m = ite2.next();
			System.out.println(m.getKey() + "-->" + m.getValue());
		}
		//-- 测试Iterator
		System.out.println("--测试Iterator--");
		List list2 = new ArrayList();
		list2.add("一");
		list2.add("二");
		list2.add("三");
		Iterator iter2 = list2.iterator();
		while(iter2.hasNext()){
			System.out.println(iter2.next());
		}
		for(int i=0;i<list2.size();i++){
			System.out.println(list2.get(2));
		}
		
	}
}
