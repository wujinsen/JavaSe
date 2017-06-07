package cn.wjs.javase.thread;

import java.util.Random;

/**
 * @author 吴锦森
 * @date 2016年2月29日
 * 个人理解:通过两个类通过TheadLocal对象拿到内容，互不影响
 * MyThreadLocalData.getMyData静态方法拿到的对象都不相同，但对于同一个线程来说，
 * 不管调用MyThreadLocalData.getMyData多少次和在哪里调用，拿到的都是同一个MyThreadLocalData对象。
 */
public class ThreadLocalTest {

	public static void main(String[] args) {
		final A a = new A();
		final B b = new B();
		for (int i = 0; i < 5; i++) {
			new Thread() {
				public void run() {
					/*
					 * 1. MyThreadLocalData.x.set(new Random().nextInt(10000)); System.out.println(Thread.currentThread() + "has put " + MyThreadLocalData.x.get()); a.say(); b.sayHello();
					 */
					/*
					 * 2. MyThreadLocalData.set(new Random().nextInt(10000)); System.out.println(Thread.currentThread() + "has put " + MyThreadLocalData.get()); a.say(); b.sayHello();
					 */
					MyThreadLocalData.getMyData().setX(new Random().nextInt(100));
					System.out.println(Thread.currentThread() + "has put " + MyThreadLocalData.getMyData().getX());
					a.say();
					b.sayHello();
					MyThreadLocalData.clear();
				}
			}.start();
		}

	}

}

class MyThreadLocalData {
	// 1. public static ThreadLocal x = new ThreadLocal();
	/*
	 * 2. private static ThreadLocal x = new ThreadLocal(); 
	 * public static void set(Object val){ x.set(val); }
	 * 
	 * public static Object get(){ return x.get(); }
	 */
	//public static ThreadLocal x = new ThreadLocal();
	
	private MyThreadLocalData() {
	}

	private static ThreadLocal instanceContainer = new ThreadLocal();

	public static MyThreadLocalData getMyData() {
		MyThreadLocalData instance = (MyThreadLocalData) instanceContainer.get();
		
		if (instance == null) {
			instance = new MyThreadLocalData();
			instanceContainer.set(instance);
		}
		return instance;
	}

	public static void clear() {
		instanceContainer.remove();
	}

	private Integer x;

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getX() {
		return x;
	}

}

class A {
	public void say() {
		//  System.out.println(Thread.currentThread() + ": A has getted " + MyThreadLocalData.x.get());
		 // System.out.println(Thread.currentThread() + ": A has getted " + MyThreadLocalData.get());
		System.out.println(Thread.currentThread() + ": A has getted " + MyThreadLocalData.getMyData().getX());
	}
}

class B {
	public void sayHello() {
		// 1. System.out.println(Thread.currentThread() + ": B has getted " + MyThreadLocalData.x.get());
		// 2. System.out.println(Thread.currentThread() + ": B has getted " + MyThreadLocalData.get());
		System.out.println(Thread.currentThread() + ": B has getted " + MyThreadLocalData.getMyData().getX());

	}
}
