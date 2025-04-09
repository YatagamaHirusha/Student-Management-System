package com.SMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class  StudentDAO{
	Connection connection = DatabaseConnection.getInstance();
	
	private void registerStudent(String nic, String name, String email, String password) {
		String query = "INSERT INTO Student (NIC, FullName, Email, Password) VALUES (?,?,?,?)";
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, nic);
			stmt.setString(2, name);
			stmt.setString(3, email);
			stmt.setString(4, password);
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private boolean checkCreddentails(String nic, String password) {
		String query = "SELECT * FROM Student WHERE NIC = ? AND Password = ?";
		
	}
}
