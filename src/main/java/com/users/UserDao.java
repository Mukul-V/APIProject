package com.users;

import java.sql.*;

import Models.Helper;
import Models.User;

public class UserDao implements Helper{
	
	static DBConnection db=new DBConnection();
	
	public User signIn(String username, String password) throws ClassNotFoundException, SQLException {
		Connection conn=db.createConnection();
		String fetchUser=GetUser;
		User user=null;
		try {
			
			PreparedStatement st=conn.prepareStatement(fetchUser);
			st.setString(1,username);
			st.setString(2,password);
			ResultSet rs=st.executeQuery();			
			
			if(rs.next()) {
				user=new User(rs.getString(Name), rs.getString(Username), rs.getString(Password), rs.getString(Color));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return user;
	}
	
	public boolean signUp(User user) throws SQLException, ClassNotFoundException {
		Connection conn=db.createConnection();
		String insertUser=SignUpStatement;
		boolean result=false;
		try {
			
			PreparedStatement st=conn.prepareStatement(insertUser);
			st.setString(1, user.name);
			st.setString(2, user.username);
			st.setString(3, user.password);
			st.setString(4, user.color);
			int rs=st.executeUpdate();
			
			conn.close();
			if(rs>0) {
				result= true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return result;
	}
	

}
