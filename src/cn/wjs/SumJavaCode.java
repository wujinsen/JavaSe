package cn.wjs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Line;

import org.apache.commons.collections.map.StaticBucketMap;
import org.w3c.dom.css.Counter;

/**
 * @author 吴锦森
 * @date 2016年6月10日
 */
public class SumJavaCode {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 final int  i = 0;
		final int  counter = 0;
		
		String path = "d:\\Hello.java";
		List<File> list = total(path);
		System.out.println("文件数量：" + list.size());

		// 统计代码行数
		Integer row = 0;

		for (File file : list) {
			System.out.println(file.getName());
			FileReader fr = new FileReader(file);// 创建文件输入流
			BufferedReader in = new BufferedReader(fr);// 包装文件输入流，可整行读取
			String line = "";
			while ((line = in.readLine()) != null) {
				row++;
			}
		}

		System.out.println("代码行数：" + row);
	}

	public static List<File> total(String path) {
		List<File> files = new ArrayList<File>();
		File file = new File(path);
		File[] files2 = file.listFiles();
		for (File file3 : files2) {
			if (file3.isFile()) {
				files.add(file3);
			} else {
				files.addAll(files.size(), total(file3.getPath()));
			}
		}
		return files;
	}
}
