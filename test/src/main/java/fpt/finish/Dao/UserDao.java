package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fpt.finish.bean.User_haui;
import fpt.finish.connection.OracleConnUtils;

public class UserDao  {
	

	public void insert_User(User_haui user,Connection conn)
	{
		
		String sql="INSERT INTO `user_haui`(`ma_user`, `username`, `password`, `tengv`, `email`, `sdt`,`ma_role`) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getMa_user());
			pstm.setString(2, user.getUserName());
			pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getTengv());
			pstm.setString(5, user.getEmail());
			pstm.setString(6, user.getSdt());
			//preparedStatement.setInt(7, user.);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public boolean checkLogin(String username, String password,Connection conn){
		//connection=connectDB.getConnect();
		int count=0;
		//UserModel user=new UserModel();
		String sql="SELECT * FROM `user_haui` WHERE username=? and password=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {count++;}
			if(count==1){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
		
	}

	public String check_magv(String username, String password,Connection conn) throws SQLException{
	
		
		User_haui user=new User_haui();
		String sql="SELECT * FROM user_haui WHERE username = ? and password = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			ResultSet resultSet = pstm.executeQuery();
			while(resultSet.next())
			{
				user.setMa_user(resultSet.getString("ma_user"));
				
			}
			
		
		String ma_user=user.getMa_user();
		return ma_user;
		
	}

	public String check_tengv(String ma_user_haui, Connection conn) {
		// TODO Auto-generated method stub
		User_haui user=new User_haui();
		String sql="SELECT tengv FROM user_haui WHERE ma_user=?";
		
		PreparedStatement pstm;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, ma_user_haui);
			ResultSet resultSet = pstm.executeQuery();
			while(resultSet.next())
			{
				user.setTengv(resultSet.getString("tengv"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return user.getTengv();
	}
	}

	

