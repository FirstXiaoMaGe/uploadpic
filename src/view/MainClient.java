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
			System.out.println("��ѡ���������"+"\n"+"1��ע��"+"\n"+"2����¼");
	        System.out.println("*********************");
	        String in=scan.nextLine();
	        int num=0;
	        num=Integer.valueOf(in);
	        if(1==num){
	        	while(true)
	        	{
	        		System.out.println("�������û�����");
		        	String username=scan.next();
		        	System.out.println("����������:");
		        	String passwd1=scan.next();
		        	System.out.println("��ȷ����������:");
		        	String passwd2=scan.next();
		        	if(!passwd1.equals(passwd2))
		        	{
		        		System.out.println("�������벻һ�£�����������");
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
		        			System.out.println("ע��ɹ������¼");
		        			System.out.println("**********************");
		        			num=2;
		        			break;
		        		}else{
		        			System.out.println("ע��ʧ��!");
		        		}
		        		
		        	}
	        	}
	        }
	        if(num==2)
	        {
	        	while(true)
	        	{
	        		System.out.println("�������û���:");
	        		String usernamelogin=scan.next();
	        		System.out.println("����������:");
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
	        			System.out.println("��¼�ɹ�!");
	        			System.out.println("**********************");
	        			num=3;
	        			break;
	        		}else{
	        			System.out.println("��¼ʧ�ܣ��û��������������!");
	        			num=2;
	        		}
	        	}
	        }
	        if(num==3)
	        {
	        		System.out.println("�������ϴ��ļ��ľ���·��:");
	        		String path=scan.next();
	        		System.out.println("������ͼƬ����:");
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
	        			System.out.println("�ϴ��ɹ�!");
	        			break;
	        		}else{
	        			System.out.println("�ϴ�ʧ��!");
	        			break;
	        		}
	        }
		}
	}

}
