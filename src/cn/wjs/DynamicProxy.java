package cn.wjs;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 吴锦森
 * @date 2016年7月24日
 * JDK动态代理中包含一个类和一个接口：
 *  InvocationHandler接口
 *  Proxy类
 */
public class DynamicProxy {
	public static void main(String[] args) {
		BookFacadeProxy proxy = new BookFacadeProxy();
		BookFacade bf = (BookFacade) proxy.bind(new BookFacadeImpl());// 这里用到了向上转型
		bf.addBook();
	}
}

interface BookFacade {
	public void addBook();
}

class BookFacadeImpl implements BookFacade {//JDK的动态代理机制只能代理实现了接口的类

	@Override
	public void addBook() {
		System.out.println("增加图书方法。。。");
	}

}

/**
 * JDK动态代理代理类
 * 
 */
class BookFacadeProxy implements InvocationHandler {
	private Object target;// 绑定委托对象

	/**
	 * 自定义方法 绑定委托对象并返回一个代理类
	 * 
	 * @param target
	 * @param target
	 * @return
	 */
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("事务开始");
		result = method.invoke(target, args);//反射调用
		System.out.println("事务结束");
		return result;

	}
}