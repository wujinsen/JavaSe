package cn.wjs.javase.fanshe;
/**
 * 
 * @author 吴锦森
 * @date 2016年2月11日
    取得全部构造：public Constructor<?>[] getConstructors() throws SecurityException；
    取得指定构造：public Constructor<T> getConstructor(Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException。

 */
public class FanSheDemo {
	public static void main(String[] args) throws Exception{
		Class<?> cls  = Class.forName("cn.wjs.javase.fanshe.User");
		System.out.println(cls.newInstance());
		
	}
}
class User{
	private String name;
	public User(){
		System.out.println("User类的构造方法");
	}
	public String toString(){
		return "User类的toString()方法";
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
