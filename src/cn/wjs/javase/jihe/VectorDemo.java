package cn.wjs.javase.jihe;

import java.util.Vector;

/**
 * @author 吴锦森
 * @date 2016年1月22日
 */
public class VectorDemo {
	private static Vector<Integer> vector = new Vector<Integer>();

	public static void main(String[] args) throws Exception {
		while (true) {
			for (int i = 0; i < 10; i++) {
				vector.add(i);
			}
			/*Thread removeThread = new Thread(new Runnable() {
				public void run() {
					for (int i = 0; i < 10; i++) {
						vector.remove(i);
					}
				}
			});*/

			Thread printThread = new Thread(new Runnable() {
				public void run() {
					for (int i = 0; i < 10; i++) {
						vector.get(i);
					}
				}
			});
			//removeThread.start();
			printThread.start();
			System.out.println(Thread.activeCount());
			Thread.sleep(500);
			while (Thread.activeCount() > 20)
				;
		}

	}
}
