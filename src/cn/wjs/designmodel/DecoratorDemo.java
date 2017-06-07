package cn.wjs.designmodel;
/**
 * 装饰模式就是给一个对象增加一些新的功能，而且是动态的，
 * 要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例
 * @author aa
 *
 */
public class DecoratorDemo {
	public static void main(String[] args) {
		Component c = new Decorator(new ConcreteDecorator());//向上转型
		c.print();
	}
}
//接口
interface Component {
	public void print();
}
//被装饰类
class ConcreteDecorator implements Component {
	public void print() {
		System.out.println("原始方法");
	}
}
//装饰类,可以为ConcreteDecorator类动态的添加一些功能
class Decorator implements Component {
	private Component c;

	public Decorator(Component c) {
		super();
		this.c = c;
	}
	public void print() {
		System.out.println("装饰前");
		c.print();
		System.out.println("装饰后");
	}
}
