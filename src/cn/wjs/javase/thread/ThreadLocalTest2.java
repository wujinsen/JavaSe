package cn.wjs.javase.thread;


/**
 * ThreadLocal 不是用于解决共享变量的问题的，不是为了协调线程同步而存在，
 * 而是为了方便每个线程处理自己的状态而引入的一个机制，理解这点对正确使用ThreadLocal至关重要。
 * @author wjs
 *
 */
public class ThreadLocalTest2 {
	private static final ThreadLocal<Integer> t = new ThreadLocal<Integer>(){
		protected Integer initialValue(){
			return 0;
		}
	};
	
	public static void main(String[] args) {
		Thread[] thread = new Thread[5];

		for(int i=0; i<5; i++){
			thread[i] = new Thread(new Runnable() {
				
				public void run() {
					//获取当前线程的本地变量，然后累加5次
					int num = t.get();
					System.out.println(Thread.currentThread().getName() + " : "+ t.get());
					for(int i=0;i<5;i++){
						num++;
					}
					//重新设置累加后的本地变量
					t.set(num);
					System.out.println(Thread.currentThread().getName() + " : "+ t.get());
				}
			}, "Thread-"+i);
		}
			
		for(Thread thread2 : thread){
			thread2.start();
		}		
	}
}
