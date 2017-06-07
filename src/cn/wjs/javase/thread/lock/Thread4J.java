package cn.wjs.javase.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 吴锦森
 * @date 2016年4月18日
 */
public class Thread4J {
	static countJ c = new countJ();
	public static void main(String[] args) {
		for(int i=0;i < 2; i++){
			new Thread(){
				public void run(){
					while(true){
						c.add();
					}
				}
			}.start();
		}
		for(int i=0; i<2; i++){
			new Thread(){
				@Override
				public void run() {
					while (true) {
						c.min();
					}
				}}.start();

		}
	}
}
class countJ{
	int j = 0;
	Lock lock = new ReentrantLock();//实现了Lock接口
	
	public void add() {
		lock.lock();
		j++;
		System.out.println(Thread.currentThread().getName()+", j增加1之后等于: "+j);
		lock.unlock();
	}

	public void min() {
		lock.lock();
		j--;
		System.out.println(Thread.currentThread().getName()+", j减少1之后等于: "+j);
		lock.unlock();
	}
	
}
