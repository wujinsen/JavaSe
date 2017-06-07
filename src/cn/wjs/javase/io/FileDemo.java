package cn.wjs.javase.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;




/**
 * @author 吴锦森 
 * @version 创建时间：2015年6月15日
 * 类说明
 */
public class FileDemo {
	public static void main(String[] args) throws Exception{
		File f = new File("d:" + File.separator + "xxxxx.txt");
		PrintStream p = new PrintStream(new FileOutputStream(f));
		p.print("aaa");
	}
}
