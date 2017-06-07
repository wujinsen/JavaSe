package cn.wjs.javase;

/**
 * 
 * @author wjs
 *
 */
public class DateDemo {
	public static void main(String[] args) {
		java.util.Date uDate = new java.util.Date();// 该时间格式包含日期以及时间
		System.out.println("java.util.Date时间：" + uDate);
		// util.Date转换为sql.Date
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());// 该时间格式只包含日期
		System.out.println("java.sql.Date时间：" + sDate);
	}
}
