package com.techouts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExceptionHandling")
public class ExceptionHandling extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String url = "jdbc:postgresql://localhost:2010/employee";
		String username = "postgres";
		String password = "root";
		try(Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement ps = con.prepareStatement("Select * from Employee")){
		}catch(Exception e) {
			out.print(e.getMessage());
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
