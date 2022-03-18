//package cn.wjs.javase;
//
///**
// * 先调用静态成员，在调用父类构造方法，在调用本类构造方法
// * @author 吴锦森
// * @date 2015年12月6日
// */
//public class ContructorDemo extends cn.wjs.javase.abstrac.Animal {
//	public static void main(String[] args) {
//		new Dog();//Test the executive order of constructor
//	}
//}
//class Animal{
//	String name;
//	Animal() {
//		System.out.println("class Animal");
//	}
//	Animal(String name){
//		this.name = name;
//		System.out.println(name + "  class Animal");
//		printNumber();
//	}
//
//	public void printNumber(){
//
//	}
//}
//
//class Fish extends cn.wjs.javase.abstrac.Animal {
//	Fish() {
//		System.out.println("class Fish");
//	}
//}
//
//class GoldFish extends Fish {
//	GoldFish() {
//		System.out.println("class GoldFish");
//	}
//}
//
//class Cat {
//	Cat(){
//		System.out.println("class cat");
//	}
//}
//
//class Rabbit {
//	private static int number;
//	private static cn.wjs.javase.abstrac.Cat cat = new cn.wjs.javase.abstrac.Cat();
//	public Rabbit() {
//		number++;
//		System.out.println(number + "class rabbit");
//	}
//}
//
//class Dog extends cn.wjs.javase.abstrac.Animal {
//	public int dogNumber;
//	private GoldFish goldFish = new GoldFish();
//	static  Rabbit blackRabbit = new Rabbit();
//	static  Rabbit whiterabbit = new Rabbit();
//
//	public Dog() {
//		super("Tom");
//		System.out.println("class Dog");
//		dogNumber = 10;
//		System.out.println("The dog's number is:" + dogNumber);
//	}
//
//	public void printNumber(){
//		System.out.println("The dog's number is:" + dogNumber);
//	}
//}
//
////解释：
////
////输出：class cat  是因为Dog类中有静态成员。而静态成员所在的类Rabbit中又有静态成员。所以最先执行它。验证第 一句。
////
////输出：1class rabbit 和 2class rabbit 是执行类Rabbit构造函数。
////
////输出：Tomclass Animal 执行父类的构造函数，因为用super("")。
////
////输出：The dog's number is:0 可以看出子类的dogNumber还是默认值0
////
////输出：class Animal 和 class Fish 和 class GoldFish是构造goldFish引用对象类型。验证第三句。
////
////输出：class Dog  和The dog's number is:10是执行自己的构造函数。
