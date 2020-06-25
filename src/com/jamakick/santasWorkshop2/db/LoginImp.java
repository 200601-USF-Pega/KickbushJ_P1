package com.jamakick.santasWorkshop2.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jamakick.santasWorkshop2.dao.LoginDAO;
import com.jamakick.santasWorkshop2.object.LoginInfo;

public class LoginImp implements LoginDAO {

	@Override
	public LoginInfo getLoginInfo(Connection connection, int empID) {
		
		LoginInfo info = new LoginInfo();

		
		try {
			PreparedStatement pst = connection.prepareStatement("SELECT * FROM LoginInfo "
					+ "WHERE empID = ?");
			pst.setInt(1, empID);
			pst.executeQuery();
			
			ResultSet rs = pst.getResultSet();			
			
			while (rs.next()) {
				
				info.setEmpID(empID);
				info.setPass(rs.getString("pass"));
				info.setManager(rs.getBoolean("manager"));

			}
		
		return info;
		}
		
		catch (SQLException e) {
			return info;
		
		}

	}
}
