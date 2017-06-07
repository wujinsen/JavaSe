package cn.wjs.javase.thread;

public class ThreadDemo {
	public static void main(String[] args) {
		ThreadOne t1 = new ThreadOne("线程A");
		ThreadOne t2 = new ThreadOne("线程B");
		ThreadOne t3 = new ThreadOne("线程C");
		Thread t4 = new ThreadOne("线程D");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		new Thread(){//匿名线程
			public void run(){
				System.out.println("hello");
			}
		}.start();
	}
}

class ThreadOne extends Thread{
	private String name;
	public ThreadOne(String name){
		this.name = name;
	}
	int num = 0;
	public void run(){
		for(int x = 0; x <10; x++){
			num++;
			System.out.println(this.name + "，x = " + x); 
		}
		System.out.println("num:"+num);
	}
}

/*
new Thread(){
	public void run(){do something...}}.start();
*/