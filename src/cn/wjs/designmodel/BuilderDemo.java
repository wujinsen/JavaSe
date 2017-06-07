package cn.wjs.designmodel;

import java.util.ArrayList;
import java.util.List;
/**
 * 工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来进行管理，用来创建复合对象，
 * 所谓复合对象就是指某个类具有不同的属性，其实建造者模式就是前面抽象工厂模式和最后的Test结合起来得到的
 * @author aa
 *
 */
public class BuilderDemo {
	private List<Fruit2> list = new ArrayList<Fruit2>();
	public void produceApple(int count){
		for(int i = 0; i < count; i++){
			list.add(new Apple2());
		}
	}
	public void produceOrange(int count){
		for(int i = 0; i < count; i++){
			list.add(new Orange2());
		}
	}
	public static void main(String[] args) {
		BuilderDemo b = new BuilderDemo();
		b.produceApple(10);
		
	}
}

interface Fruit2 {	// 水果
	public void eat() ;	// 吃
}
class Apple2 implements Fruit2 {
	public void eat() {
		System.out.println("吃苹果。") ;
	}
}
class Orange2 implements Fruit2 {
	public void eat() {
		System.out.println("吃橘子。") ;
	}
}