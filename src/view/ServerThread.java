package view;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

import dao.FileService;
import dao.UserService;
import model.FUModel;
import model.FileModel;
import model.UserModel;

public class ServerThread extends Thread {
	Socket socket=null;
	UserService userService=new UserService();
	FileService fileService=new FileService();
	OutputStream os=null;
	
	public ServerThread(Socket socket){
		this.socket=socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			InputStream is=socket.getInputStream();
			ObjectInputStream ois=new ObjectInputStream(is);
			FUModel oo=(FUModel) ois.readObject();
			switch(oo.getFlag())
			{
				case 1:
					register((UserModel)oo.getOo());
					break;
				case 2:
					login((UserModel)oo.getOo());
					break;
				case 3:
					upload((FileModel)oo.getOo());
					break;
					
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void register(UserModel user){
			boolean flag=userService.register(user);
			try {
				os=socket.getOutputStream();
				if(flag==true)
				{
					os.write(1);
				}
				else os.write(0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private void login(UserModel user){
		boolean flag=userService.login(user);
		try {
			os=socket.getOutputStream();
			if(flag==true)
				os.write(1);
			else os.write(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void upload(FileModel fm){
		boolean flag=fileService.upload(fm);
		try {
			os=socket.getOutputStream();
			if(flag==true)
			{
				os.write(1);
			}
			else os.write(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
