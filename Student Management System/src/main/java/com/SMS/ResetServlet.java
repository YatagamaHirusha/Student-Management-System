package com.SMS;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ResetServlet extends HttpServlet{
	
	private StudentDAO student = new StudentDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String nic = request.getParameter("nic");
		String password = request.getParameter("newPassword");
		String hashPassword = PasswordUtil.hashPassword(password);
		
		if(student.checkStudent(nic)) {
			student.resetCredentials(nic, hashPassword);
			response.sendRedirect("index.html");
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("Invalid NIC.");
		}
	}
}
