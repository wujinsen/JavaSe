package cn.wjs.javase;

import java.util.ArrayList;
import java.util.List;


public class ForEachDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		for(String s : list){
			System.out.println(s);
		}
		for(int i : list2){
			System.out.println(i);
		}
		System.out.println(add(new int[] {}));
		System.out.println(add(new int[] { 1, 2, 3 }));
		System.out.println(add(1, 2, 3));
		System.out.println(add(1, 2, 3, 6, 7, 8));

	}
	public static int add(int ... data){
		int sum = 0;
		for(int i=0;i<data.length;i++){
			sum +=data[i];
		}
		return sum;
	}
}
