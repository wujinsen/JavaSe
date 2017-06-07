package cn.wjs.javase.fanshe;

import java.lang.reflect.Method;

public class InvokeDemo {
	public static void main(String[] args) throws Exception{
		
		Class<?> cls  = Class.forName("cn.wjs.javase.fanshe.User2");
		Object obj = cls.newInstance();//实例化对象
		System.out.println("getClassLoader():"+obj.getClass().getClassLoader());//返回类的类加载器或该对象表示的接口
		System.out.println("getInterfaces():"+obj.getClass().getInterfaces());//返回该类实现的接口数组
		Method setNameMethod = cls.getMethod("setName", String.class);//setName与实体类User2的setName一样
		//System.out.println("getname:"+setNameMethod.getName());
		Method getNameMethod = cls.getMethod("getName");
		//System.out.println("getname2:"+getNameMethod.getName());
		setNameMethod.invoke(obj, "wujinsen");//设置name的内容
		//System.out.println(setNameMethod.invoke(obj, "wujinsen"));
		System.out.println(getNameMethod.invoke(obj));//取得getName
		
	}
}

class User2{
	private String name;
	public User2(){
		System.out.println("User类的构造方法");
	}
	public String toString(){
		return "User类的toString()方法";
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
