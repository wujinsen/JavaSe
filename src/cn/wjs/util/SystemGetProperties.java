package cn.wjs.util;
/**
 * @author 吴锦森 
 * @version 创建时间：2015年5月19日
 * 类说明
 */
public class SystemGetProperties {
//	Key                     Meaning
//
//	——————-     ——————————
//
//	"file.separator"        File separator (e.g., "/")
//
//	"java.class.paths"       Java classpath
//
//	"java.class.version"    Java class version number
//
//	"java.home"             Java installation directory
//
//	"java.vendor"           Java vendor-specific string
//
//	"java.vendor.url"       Java vendor URL
//
//	"java.version"          Java version number
//
//	"line.separator"        Line separator
//
//	"os.arch"               Operating system architecture
//
//	"os.name"               Operating system name
//
//	"path.separator"        Path separator (e.g., ":")
//
//	"user.dir"              User's current working directory
//
//	"user.home"             User home directory
//
//	"user.name"             User account name
	public static void main(String[] args) {
		//System.out.println(System.getProperties());//获取搜索的属性
		System.out.println(System.getProperty("os.name"));//获取属性中key为os.name的值
		System.out.println(System.getProperty("os.arch"));//输出:amd64
		System.out.println(System.getProperty("path.separator")); // 取得分号 ;
		System.out.println(System.getProperty("file.separator"));//取得反斜杠: \
		System.out.println(System.getProperty("line.separator"));//相当于\n
		System.out.println(System.getProperty("user.dir"));	//项目根路径
		System.out.println(System.getProperty("user.home"));//输出:C:\Users\Administrator
		System.out.println(System.getProperty("user.name"));//输出:Administrator
		System.out.println(System.getProperty("java.version"));//java版本号
		System.out.println(System.getProperty("java.home"));	//jre目录
		System.out.println(System.getProperty("java.vendor")); 	//输出:Sun Microsystems Inc.
		System.out.println(System.getProperty("java.vendor.url"));//sun官网
		System.out.println(System.getProperty("java.class.version"));//class版本号
		System.out.println(System.getProperty("java.class.path"));//class路径
		
	}
}
