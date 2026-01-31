package com.techouts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayRecords")
public class DisplayRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:postgresql://localhost:2010/employee";
		String username = "postgres";
		String password = "root";
		try(Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement ps = con.prepareStatement("Select * from Employee")){
		ResultSet rs = ps.executeQuery();
		out.print("<table border='1'><tr><th>Id</th><th>Name</th><th>Salary</th></tr>");
		while(rs.next()) {
			out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</tr>");
		}
		out.print("</table>");
		}catch(Exception e) {
			out.print(e.getMessage());
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
