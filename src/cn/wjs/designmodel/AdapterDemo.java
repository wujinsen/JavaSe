package cn.wjs.designmodel;
/**
 * 适配器模式将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容性问题。
 * 主要分为三类：类的适配器模式、对象的适配器模式、接口的适配器模式。
 * @author aa
 *核心思想就是：有一个Source类，拥有一个方法，待适配，目标接口时Targetable，通过Adapter类，将Source的功能扩展到Targetable里
 *包装另一个对象，并提供不同的接口
 */
public class AdapterDemo {
	public static void main(String[] args) {
		Targetable t = new Adapter();
		t.method1();
		t.method2();
	}
}
interface Targetable{
	//与原类中的方法相同
	public void method1();
	//新类的方法
	public void method2();
}

class Source{
	public void method1(){
		System.out.println("this is original method!");
	}
}
class Adapter extends Source implements  Targetable{

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("this is the targetable method!");
	}
	
}