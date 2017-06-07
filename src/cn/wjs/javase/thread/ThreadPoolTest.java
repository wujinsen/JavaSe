package cn.wjs.javase.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 吴锦森
 * @date 2016年3月1日
 */
public class ThreadPoolTest {
	public static void main(String[] args) {
		 //ExecutorService service = Executors.newFixedThreadPool(3);//固定大小的线程池,这里设为3个
		//ExecutorService service2 = Executors.newScheduledThreadPool(0);//用来调度即将执行的任务的线程池
		ExecutorService service = Executors.newCachedThreadPool();//当前有多少个任务，就会分配多少个线程为之服务

		for (int i = 1; i <= 10; i++) {
			final int sequence = i;
			// 仔细品味runnable对象放到循环里面和外面的区别，为了让每个对象有自己独立的编号
			service.execute(new Runnable() {
				public void run() {
					try {
						Thread.sleep(200);
					} catch (Exception e) {
					}
					for (int j = 1; j <= 5; j++) {
						System.out.println(Thread.currentThread().getName() + "is serving " + sequence + " task:" + "loop of " + j);
					}
				}
			});
		}
		/*
		 * 用下面这句代码来说明上面的代码是在提交任务，并且所有的任务都已经提交了，但任务是什么时候执行的，则是由线程池调度的！
		 */
		System.out.println("all task have committed!");
		// 注意与service.shutdownNow()的区别。
		service.shutdown();
		System.out.println("task shutdown!!!!!!!!!!!!!!!!!");
		//service.shutdownNow();
		ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(1);
		scheduledService.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println("bomb!!!");
			}
		}, 2, 2, TimeUnit.SECONDS);
	}
}
