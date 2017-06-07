package cn.wjs.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author 吴锦森
 * @version 创建时间：2015年5月19日 类说明
 */
public class FileUtils {
	/**
	 * 拷贝文件
	 * 
	 * @param src
	 *            源文件
	 * @param dest
	 *            目标文件
	 * @param bufferSize
	 *            每次读取的字节数
	 * @throws IOException
	 */
	public static void copyFile(String src, String dest, int bufferSize) throws IOException {

		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dest);
		byte[] buffer = new byte[bufferSize];
		int length;

		while ((length = fis.read(buffer)) != -1) {
			fos.write(buffer, 0, length);
		}
		fis.close();
		fos.close();
	}
	/**
	 * 删除文件
	 * @param src 源文件
	 */
	public static void deleteFile(String src){
		new File(src).delete();
	}
	/**
	 * 删除多个文件
	 * @param src
	 */
	public static void deleteFiles(String... src){
		for(String s : src){
			FileUtils.deleteFile(s);
		}
	}
	/**
	 * 根据路径删除文件
	 * @param dir
	 * @throws Exception
	 */
	public static void deleteByDir(String dir) throws Exception{
		File d = new File(dir);
		if(!d.isDirectory())
			throw new Exception("\"" + dir + "\"" + "不是一个目录");
		String[] fileNameArray = d.list();
		FileUtils.deleteFiles(fileNameArray);
	}
	/**
	 * 将内容写入文件
	 * @param content  写入的内容
	 * @param dest  写入的文件
	 * @param append  是否追加
	 * @param newLine  是否换行
	 * @throws IOException
	 */
	public static void writeToFile(String content, String dest, boolean append, boolean newLine) throws IOException {
		FileWriter writer = new FileWriter(dest, append);
		//line.separator相当于\n
		writer.write(content + (newLine == true ? System.getProperty("line.separator") : "") );
		writer.close();
	}
//	public static String[] readContent(String src, Charset charset) throws Exception{
//		FileReader reader = new FileReader(src);
//		BufferedReader bReader = new BufferedReader(reader);
//		String[] array = new String[FileUtils.read];
//		return "";
//	}
	
}
