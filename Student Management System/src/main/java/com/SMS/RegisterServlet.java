package com.SMS;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	private StudentDAO student = new StudentDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String nic = request.getParameter("nic");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String hashPassword = PasswordUtil.hashPassword(password);
		if(!student.checkStudent(nic)) {
			student.registerStudent(nic, name, email, hashPassword);
			response.sendRedirect("index.html");
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("Sorry student already registered.");
		}
	}
}
