package cn.wjs;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author 吴锦森
 * @date 2016年7月24日
 * cglib动态代理
 * cglib是针对类来实现代理的，他的原理是对指定的目标类生成一个子类，
 * 并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进行代理
 */
public class CglibDemo {
	public static void main(String[] args) {
		BookFacadeCglib b = new BookFacadeCglib();
		BookFacadeImpl1 bf = (BookFacadeImpl1) b.getInstance(new BookFacadeImpl1());
		bf.addBook();
	}
}
 interface BookFacade1 {
    public void addBook();
}
 /**
  * 这个是没有实现接口的实现类
  *
  */
 class BookFacadeImpl1 {  //这个是没有实现接口的实现类
	   public void addBook() {
	       System.out.println("增加图书的普通方法...");
	}
}
class BookFacadeCglib implements MethodInterceptor {

	private Object target;
	/**
	 * 创建代理对象
	 * @param target
	 * @return
	 */
	 public Object getInstance(Object target) {
		 this.target = target;
		 Enhancer enhancer = new Enhancer();
		   enhancer.setSuperclass(this.target.getClass());
	        // 回调方法
	        enhancer.setCallback(this);
	        // 创建代理对象
	        return enhancer.create();
	 }
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("事务开始");
		proxy.invokeSuper(obj, args);
		System.out.println("事务结束");
		return null;
	}

}
