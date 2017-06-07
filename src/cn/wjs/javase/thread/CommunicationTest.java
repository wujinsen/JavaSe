package cn.wjs.javase.thread;

/**
 * @author 吴锦森
 * @date 2016年2月29日 同步互斥用买票或统计service方法被第几次调用的例子。 通信的例子代码如下：
 * 下面类中的put与get方法的Thread.sleep休息多长时间与能否看到get和put方法同步通信的效果是没有关系的，
 * 因为在get方法进入了sleep状态时，此时put方法是根本进不去的，所以，它内部的sleep方法是不会执行的，其休息的时间自然也没什么意义了。

 */
public class CommunicationTest {

	protected static int LOOPCOUNT = 10;

	public static void main(String[] args) {
		final Person2 p = new Person2();
		final Business2 bs = new Business2();
		new Thread() {
			public void run() {
				boolean bMale = false;
				/*
				 * while(true){
				 * 
				 * System.out.println(Thread.currentThread().getName() + " is runningg"); if(bMale){ p.put("zxx","male");} else p.put("cq", "female"); bMale = !bMale; }
				 */
				for (int n = 1; n <= LOOPCOUNT; n++) {
					bs.subMethod(n);
				}
			}

		}.start();

		new Thread(new Runnable() {
			public void run() {
				/*
				 * while(true){
				 * 
				 * System.out.println(Thread.currentThread().getName() + " thread1 is runningg"); p.get(); }
				 */
				for (int n = 1; n <= LOOPCOUNT; n++) {
					bs.mainMethod(n);
				}
			}

		}).start();
	}
}

class Business2 {
	boolean bShouldSub = true;

	public synchronized void subMethod(int num) {
		if (!bShouldSub)
			try {
				this.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + ": loop of " + i + ":" + " time of " + num);
		}
		bShouldSub = false;
		this.notify();
	}

	public synchronized void mainMethod(int num) {
		if (bShouldSub)
			try {
				this.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + ": loop of " + i + ":" + " time of " + num);
		}
		bShouldSub = true;
		this.notify();
	}

}

class Person2 {
	private String name;
	private String gender;

	private boolean bPuted = false;

	public synchronized void put(String name, String gender) {
		if (bPuted)
			try {
				this.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		this.name = name;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.gender = gender;

		bPuted = true;
		this.notify();
	}

	public synchronized void get() {
		if (!bPuted)
			try {
				this.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		System.out.println(name + ":" + gender);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bPuted = false;
		this.notify();
	}
}