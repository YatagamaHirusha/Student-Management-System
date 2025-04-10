package com.SMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class  StudentDAO{
	Connection connection = DatabaseConnection.getInstance();
	
	void registerStudent(String nic, String name, String email, String password) {
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
	
	boolean loginStudent(String nic, String password) {
		boolean isAuthenticate = false;
		String query = "SELECT * FROM Student WHERE NIC = ? AND Password = ?";
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, nic);
			stmt.setString(2, password);
			//stmt.executeUpdate(); // If I uncomment this, the code will not execute correctly.
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				isAuthenticate = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return isAuthenticate;
	}
	
	boolean checkStudent(String nic) {
		boolean isExists = false;
		String query = "SELECT * FROM Student WHERE NIC = ?";
		try(PreparedStatement st = connection.prepareStatement(query)){
			st.setString(1, nic);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				isExists = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return isExists;
	}
	
	void resetCredentials(String nic, String newPassword) {
		String query = "UPDATE Student SET Password = ? WHERE NIC = ? ";
		try(PreparedStatement st = connection.prepareStatement(query)){
			st.setString(1, newPassword);
			st.setString(2, nic);
			st.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
