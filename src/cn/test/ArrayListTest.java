package cn.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 吴锦森
 * @date 2016年7月20日
 */
public class ArrayListTest {
	public static void main(String[] args) {
		List<Book> all = new ArrayList<Book>();
		all.add(new Book("zhangsan", 10));
		all.add(new Book("lisi", 11));
		all.add(new Book("wangwu", 12));
		System.out.println(all.contains(new Book("zhangsan",10)));
		all.remove(new Book("Oracle",29.8)) ;
		System.out.println(all);

		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("5");
		list1.add("6");

		List<String> list2 = new ArrayList<String>();
		list2.add("2");
		list2.add("3");
		list2.add("7");
		list2.add("8");

		List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList());
		List<String> intersection2 = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
		System.out.println(intersection);
		System.out.println(intersection2);

	}
}
class Book{


	private transient String title;
	private double price;
	public Book(String title, double price){
		this.title = title;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public boolean equals(Object obj){// 对象比较
		if(this==obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(!(obj instanceof Book)){
			return false;
		}
		Book book = (Book)obj;
		if(this.title.equals(book.title) && this.price == book.price) {
			return true;
		}
		return false;
	}
}
