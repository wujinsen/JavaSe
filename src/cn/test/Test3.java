package cn.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author 吴锦森
 * @date 2016年6月15日
 */
public class Test3 {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.clear();
		list.add("ddd");
		a(0, 100);
		
		Date date = new Date();
		System.out.println(date.getTime());

	}
	public static void a(int min, int max){
	
		int x = 101;
		if(x < min){
			System.out.println("低负荷");
		}else if(x > max){
			System.out.println("高负荷");
		}else{
			System.out.println("中间状态");
		}
	}


	
}

