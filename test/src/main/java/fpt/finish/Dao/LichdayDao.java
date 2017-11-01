package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.xomtro.DemoWebService.Model.LichdayModel;
import com.xomtro.DemoWebService.config.DBconnection;

public class LichdayDao {
	private Connection connection;
	private DBconnection connectDB;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	public LichdayDao() {
		connectDB=new DBconnection();
	}
	public ArrayList<LichdayModel> findAll(String ma_user)
	{
		connection=connectDB.getConnect();
		String sql="SELECT * FROM `lichday` WHERE `ma_user`=?";
		ArrayList<LichdayModel> dsmh=new ArrayList<>();
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, ma_user);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				LichdayModel mh=new LichdayModel(resultSet.getString("ma_user"), resultSet.getString("malopdl"), resultSet.getString("mamon"), resultSet.getString("lichday"));
				
				dsmh.add(mh);
			}
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
		return dsmh;
	}
	public String check_lichday(String ma_user,String malopdl,String mamon){
		connection=connectDB.getConnect();
		LichdayModel lichdayModel=new LichdayModel();
		String sql="SELECT `lichday` FROM `lichday` WHERE ma_user=? and malopdl=? and mamon=?";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, ma_user);
			preparedStatement.setString(2, malopdl);
			preparedStatement.setString(3, mamon);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				lichdayModel.setLichday(resultSet.getString("lichday"));
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
		
		return lichdayModel.getLichday();
	}
}
