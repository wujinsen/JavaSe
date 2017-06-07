package cn.wjs.javase;
/**
 * 引用传递
 * @author 吴锦森
 * @date 2015年12月20日
 */
public class YinYongChuanDiDemo {
	
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
//		p1.name = "张三";
//		p1.age = 11;
//		p2.name = "李四";
//		p2.age = 12;
//		p2 = p1;
//		System.out.println(p1.name+p1.age);
//		System.out.println(p2.name+p2.age);
//		p2.name = "王五";
		p1.print();
//		p1.setName("张三");
//		p1.setAge(11);
//		p2.setName("李四");
//		p2.setAge(12);
//		p2 = p1;
//		System.out.println(p1);
//		System.out.println(p2);
		
	}
}
class Person{
	private String name;
	private  int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public void print(){
		System.out.println("name:"+name+",age:"+age);
	}
}
