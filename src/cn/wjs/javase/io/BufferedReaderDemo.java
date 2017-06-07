package cn.wjs.javase.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author 吴锦森 
 * @version 创建时间：2015年6月15日
 * 类说明
 */
public class BufferedReaderDemo {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("d:" + File.separator + "test.txt")));
		String str = reader.readLine();
		System.out.println(str);
		
	}
}
