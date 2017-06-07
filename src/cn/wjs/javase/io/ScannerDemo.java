package cn.wjs.javase.io;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;


/**
 * @author 吴锦森 
 * @version 创建时间：2015年6月15日
 * 类说明 InputStream读取数据小的数据还方便些，如果数据很多，怎么读？但是如果有了Scanner这一切变得很容易。
 */
public class ScannerDemo {
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(new FileInputStream("d:" + File.separator + "test2.txt"));
		while(s.hasNext()){
			System.out.println(s.next());
		}
	}
}
