package cn.wjs.javase.thread;

/**
 * @author 吴锦森
 * @date 2016年1月25日
 * 线程有数据错乱和重复设置取出问题,
 */
public class JingDianDemo {
	public static void main(String[] args) {
//		MyThread m1 = new MyThread();
//		Thread t1 = new Thread(new MyThread());
//		Thread t2 = new Thread(new MyThread());
//		Thread t3 = new Thread(new MyThread());
//		t1.start();
//		t2.start();
//		t3.start();
		Message msg = new Message();
		new Thread(new Producer(msg)).start();
		new Thread(new Consumer(msg)).start();
	}
}
class MyThread implements Runnable{
	private int ticket = 6;
	public void run(){
		for(int i=0;i<10;i++){
			this.sale();
		}
	}
	public  void sale(){
		if(this.ticket > 0){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("线程名称:" + Thread.currentThread().getName() + " 票数:" +this.ticket--);
		}
	}
}
class Message{
	private String title;
	private String content;
	private boolean flag = true;//true表示可以生产，但不能取走，false相反
	public synchronized void set(String title, String content){
		if(flag == false){//已经生产过了，不能生产
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.title = title;//设置内容
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.content = content;
		this.flag = false;	//生产完成，修改标记
		super.notify();
	}
	public synchronized void get(){
		if(flag == true){
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.getTitle()+"-->"+this.getContent());
		this.flag = true;//已经取走，改变标记，可以生产
		super.notify();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
class Producer implements Runnable{//生产者线程
	private Message msg = null;
	public Producer(Message msg){
		this.msg = msg;
	}
	public void run(){
		for(int i=0;i<10;i++){
			if(i % 2 == 0){
				this.msg.set("张三是男的", "男");
			}else{
				this.msg.set("李四是女的", "女");
			}
		}
	}
}
class Consumer implements Runnable{//消费者线程
	private Message msg =  null;
	public Consumer(Message msg){
		this.msg = msg;
	}
	public void run() {
		for(int i=0;i<10;i++){
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(this.msg.getTitle()+"-->"+this.msg.getContent());
			this.msg.get();
		}
	}
}