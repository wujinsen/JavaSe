package cn.test;

import java.util.ArrayList;
import java.util.List;

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
