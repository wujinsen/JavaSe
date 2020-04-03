package cn.wjs.javase.dynamicproxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;



/**
 * @author 吴锦森
 * @date 2016年2月13日
 *  利用Object类之中继承而来的getClass()方法；
	利用“类.class”形式；
	利用Class类之中的forName()方法。

 */

public class InvocationHandlerDemo {//Invocation祈祷，符咒
	public static void main(String[] args) {
		Network net = new RealNetwork();
		MyHandler m = new MyHandler();
		net = (Network)m.bind(net);//new RealNetwork();
		net.doCreate();
		//Network n2 = (Network) m.bind(net);
		//n2.doCreate();

//		MyHandler m2 = new MyHandler();//代理类
//		Network n = (Network)m2.bind(new RealNetwork());
//		n.doCreate();
	}
}
 class MyHandler implements InvocationHandler {
	 private Object target;// 要保存的真实主体对象
	 public Object bind(Object target){
		 this.target = target;
		 //System.out.println("target.getClass().getClassLoader():"+target.getClass().getClassLoader());
		// System.out.println("target.getClass().getInterfaces():"+target.getClass().getInterfaces());
		 return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	 }


	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy : " + proxy.getClass());
		System.out.println("method : " + method.getName());
		System.out.println("args : " + Arrays.toString(args));
		if(method.getName().matches("do[a-zA-Z0-9]*")) {
			this.interceptor();	// 进行操作拦截
		}

		// TODO Auto-generated method stub
		return method.invoke(target, args);
		//return null;
	}
	public void interceptor() {
		System.out.println("***** 进行数据的拦截操作 *****");
	}
	public void handle() {
		System.out.println("***** 进行问题的处理 *****");
	}

}
 interface Network {
		public abstract void set(String name) ;
		public abstract void use() ;
		public void doCreate() ;
	}
 class RealNetwork implements Network {//实现了Network接口。如果一个类没有实现接口，则不能用JDK动态代理，改用CGLIB代理
		@Override
		public void use() {
			System.out.println("上网，看各种东西！");
		}
		@Override
		public void set(String name) {
			System.out.println("set() , name = " + name);
		}
		@Override
		public void doCreate() {
			System.out.println("增加数据。");
		}
	}

