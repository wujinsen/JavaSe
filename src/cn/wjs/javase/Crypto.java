//package cn.wjs.javase;
//
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.logging.Logger;
//import org.apache.commons.lang.StringUtils;
//
///**
// * @author 吴锦森 
// * @version 创建时间：2015年5月12日
// * 类说明 
// * <p>Title: 基本加解密相关操作</p>
// */
//public class Crypto {
//	private static final Logger log = Logger.getLogger(Crypto.class);
//	/**
//	 * 计算消息摘要
//	 * 计算结果长度：SHA-1 40byte, MD5 32byte, SHA-256 64byte
//	 * @param strSrc 计算摘要的源字符串
//	 * @param encName 摘要算法: "SHA-1"  "MD5"  "SHA-256", 默认为"SHA-1"
//	 * @return 正确返回摘要值,错误返回null
//	 */
//	public static String GetMessageDigest(String strSrc, String encName) {
//		MessageDigest md = null;
//		String strDes = null;
//		final String ALGO_DEFAULT = "SHA-1";
//		//final String ALGO_MD5 = "MD5";
//		//final String ALGO_SHA256 = "SHA-256";
//
//		byte[] bt = strSrc.getBytes();
//		try {
//			
//			if (StringUtils.isEmpty(encName)) {
//				encName = ALGO_DEFAULT;
//			}
//			md = MessageDigest.getInstance(encName);
//			md.update(bt);
//			strDes = bytes2Hex(md.digest()); //to HexString
//		} catch (NoSuchAlgorithmException e) {
//			return null;
//		}
//		return strDes;
//	}
//
//	/**
//	 * 将字节数组转为HEX字符串(16进制串)
//	 * @param bts 要转换的字节数组
//	 * @return 转换后的HEX串
//	 */
//	public static String bytes2Hex(byte[] bts) {
//		String des = "";
//		String tmp = null;
//		for (int i = 0; i < bts.length; i++) {
//			tmp = (Integer.toHexString(bts[i] & 0xFF));
//			if (tmp.length() == 1) {
//				des += "0";
//			}
//			des += tmp;
//		}
//		return des;
//	}
//	
//	/**
//	 * 对数据进行签名
//	 * @param strSrc
//	 * @return
//	 */
//	public String signData(String strSrc) {
//		return null;
//	}
//
//	/**
//	 * 验证签名
//	 * @param strSign 签名
//	 * @param strSrc  原始数据
//	 * @return Boolean
//	 */
//	public Boolean verfiySign(String strSign, String strSrc) {
//		return null;
//	}
//
//	/**
//	 * 设置加解密配置文件
//	 * @param filePath
//	 */
//	public void setConfig(String filePath) {
//	}
//	
//	/**
//	 * 测试函数
//	 * @param argc
//	 */
//	public static void main(String[] argc) {
//		System.out.println(Crypto.GetMessageDigest("888888", "MD5"));
//		System.out.println(Crypto.GetMessageDigest("888888", ""));
//		System.out.print(Crypto.GetMessageDigest("888888", "SHA-1"));
//	}
//}
