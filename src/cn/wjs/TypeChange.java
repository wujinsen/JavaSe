package cn.wjs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 吴锦森
 * @date 2015年12月27日
 */
public class TypeChange {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("aa", 1);
		map.put(1, 1);
		String a = map.get("aa").toString();
		String b = map.get(1).toString();
		int c =  (int) map.get(1);
		System.out.println(a);
		System.out.println(b);
		//System.out.println(c);
		List list = new ArrayList();
		list.add("aaa");
		System.out.println(list.indexOf("aaa"));
	}
}
