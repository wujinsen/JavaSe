package cn.test;

import org.apache.commons.collections.map.StaticBucketMap;
import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

/**
 * @author 吴锦森
 * @date 2016年1月19日
 */
public class Test2 {
	public static void main(String[] args) throws Exception{
		String str = "更改后内容:222";
		setValue(str);
		System.out.println(str);
		Aa a = new Aa("原始内容:aaa");
		setValue2(a);
		System.out.println(a.getName());
	}
	public static String setValue(String str){
		str = "原始内容:111";
		return str;
	}
	public static String setValue2(Aa a){
		a.setName("更改后的内容:bbb");
		return a.getName();
	}
			
}
class Aa{
	private String name;
	public Aa(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
class C1{
	public void fun(){
		System.out.println("Hello");
	}
}
class C2 extends C1{
	public void fun(){
		System.out.println("Hello2");
	}
}