package self.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket ss;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public Server(){
		try {
			ss = new ServerSocket(10000);
			while(true){
				socket = ss.accept();
				String remoteIp = socket.getInetAddress().getHostAddress();
				String remotePort = ":"+ socket.getLocalPort();
				
				System.out.println("A client comes in ! IP = "+ remoteIp+remotePort);
				
				//socket 与Client进行交互 
				//socket 获取Client发送过来的数据
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String line = in.readLine();
				System.out.println("client send is " + line);
				
				//out 获取 socket对外输出的方法
				//an output stream for writing bytes to this socket.
				out = new PrintWriter(socket.getOutputStream(),true);
				out.println("Your Message Received!\n test");
				
				out.close();
				in.close();
				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			out.println("server wrong");
			e.printStackTrace();
		}
	}
	public static void main(String []agrs){
		new Server();
	}
}
