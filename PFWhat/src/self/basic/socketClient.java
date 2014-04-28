package self.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class socketClient {
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	public socketClient(){
		System.out.println("try to connect to 127.0.0.1:10000");
		try {
			socket = new Socket("127.0.0.1",10000);
			System.out.println("Server is connected");
			System.out.println("Please enter some words");
			//line 获得终端输入的数据 
			BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
			
			//获取socket 对外通道，也就是输出到Server的的
			out = new PrintWriter(socket.getOutputStream(),true);
			out.println(line.readLine());
			
			//in 接受从 Server发送过来的数据
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			System.out.println(in.readLine());
			out.close();
			in.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String []args){
		new socketClient();
	}
}
