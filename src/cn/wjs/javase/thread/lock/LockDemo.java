package cn.wjs.javase.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 吴锦森
 * @date 2016年4月18日
 */
public class LockDemo {
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
	}
}
