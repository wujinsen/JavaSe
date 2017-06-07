package cn.wjs.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
	public static void main(String[] args) throws Exception{
	//创建客户端Socket，指定服务器地址和端口
		Socket socket = new Socket("127.0.0.1", 8899);
	//	获取输出流，向服务器端发送信息
		OutputStream output = socket.getOutputStream();
		PrintWriter printWriter = new PrintWriter(output);
		printWriter.write("用户名：admin；密码：admin");
		printWriter.flush();
		socket.shutdownOutput();
	//	获取输入流，并读取服务器端的响应信息
		InputStream in = socket.getInputStream();
		InputStreamReader inReader = new InputStreamReader(in);
		BufferedReader bufferedReader = new BufferedReader(inReader);
		String info = null;
		while((info=bufferedReader.readLine())!=null){
		 System.out.println("Hello,我是客户端，服务器说："+info);
		}
		printWriter.close();
		output.close();
		bufferedReader.close();
		inReader.close();
		in.close();
		socket.close();
		socket.close();
	}
}
