package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fpt.finish.bean.User_haui;
import fpt.finish.connection.OracleConnUtils;

public class UserDao  {
	private Connection connection;
	private OracleConnUtils connectDB;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;

	public UserDao() {
		connectDB=new OracleConnUtils();
	}


	public void insert_User(User_haui user)
	{
		
		String sql="INSERT INTO `user_haui`(`ma_user`, `username`, `password`, `tengv`, `email`, `sdt`,`ma_role`) VALUES (?,?,?,?,?,?,?)";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getMa_user());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getTengv());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getSdt());
			//preparedStatement.setInt(7, user.);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public boolean checkLogin(String username, String password){
		//connection=connectDB.getConnect();
		int count=0;
		//UserModel user=new UserModel();
		String sql="SELECT * FROM `user_haui` WHERE username=? and password=?";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{count++;}
			if(count==1){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				connection.close();
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
	}

	

