package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xomtro.DemoWebService.Model.LopHocModel;
import com.xomtro.DemoWebService.config.DBconnection;

public class LopHocDao {
	private Connection connection;
	private DBconnection connectDB;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	public LopHocDao() {
	connectDB=new DBconnection();
	}
	public String check_lopOD(String malopdl){
		connection=connectDB.getConnect();
		LopHocModel lophoc=new LopHocModel();
		String sql="SELECT `tenlopondinh` FROM `lophoc` WHERE malopdl=?";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, malopdl);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				lophoc.setTenlopondinh(resultSet.getString("tenlopondinh"));
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
		return lophoc.getTenlopondinh();
	}
}
