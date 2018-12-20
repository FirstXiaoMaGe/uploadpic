package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import model.UserModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import util.DBUtil;

public class UserService {
	private PreparedStatement ptmt=null;
	private ResultSet rs=null;
	private Connection conn=null;
	public boolean register(UserModel user){
		conn=DBUtil.getConn();
		String sql="insert into tb_user(username,passwd) values(?,?)";
		try {
			ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, (user.getUsername()));
			ptmt.setString(2, user.getPasswd());
			if(ptmt.execute());
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean login(UserModel user){
		conn=DBUtil.getConn();
		String sql="select * from tb_user where username=? and passwd=?";
		try {
			ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, user.getUsername());
			ptmt.setString(2, user.getPasswd());
			rs=ptmt.executeQuery();
			if(rs.next())
				return true;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	
	}

}
