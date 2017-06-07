package cn.wjs;

/**
 * @author 吴锦森
 * @date 2016年7月23日
 *  静态代理
 */
public class StaticProxy {
	public static void main(String[] args) {
		 CountImpl countImpl = new CountImpl();  
		 CountProxy countProxy = new CountProxy(countImpl);
		 countProxy.updateCount();  
	     countProxy.queryCount();
	}
}

/**
 * 定义一个账户接口
 */
interface Count {
	// 查看账户方法
	public void queryCount();

	// 修改账户方法
	public void updateCount();
}

class CountImpl implements Count {

	public void queryCount() {
		System.out.println("查看账户方法...");

	}

	public void updateCount() {
		System.out.println("修改账户方法...");
	}

}

/**
 * 这是一个代理类（增强CountImpl实现类）
 * 
 * @author Administrator
 * 每一个代理类只能为一个接口服务
 */
class CountProxy implements Count {
	private CountImpl countImpl;

	public CountProxy(CountImpl countImpl) {
		this.countImpl = countImpl;
	}

	public void queryCount() {
		System.out.println("事务处理之前");
		// 调用委托类的方法;
		countImpl.queryCount();
		System.out.println("事务处理之后");
	}

	public void updateCount() {
		System.out.println("事务处理之前");
		// 调用委托类的方法;
		countImpl.updateCount();
		System.out.println("事务处理之后");

	}

}