package cn.wjs.javase.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 吴锦森
 * @date 2016年3月2日
 */
public class FutureTest {
	public static void main(String[] args) {

		ExecutorService service = Executors.newSingleThreadExecutor();//只有一个线程的线程池，因此所有提交的任务是顺序执行
		class MyCallable implements Callable<String> {

			public String call() throws Exception {
				for (int i = 0; i < 10; i++) {
					Thread.sleep(1000);
					System.out.println("calling " + i);
				}

				return "hello";
			}

		}
		// Future<String> future = service.submit(new MyCallable());
		class MyCallable2<T> implements Callable<T> {

			public T call() throws Exception {
				for (int i = 0; i < 10; i++) {
					Thread.sleep(1000);
					System.out.println("calling " + i);
				}
				return null;
			}
		}

		Future<String> future = service.submit(new Callable<String>() {
			public String call() throws Exception {
				for (int i = 0; i < 10; i++) {
					Thread.sleep(1000);
					System.out.println("calling " + i);
				}
				return "hello";
			}

		});

		try {
			// 加上下面这句则暂停失败，还能看到上面打印的calling。
			// Thread.sleep(2000);
			future.cancel(false);
			System.out.println(future.isCancelled());
			if (false)
				System.out.println(future.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end!");
		service.shutdown();

	}
	//-----------------用了随机值的CompletionService------------------
//	CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(service);
//	for(int i=0;i<10;i++){
//	final Integer seq = i+1;
//	completionService.submit(new Callable<Integer>(){
//
//	public Integer call() throws Exception {
//	try{
//	Thread.sleep((long)(Math.random() * 1000));}catch(Exception e){}
//	return seq;
//	}
//
//	});
//	}
//
//	for(int i=0;i<10;i++){
//	Future<Integer> f = completionService.take();
//	System.out.println(f.get());
//	}

}

