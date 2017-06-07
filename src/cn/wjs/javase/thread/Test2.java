package cn.wjs.javase.thread;



/**
 * @author 吴锦森
 * @date 2016年5月2日
 */
public class Test2 {
	public static void main(String[] args) {
		for(int i=0; i<1000; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Counter.inc();
				}
			}).start();
		}
		System.out.println("运行结果:" + Counter.count);
	}
}
class Counter{
	public static int count = 0;
	public static void inc(){
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count++;
	}

}
