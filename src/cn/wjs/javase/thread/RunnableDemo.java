package cn.wjs.javase.thread;

public class RunnableDemo {
	public static void main(String[] args) throws Exception{
		ThreadDemo2 t1 = new ThreadDemo2("线程1");
		ThreadDemo2 t2 = new ThreadDemo2("线程2");
		ThreadDemo2 t3 = new ThreadDemo2("线程3");
		ThreadDemo2 t4 = new ThreadDemo2("线程4");
		Thread t = new Thread(t1);
		t.start();
	}
}
class ThreadDemo2 implements Runnable{
	private String name;
	public ThreadDemo2(String name){
		this.name = name;
	}
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(this.name + "，i = " + i);
		}
	}
}
