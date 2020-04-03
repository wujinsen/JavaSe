package cn.wjs.javase.dynamicproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author 吴锦森
 * @date 2016年2月13日
 */
public class CGLIBDemo {
	public static void main(String[] args) {
		BookProxy bookProxy = new BookProxy();
		BookFacadeImpl b = (BookFacadeImpl)bookProxy.getInstance(new BookFacadeImpl());
		b.addBook();
	}
}
interface BookFacade{
	public void addBook();
}
class BookFacadeImpl{
	public void addBook(){
		System.out.println("添加图书方法");
	}
}
class BookProxy implements MethodInterceptor{
	private Object target;

	public Object getInstance(Object target){
		this.target = target;

		Enhancer e = new Enhancer();
		e.setSuperclass(this.target.getClass());
		e.setCallback(this);
		//创建代理对象
		return e.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("事物开始");
		proxy.invokeSuper(obj, args);
		System.out.println("事物结束");
		return null;
	}

}
