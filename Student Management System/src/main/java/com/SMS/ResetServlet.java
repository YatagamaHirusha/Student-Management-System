package com.SMS;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ResetServlet extends HttpServlet{
	
	private StudentDAO student = new StudentDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getParameter("nic");
		String password = request.getParameter("password");
	}
}
