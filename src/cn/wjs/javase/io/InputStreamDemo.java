package cn.wjs.javase.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamDemo {
	public static void main(String[] args) throws Exception {
		// 第一步：设置要操作文件的路径（不管此文件是否存在）
		File file = new File("D:" + File.separator + "mydemo" + File.separator + "hello" + File.separator + "hello.txt");
		if (file.exists()) { // 文件要存在才可以读取
			// 第二步：使用子类为父类实例化，使用FileInputStream实例化InputStream
			InputStream input = new FileInputStream(file);
			// 第三步：进行数据的输出操作
			byte data[] = new byte[1024]; // 定义一个水杯
			int foot = 0; // 操作字节数组的脚标
			int temp = 0;
			// 第一步：读取单个字节，temp = input.read()；
			// 第二步：判断读取的内容是否是-1，(temp = input.read()) != -1
			while ((temp = input.read()) != -1) {
				data[foot++] = (byte) temp; // 向数组之中保存
			}
			// 第四步：关闭输出流
			input.close();
			System.out.println("读取的内容：〖" + new String(data, 0, foot) + "〗");
		}
	}

}
