package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;



public class DBUtil {
	private static final String  URL="jdbc:mysql://127.0.0.1:3306/uploadpic";
	private static final String USER="root";
	private static final String PASS="1234";
	private static Connection conn=null;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(URL,USER,PASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConn(){
		return conn;
	}
	
	public static void closeAll(ResultSet rs,Statement ptmt,Connection conn){
		if(rs!=null)
			try {
				rs.close();
				if(ptmt!=null)
					ptmt.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static FileInputStream getBytes(String file) throws FileNotFoundException
	{
		FileInputStream pic=new FileInputStream(file);
		return pic;
	}
}
