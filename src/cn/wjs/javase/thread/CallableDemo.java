package cn.wjs.javase.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author 吴锦森
 * @date 2016年3月2日
 */
public class CallableDemo {
	public static void main(String[] args) throws Exception{
		MyThread3 mt1 = new MyThread3("线程A") ;
		MyThread3 mt2 = new MyThread3("线程B") ;
		MyThread3 mt3 = new MyThread3("线程C") ;
		FutureTask<String> ftA = new FutureTask<String>(mt1) ;
		FutureTask<String> ftB = new FutureTask<String>(mt2) ;
		FutureTask<String> ftC = new FutureTask<String>(mt3) ;
		new Thread(ftA).start();
		new Thread(ftB).start();
		new Thread(ftC).start();
		System.out.println("线程A返回值：" + ftA.get());
		System.out.println("线程B返回值：" + ftB.get());
		System.out.println("线程C返回值：" + ftC.get());

	}
}
class MyThread3 implements Callable<String> {// 线程类
	private String name ;
	public MyThread3(String name) {
		this.name = name ;
	}
	//能够获取返回的数据
	@Override
	public String call() throws Exception {
		for (int x = 0 ; x < 10 ; x ++) {
			System.out.println(this.name + "，x = " + x);
		}
		return "Hello World .";
	}	
}
