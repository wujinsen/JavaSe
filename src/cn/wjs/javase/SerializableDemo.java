package cn.wjs.javase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author 吴锦森
 * @date 2016年6月10日
 */
public class SerializableDemo {
	public static void main(String[] args) throws Exception {
		Person2 p = new Person2();
		p.setName("zhangsan");
		ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("test"));
		oo.writeObject(p);
		oo.close();
		
		ObjectInputStream oi = new ObjectInputStream(new FileInputStream("test"));
		Person2 p2 = (Person2)oi.readObject();
		System.out.println(p2.getName());
		oi.close();
	}
}

class Person2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}