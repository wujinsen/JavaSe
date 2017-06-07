package cn.wjs.javase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;


/**
 * @author 吴锦森
 * @date 2016年2月10日 取得类的实例化对象的三种方式: 利用Object类之中继承而来的getClass()方法； 利用“类.class”形式； 利用Class类之中的forName()方法。
   
   	//findClass方法接收一个字符串，而后返回一个Class类对象。
   	protected Class<?> findClass(String name) throws ClassNotFoundException
	
	protected final Class<?> defineClass(String name, byte[] b,int off, int len) throws ClassFormatError

 */
public class ClassLoaderDemo {
	public static void main(String[] args) throws Exception{
		//ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
		//Class<?> cls = new MyLoader().findClass("java.util.Date");
		//sSystem.out.println(cls.newInstance());
		//---------取得父类的加载器--------------
		ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
		while(loader != null) {
			System.out.println(loader);
			loader = loader.getParent() ;	// 取得父加载器
		}
		//--------------
		Class<?> cls2 = new MyLoader().findClass("cn.wjs.Hello") ;//装载的包.类名
		System.out.println(cls2.newInstance());
		Object obj = cls2.newInstance();
		Method m = cls2.getMethod("fun");//类有个方法fun()
		System.out.println(m.invoke(obj));
		//System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cls2.newInstance()));
		//----------------
		
	}
}

class MyLoader extends ClassLoader {//继承ClassLoader
	//findClass 要加载的包.类名
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		//return super.loadClass(name);
		try {
			byte data [] = this.loadData(name) ;	// 字节数据
			return super.defineClass(name, data, 0, data.length) ;
		} catch (Exception e) {
		}
		return null ;
	}
	public byte[] loadData(String name) throws Exception { // 读取文件的内容
		StringBuffer filePath = new StringBuffer();
		filePath.append("D:").append(File.separator);// D:\
		String result[] = name.split("\\.");
		for (int x = 0; x < result.length; x++) {
			filePath.append(result[x]).append(File.separator);
		}
		filePath.delete(filePath.length() - 1, filePath.length()).append(".class");
		System.out.println(filePath);
		//---------------
		URL url = new URL("http://localhost/"+filePath);
		URLConnection urlCollection = url.openConnection();
		//byte data[] = new byte[1024];
		//InputStream input = urlCollection.getInputStream() ;
		//ByteArrayOutputStream bos = new ByteArrayOutputStream() ;	// 内存输出流

		//--------------------
		byte data[] = new byte[1024];
		InputStream input = new FileInputStream(new File(filePath.toString()));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();	// 内存输出流
		int len = 0 ;
		while ((len = input.read(data)) != -1) {
			bos.write(data, 0, len);
		}
		byte retData [] = bos.toByteArray() ;
		input.close() ;
		bos.close();
		return retData;
	}
	
}

