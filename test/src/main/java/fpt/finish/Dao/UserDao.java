package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



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
	public ArrayList<User_haui> findAll(Connection conn){
		
		ArrayList<User_haui> list=new ArrayList<>();
		String sql="SELECT `ma_user`,`username`, `tengv`, `email`, `sdt` FROM `user_haui`";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet resultSet = pstm.executeQuery();
			while(resultSet.next()){
				User_haui user=new User_haui();
				user.setMa_user(resultSet.getString("ma_user"));
				user.setUserName(resultSet.getString("username"));
				user.setTengv(resultSet.getString("tengv"));
				user.setEmail(resultSet.getString("email"));
				user.setSdt(resultSet.getString("sdt"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void insert_tk(String ma_user,String username, String password,Connection conn)
	{
		
		String sql="INSERT INTO `user_haui`(`ma_user`, `username`, `password`,`ma_role`) VALUES (?,?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, ma_user);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, password);
			preparedStatement.setInt(4, 2);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void UpdateUsertheoMa(User_haui user,Connection conn){
	
		String sql="UPDATE `user_haui` SET `tengv`=?,`email`=?,`sdt`=? WHERE ma_user=?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, user.getTengv());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getSdt());
			preparedStatement.setString(4, user.getMa_user());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public User_haui check_thongtin(String ma_user,Connection conn){
		
		User_haui user=null;
		String sql="SELECT `tengv`, `email`, `sdt` FROM `user_haui` Where `ma_user`=?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, ma_user);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				 user=new User_haui();
				user.setTengv(resultSet.getString("tengv"));
				user.setEmail(resultSet.getString("email"));
				user.setSdt(resultSet.getString("sdt"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}
	public void DeleteUser(String ma_user,Connection conn){
	
		String sql="DELETE FROM `user_haui` WHERE ma_user=?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, ma_user);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public String check_username(String ma_user,Connection conn){
		
		
		String username="";
		String sql="SELECT `username` FROM `user_haui` WHERE ma_user=?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, ma_user);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				username=resultSet.getString("username");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return username;
		
	}
	public void ChangPass(String username,String pass,Connection conn){
		
		String sql="UPDATE `user_haui` SET `password`=? WHERE `username`=?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, pass);
			preparedStatement.setString(2, username);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	}

	

