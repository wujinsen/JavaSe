package cn.wjs;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DAOProxy implements InvocationHandler {
	private Object target; // 要代理的对象信息

	public Object bind(Object target) {
		this.target = target; // 需要由系统生成一个指定接口的代理类对象
		// 返回与当前传入对象结构相同的代理类对象
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
		
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		this.log(method.getName());// 取得当前执行的方法名称
		Object retObj = method.invoke(this.target, args);
		//如果是更新则进行事务处理
		if(method.getName().matches("do[a-zA-Z0-9]+")) {
			this.commit();
		}
		return retObj;
	}
	public void log(String methodName){
		System.out.println("进行日志记录,方法是:" +methodName);
	}
	public void commit(){
		System.out.println("事务提交");
	}

}
