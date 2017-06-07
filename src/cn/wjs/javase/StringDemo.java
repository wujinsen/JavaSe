package cn.wjs.javase;

/**
 * @author 吴锦森
 * @date 2015年11月28日
 */
public class StringDemo {
	public static void main(String[] args) {
		//-----------Start-------字符串与字符
		//public String(Char[] value) 字符数组转换为字符串
		String str = "HelloWorld";
		char c = str.charAt(7);//取得索引为7的字符
		System.out.println(c);
		String str2 = "HelloWorld";
		char data[] = str2.toCharArray();//字符串转换为字符数组
		for(int i=0;i<data.length;i++){
			System.out.print(data[i] + ",");
			data[i] -= 32;	//变大写
		}
		System.out.println("全部字符数组变为字符串:"+new String(data));
		System.out.println("部分字符数组变为字符串"+new String(data,0,5));
		//-----------End-------字符串与字符
		//-----------Start-------字符串与字节
		String str3 = "HelloWorld";
		byte data3[] = str3.getBytes();//字符串转换为字节数组
		for(int i : data3){
				System.out.print(i+",");
				//i -=32;//变为大写字母
		}
		System.out.println("data3's length:"+data3.length);
		for(int i=0; i<data3.length;i++){
			System.out.print(data3[i]+",");
		}
		System.out.println();
		//-----------End-------字符串与字符
		//-----------Start-----字符串查找
		
		String str4 = "HelloWorld";
		System.out.println(str4.contains("or"));//JDK1.5推出 contains 找到返回true,否则false
		System.out.println(str4.startsWith("ello"));//JDK1.7推出 startsWith判断是否以指定的字符串开头
		System.out.println(str4.startsWith("lloW", 3));
		System.out.println(str4.indexOf("l",4));//较老的 indexof 从指定索引查找，找不到返回-1
		System.out.println(str4.lastIndexOf("l"));
		System.out.println(str4.substring(1, 4));
		//-----------End-----字符串查找
		
	}
}
