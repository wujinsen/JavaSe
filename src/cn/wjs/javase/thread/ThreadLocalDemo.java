package cn.wjs.javase.thread;

/**
 * @author 吴锦森
 * @date 2016年1月24日
 */
public class ThreadLocalDemo {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new MyThread(i)).start();
		}
		
	}

	private static final ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return 0;//初始值设为0
		}
	};

	static class MyThread implements Runnable {
		private int index;
		public MyThread(int index){
			this.index = index;
		}
		public void run() {
			int num = 0;
			System.out.println("线程" + index + "的初始value:" + value.get());
			for(int i=0; i<=10; i++){//累加10次
				//value.set(value.get() + i);//生产
				value.set(num+i);
				num+=i;
			//	System.out.println(num);
			}
			System.out.println("线程" + index + "的累加value:" + value.get());//消费
		}
	/*}
	static class MyThread2 implements Runnable{
		private int index;
		public MyThread2(int index){
			this.index = index;
		}
		@Override
		public void run() {
			System.out.println(value.get());
			for(int i=0;i<=10;i++){
				value.set(value.get()+i);
			}
			System.out.println(value.get());
		}
	*/	
	}
}
