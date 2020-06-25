package com.jamakick.santasWorkshop2.dao;

import java.sql.Connection;

import com.jamakick.santasWorkshop2.object.LoginInfo;

public interface LoginDAO {
	
	public LoginInfo getLoginInfo(Connection connection, int empID);

}
