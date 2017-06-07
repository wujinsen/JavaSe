package cn.wjs.javase.thread;

import java.util.HashMap;

public class ThreadLocalTest3 {
	
	private static ThreadLocal<HashMap> local = new ThreadLocal<HashMap>() {
		protected HashMap initialValue() {
			System.out.println(Thread.currentThread().getName()+"initialValue");
			return new HashMap();
		}
	};
	
	public void run(){
		Thread[] runs = new Thread[3];
		for(int i=0;i<runs.length;i++){
			runs[i] = new Thread(new MyThread(i));
		}
		for(int i=0;i<runs.length;i++){
			runs[i].start();
		}
	}
	public static class MyThread implements Runnable{
		int id;
		public MyThread(int id){
			this.id = id;
		}
		public void run(){
			System.out.println(Thread.currentThread().getName()+":start");
			HashMap map = local.get();
			for(int i=0;i<10;i++){
				map.put(i, i+id*100);
				try{
					Thread.sleep(100);
				}catch(Exception ex){
					
				}
			}
			System.out.println(Thread.currentThread().getName()+":"+map);
		}
	}
	public static void main(String[] args) {
		ThreadLocalTest3 test3 = new ThreadLocalTest3();
		test3.run();
	}
}
