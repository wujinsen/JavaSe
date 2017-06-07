package cn.wjs.javase.jihe;

import java.util.Stack;

/**
 * @author 吴锦森
 * @date 2016年1月22日
 * 说明:栈是一种后进先出的数据结构
 */
public class StackDemo {
	public static void main(String[] args) {
		Stack<String> all = new Stack<String>();
		all.push("A");
		all.push("B");
		all.push("C");
		System.out.println(all.pop());
		System.out.println(all.pop());
		System.out.println(all.pop());
		System.out.println(all.pop());	// 无内容，EmptyStackException
	}
}
