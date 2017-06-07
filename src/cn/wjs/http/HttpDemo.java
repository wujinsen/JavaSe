package cn.wjs.http;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * @author 吴锦森
 * @version 创建时间：2015年5月12日 类说明
 */
public class HttpDemo {
	public static void main(String[] args) throws Exception{
		HttpClient httpClient = new HttpClient();
		// 设置代理服务器地址和端口
		// client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
		// 使用 GET 方法 ，如果服务器需要通过 HTTPS 连接，那只需要将下面 URL 中的 http 换成 https
		HttpMethod httpMethod = new GetMethod("http://java.sun.com");
		
		// 使用POST方法
		// HttpMethod method = new PostMethod("http://java.sun.com");
		
		httpClient.executeMethod(httpMethod);//发送请求
		System.out.println("status:" + httpClient.executeMethod(httpMethod));//正确返回200
		//打印服务器返回的状态
		System.out.println("打印服务器返回的状态");
		System.out.println(httpMethod.getStatusLine());
		//打印返回的信息
		System.out.println("打印返回的信息");
		System.out.println(httpMethod.getResponseBodyAsString());
		System.out.println("查询结算记录返回数据："+ httpMethod.getResponseBody());
		//释放连接
		httpMethod.releaseConnection();
		
	}
}
