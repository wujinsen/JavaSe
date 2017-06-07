package cn.wjs.javase.newcharacter;

public class TongPeiFu {
	public static void main(String[] args) {
		Message<String> m = new Message<String>();
		m.setInfo("1");
		print(m);
		Message2<String> m2 = new Message2Impl<String>();//向上转型
		System.out.println(m2.print("aaa"));
	}
	public static void print(Message<? super String> m){
		System.out.println(m.getInfo());
	}
}
class Message<WuJinSen>{//Type
	private WuJinSen info;
	public void setInfo(WuJinSen info){
		this.info =info;
	}
	public WuJinSen getInfo(){
		return info;
	}
}
interface Message2<T>{
	public String print(T msg);
}
class Message2Impl<T> implements Message2<T>{

	@Override
	public String print(T msg) {
		return "" + msg;
	}
}
