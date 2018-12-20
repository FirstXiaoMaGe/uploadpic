package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.FileModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import util.DBUtil;

public class FileService {
	private Connection conn=null;
	private PreparedStatement ptmt=null;
	private ResultSet rs=null;
	public boolean upload(FileModel file) {
		conn=DBUtil.getConn();
		String sql="insert into tb_file(fname,fcontent) values(?,?)";
		try {
			ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, file.getFname());
			FileInputStream fis=new FileInputStream(file.getFcontent());
			ptmt.setBinaryStream(2, fis,fis.available());
			if(ptmt.execute());	
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
