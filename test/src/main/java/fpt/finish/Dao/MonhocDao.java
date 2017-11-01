package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.xomtro.DemoWebService.Model.Monhocmodel;
import com.xomtro.DemoWebService.Model.PhongmayModel;
import com.xomtro.DemoWebService.Model.UserModel;
import com.xomtro.DemoWebService.config.DBconnection;
import com.xomtro.DemoWebService.service.MonhocService;

public class MonhocDao implements MonhocService{
	private Connection connection;
	private DBconnection connectDB;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	public MonhocDao() {
		connectDB=new DBconnection();
	}
	@Override
	public String check_tenmon(String mamon){
		connection=connectDB.getConnect();
		
		Monhocmodel monhoc=new Monhocmodel();
		String sql="SELECT `tenmon` FROM `monhoc` WHERE `mamon`=?";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, mamon);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				monhoc.setTenmon(resultSet.getString("tenmon"));
				
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
		String tenmon=monhoc.getTenmon();
		return tenmon;
		
	}
	public String check_mamon(String tenmon){
		connection=connectDB.getConnect();
		Monhocmodel monhoc=new Monhocmodel();
		String sql="SELECT `mamon` FROM `monhoc` WHERE `tenmon`=?";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, tenmon);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				monhoc.setMamon(resultSet.getString("mamon"));
				
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
		String mamon=monhoc.getMamon();
		return mamon;
		
	}
}
