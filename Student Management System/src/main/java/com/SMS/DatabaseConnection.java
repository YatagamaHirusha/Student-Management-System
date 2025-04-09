package com.SMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection connection;
	
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String username = "root";
	private static final String password = "sqlroot";
	
	private DatabaseConnection() {
		
	}
	
	public static Connection getInstance() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, username, password);
			}
			catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Error connecting to database");
			}
		}
		return connection;
	}
}
