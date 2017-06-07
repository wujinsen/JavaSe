package cn.wjs.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer{
	public static void main(String[] args) throws Exception{
		
		ServerSocket serverSocket = new ServerSocket(8899);
		Socket socket = serverSocket.accept();//监听，等待客户端连接
		//获取输入流，并读取客户端信息
		InputStream in = socket.getInputStream();
		InputStreamReader inReader = new InputStreamReader(in);
		BufferedReader bufferedReader = new BufferedReader(inReader);
		String info = null;
		while((info = bufferedReader.readLine())!=null){
			System.out.println("hello，我是服务器，客户端在说："+info);
		}
		socket.shutdownInput();
		OutputStream output = socket.getOutputStream();
		PrintWriter printWriter = new PrintWriter(output);
		printWriter.write("客户端你好，这是服务器的回应");
		printWriter.flush();
		
		printWriter.close();
		output.close();
		bufferedReader.close();
		inReader.close();
		in.close();
		socket.close();
		serverSocket.close();
	}

}
