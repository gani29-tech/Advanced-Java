package com.techouts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends GenericServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.write("Enter the Id ");
		pw.write("<form>Id <Input type='number' name='id'>");
		pw.write("<Input type='submit' value='Delete'></form>");
		
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
			PreparedStatement ps = con.prepareStatement("Delete from Employee where id = ?")){
			ps.setInt(1, Integer.parseInt(req.getParameter("id")));
			int rs = ps.executeUpdate();
			if(rs>0) {
				pw.write("Record Deleted Successfully");
				pw.write("<br><a href = '/Assessment/DisplayRecords'>DisplayRecords</a>");
			}
			else{
				pw.write("No records found on that ID");
				pw.write("<br><a href = '/Assessment/DisplayRecords'>DisplayRecords</a>");
			}
		}
		catch(Exception e) {
			res.getWriter().print(e.getMessage());
		}
	}
}
