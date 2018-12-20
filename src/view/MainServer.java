package view;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
	public static void main(String[] args) {
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(8888);
			while(true)
			{
				Socket socket=serverSocket.accept();
				ServerThread st=new ServerThread(socket);
				st.start();
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
