package com.jamakick.santasWorkshop2.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConnectionManager {
	
	private static final Logger logger = LogManager.getLogger(ConnectionManager.class);

	private static Connection connection;
	
	public static void initialize() {
		try  {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(MyProps.url,
					MyProps.username, MyProps.password);

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if (connection == null)
			initialize();

		return connection;
	}
	
	@Override
	public void finalize() {
		try {
			connection.close();
		} catch(Exception e) {

		}
	}
	
	
	

}
