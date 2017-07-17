package cn.wjs.arithmetic;

/**
 * @author 吴锦森
 * @date 2016年7月23日
 */
public class test {
	public static void main(String[] args) {//testaa
		fun(new B());//利用向上转型
		fun(new C());
	}
	public static void fun(A a){
		a.print();
	}
	public static void fun(B b){
		b.print();
	}
	public static void fun(C c){
		c.print();
	}
}

class A{
	public void print(){
		System.out.println("A");
	}
}
class B extends A{
	public void print(){
		System.out.println("B");
	}
}
class C extends A{
	public void print(){
		System.out.println("C");
	}
}
