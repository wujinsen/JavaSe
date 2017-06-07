package cn.wjs.jvm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class ReferenceDemo {
	/** * 只有当内存不够的时候，才回收这类内存，因此在内存足够的时候，它们通常不被回收 * *
	* 无论是否发送GC,执行结果都是: * java.lang.Object@f9f9d8 * null * java.lang.Object@f9f9d8 * null *
	* * 可以看到:只有发送了GC,将对于从内存中释放的时候,JVM才会将reference假如引用队列 */ 
	public static void soft() throws Exception {
		Object obj = new Object(); 
		ReferenceQueue refQueue = new ReferenceQueue();
		SoftReference softRef = new SoftReference(obj, refQueue); 
		System.out.println(softRef.get()); // java.lang.Object@f9f9d8 
		System.out.println(refQueue.poll());// null // 清除强引用,触发GC 
		obj = null; System.gc(); 
		System.out.println(softRef.get()); 
		Thread.sleep(200); 
		System.out.println(refQueue.poll()); 
		
	}
}
