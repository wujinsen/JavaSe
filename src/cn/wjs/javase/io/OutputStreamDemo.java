package cn.wjs.javase.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author 吴锦森
 * @date 2016年6月10日
 */
public class OutputStreamDemo {
	public static void main(String[] args) throws Exception{
		// 第一步：设置要操作文件的路径（不管此文件是否存在）
				File file = new File("D:" + File.separator + "mydemo" + File.separator
						+ "hello" + File.separator + "hello.txt");
				if (!file.getParentFile().exists()) { // 父路径不存在
					file.getParentFile().mkdirs(); // 创建目录
				}
				// 第二步：使用子类为父类实例化，使用FileOutputStream实例化OutputStream
				OutputStream output = new FileOutputStream(file) ;
				// 第三步：进行数据的输出操作
				String str = "Hello World ." ;	// 要输出的数据
				byte [] data = str.getBytes() ;	// 字符串变为字节数组
				// public abstract void write(int b) throws IOException
				output.write(data); // 进行内容的输出操作
				// 第四步：关闭输出流
				output.close(); 

	}
}
