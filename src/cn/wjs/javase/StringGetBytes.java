package cn.wjs.javase;
/**
 * @author 吴锦森 
 * @version 创建时间：2015年5月12日
 * 类说明
 */
public class StringGetBytes {
	public static void main(String[] args) throws Exception{
		String str = new String("时之沙");
		byte bytes[] = str.getBytes("GBK");
		byte byte2[] = str.getBytes("ISO-8859-1");
		String str_gbk = new String(bytes, "GBK");
		System.out.println("str_gbk:" + str_gbk);
		String str_utf8 = new String(bytes, "UTF-8");
		System.out.println("str_utf8:" + str_utf8);
		String str_iso8859 = new String(bytes, "ISO-8859-1");
		System.out.println("str_iso8859" + str_iso8859);
		String byte2_gbk = new String(byte2, "GBK");
		System.out.println("byte2_gbk:" + byte2_gbk);
	}
}
