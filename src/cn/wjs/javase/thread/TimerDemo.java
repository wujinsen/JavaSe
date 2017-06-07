package cn.wjs.javase.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 吴锦森
 * @date 2016年2月29日
 */
public class TimerDemo {
	public static void main(String[] args) {
		// public void schedule(TimerTask task, long delay, long period) {}
		new Timer().schedule(new TimerTask() {
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		}, 2000, 1000);// 过2秒后执行，执行间隔1秒
		Timer t = new Timer();
		long delay1 = 1 * 1000;
		long period1 = 1000;
		// 从现在开始 1 秒钟之后，每隔 1 秒钟执行一次 job1
		t.schedule(new TimerTest("job1"), delay1, period1);
		long delay2 = 2 * 1000;
		long period2 = 2000;
		// 从现在开始 2 秒钟之后，每隔 2 秒钟执行一次 job2
		t.schedule(new TimerTest("job2"), delay2, period2);
	}
}

class TimerTest extends TimerTask {
	private String jobName = "";

	public TimerTest(String jobName) {
		super();
		this.jobName = jobName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("execute:" + jobName);
	}

}