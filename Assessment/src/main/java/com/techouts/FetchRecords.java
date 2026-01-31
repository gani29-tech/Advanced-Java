package com.techouts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/FetchRecords")
public class FetchRecords extends GenericServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.write("Enter the Id ");
		pw.write("<form>Id <Input type='number' name='id'>");
		pw.write("<Input type='submit' value='Enter'></form>");
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:postgresql://localhost:2010/employee";
		String username = "postgres";
		String password = "root";
		try (
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement ps = con.prepareStatement("Select * from Employee where id = ?")){
			ps.setInt(1,Integer.parseInt(req.getParameter("id")));
			ResultSet rs = ps.executeQuery();
			if(req.getParameter("id")==null||req.getParameter("id").isEmpty()) {
				pw.print("Enter the id");
				req.getRequestDispatcher("/FetchRecords").forward(req, res);
			}
			if(rs.isBeforeFirst()) {
				pw.print("<table border='1'><tr><th>Id</th><th>Name</th><th>Salary</th></tr>");
				while(rs.next()) {
					pw.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr>");
				}
				pw.print("</table>");
			}
			else{
				pw.write("No records found");
				pw.write("<br><a href = '/Assessment/DisplayRecords'>DisplayRecords</a>");
			}
		}
		catch(Exception e) {
			res.getWriter().print(e.getMessage());
		}
	}
}
