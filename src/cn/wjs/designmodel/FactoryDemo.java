package cn.wjs.designmodel;
/**
 * 
 * @author aa
 * 
 */
public class FactoryDemo {
	public static void main(String[] args) {
		//如果字符串传递出错，则无法创建实例
		Fruit f = Factory.getInstance("apple") ;//返回对应的对象
		f.eat() ;
		
	}
}
interface Fruit {	// 水果
	public void eat() ;	// 吃
}
class Apple implements Fruit {
	public void eat() {
		System.out.println("吃苹果。") ;
	}
}
class Orange implements Fruit {
	public void eat() {
		System.out.println("吃橘子。") ;
	}
}
class Factory {
	public static Fruit getInstance(String className) {
		if ("apple".equals(className)) {
			return new Apple() ;
		}
		if ("orange".equals(className)) {
			return new Orange() ;
		}
		return null ;
	}
}
