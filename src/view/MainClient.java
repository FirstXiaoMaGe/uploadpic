package view;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import model.FUModel;
import model.FileModel;
import model.UserModel;

public class MainClient {
	private final static String ip="10.129.149.126";
	private final static int port=8888;
	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner scan=new Scanner(System.in);
		OutputStream out =null;
		ObjectOutputStream oos=null;
		InputStream is=null;
		Socket socket=null;
		FUModel fum=null;
		while(true)
		{
			System.out.println("请选择操作类型"+"\n"+"1，注册"+"\n"+"2，登录");
	        System.out.println("*********************");
	        String in=scan.nextLine();
	        int num=0;
	        num=Integer.valueOf(in);
	        if(1==num){
	        	while(true)
	        	{
	        		System.out.println("请输入用户名：");
		        	String username=scan.next();
		        	System.out.println("请输入密码:");
		        	String passwd1=scan.next();
		        	System.out.println("请确认您的密码:");
		        	String passwd2=scan.next();
		        	if(!passwd1.equals(passwd2))
		        	{
		        		System.out.println("两次密码不一致，请重新输入");
		        		System.out.println("********************");
		        	}else{
		        		UserModel pm=new UserModel(0,username,passwd1);
		        	    fum=new FUModel(num,pm);
		        		socket=new Socket(ip,port);
		        		out = socket.getOutputStream(); 
		        		oos=new ObjectOutputStream(out); 
		        		oos.writeObject(fum);
		        		is=socket.getInputStream();
		        		if(is.read()==1)
		        		{
		        			System.out.println("注册成功！请登录");
		        			System.out.println("**********************");
		        			num=2;
		        			break;
		        		}else{
		        			System.out.println("注册失败!");
		        		}
		        		
		        	}
	        	}
	        }
	        if(num==2)
	        {
	        	while(true)
	        	{
	        		System.out.println("请输入用户名:");
	        		String usernamelogin=scan.next();
	        		System.out.println("请输入密码:");
	        		String passlogin=scan.next();
	        		UserModel userlogin=new UserModel(0,usernamelogin,passlogin);
	        		fum=new FUModel(num,userlogin);
	        		socket=new Socket(ip,port);
	        		out = socket.getOutputStream();  
	        		oos=new ObjectOutputStream(out);
	        		oos.writeObject(fum);
	        		is=socket.getInputStream();
	        		if(is.read()==1)
	        		{
	        			System.out.println("登录成功!");
	        			System.out.println("**********************");
	        			num=3;
	        			break;
	        		}else{
	        			System.out.println("登录失败，用户名或者密码错误!");
	        			num=2;
	        		}
	        	}
	        }
	        if(num==3)
	        {
	        		System.out.println("请输入上传文件的绝对路径:");
	        		String path=scan.next();
	        		System.out.println("请输入图片名称:");
	        		String filename=scan.next();
	        		File file=new File(path);
	        		FileModel fm=new FileModel(0, filename, file);
	        		fum=new FUModel(num,fm);
	        		socket=new Socket(ip,port);
	        		out=socket.getOutputStream();
	        		oos=new ObjectOutputStream(out);
	        		oos.writeObject(fum);
	        		is=socket.getInputStream();
	        		if(is.read()==1)
	        		{
	        			System.out.println("上传成功!");
	        			break;
	        		}else{
	        			System.out.println("上传失败!");
	        			break;
	        		}
	        }
		}
	}

}
