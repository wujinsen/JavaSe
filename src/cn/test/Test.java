package cn.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// JSONObject allData = new JSONObject();
		// JSONArray array = new JSONArray();
		// JSONObject temp = new JSONObject();
		// temp.put("deptid", "1");
		// temp.put("title", "zhangsan");
		// array.add(temp);
		// allData.put("allDepts", array);
		// System.out.println(allData);
		// String[] array = new String[]{"1", "2", "3"};
		// for(int i=0; i<array.length;i++){
		// System.out.println(i);
		// System.out.println(array[2]);
		// }

//			int c = 1;
//			System.out.print(c + ": ");
//			switch (c) {
//			case 1:
//				System.out.println("vowel");
//				//break;
//			case 2:
//				break;
//			case 3:
//				System.out.println("Sometimes a vowel");
//				break;
//			default:
//				System.out.println("consonant");
//			}
//		}
//		boolean flag = true;
//		System.out.println(flag);
//		flag = false;
//		System.out.println(flag);
		
//		String str = "2";
//		String a[] = str.split("\\,");
//		StringBuffer sb = new StringBuffer();
//		for(int i = 0; i<a.length; i++){
//			System.out.println(a[i]);
//			if(a[i].equals("1")){
//				System.out.println(sb.append("就诊陪护" + ","));
//			}
//			if(a[i].equals("2")){
//				System.out.println(sb.append("住院陪护" + ","));
//			}
//			if(a[i].equals("3")){
//				//a[i] = ;
//				System.out.println(sb.append("家庭陪护" + ","));
//			}
//			if(a[i].equals("4")){
//		
//				System.out.println(sb.append("母婴陪护" + ","));
//			}
			
//			if(a[i].contains("1")){
//				a[i] = "就诊陪护";
//				System.out.println(sb.append(a[i]) + ",");
//			}
//		}
		//System.out.println("最终输出:" + sb.toString().substring(0,sb.length()-1));
//		String aaa = "123456";
//		System.out.println(aaa.substring(0,aaa.length()-1));
//		JSONObject j = new JSONObject();
//		JSONObject j2 = new JSONObject();
//		JSONArray array = new JSONArray();
//		j.put("id", 1);
//		j.put("name", "zhangsan");
//		j.put("sex", "female");
//		j.put("wocao", "wocao");
//		j2.put("nidaye", "nidaye");
//		System.out.println(j);
//		array.add(j);
//	
//		System.out.println(array);
//		array.add(j2);
//		System.out.println(array);
//		String str = "";
//		if(str != null && str.length() > 0){//str.length != 0
//			System.out.println("hello");
//		}
//		if(str == null || str.length() <= 0){
//			System.out.println("hello2");
//		}
//		String p[] = "2|3|4".split("\\|");
//		for(String str2 : p){
//			System.out.println(str2);
//		}
		
		Map map = new HashMap();
		map.put("a", 100);
		map.put("b", 200);
		map.put("c", 300);
		System.out.println(map.keySet());//取得map全部的key
		List list = new ArrayList();
		list.add(null);
		System.out.println(list);
		list.add("aafds");
		String str = null;
		str = "hello";
		System.out.println(str);
		System.out.println(Math.sqrt(18));
		int aa = 0;
		int arr[][] = new int[5][5];
		arr[0][0] = 1;
		arr[0][1] = 2;
		System.out.println(arr[0][aa--] + "," + aa);
		int a = 8010956-2518220;
		int b = 1504256+220876+3767604;
		System.out.println(a);
		System.out.println(b);
		
	}
}
