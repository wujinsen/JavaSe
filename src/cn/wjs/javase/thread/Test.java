package cn.wjs.javase.thread;

import java.util.Random;

/**
 * @author 吴锦森
 * @date 2016年2月29日
 */
public class Test {
	public static void main(String[] args) {

//		new Thread() {
//			public void run() {
//				int i = 0;
//				while (i < 10) {
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println(Thread.currentThread().getName() + ":" + i);
//					i++;
//				}
//			}
//		}.start();
		final int sequence = 1;
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(200);
				} catch (Exception e) {
				}
				for (int j = 1; j <= 5; j++) {
					System.out.println(Thread.currentThread().getName() + "is serving " + sequence + " task:" + "loop of " + j);
				}
			}
		}).start();
		Random r = new Random();
		System.out.println(r.nextInt(5));

	}
}
