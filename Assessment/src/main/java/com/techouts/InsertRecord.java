package com.techouts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/InsertRecord")
public class InsertRecord extends GenericServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
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
			PreparedStatement ps = con.prepareStatement("Insert into Employee(id,name,salary) values(?,?,?)")){
			
			pw.write("<form>Id <Input type='number' name='id'><br>Name <Input type='text' name='name'><br>Salary<Input type='number' name='salary'>");
			pw.write("<Input type='submit' value='insert'></form>");
			ps.setInt(1,Integer.parseInt(req.getParameter("id")));
			ps.setString(2, req.getParameter("name"));
			ps.setDouble(3, Double.parseDouble(req.getParameter("salary")));
			int ex = ps.executeUpdate();
			if(ex>0) {
				pw.write("Inserted Successfully");
				pw.write("<a href = '/Assessment/DisplayRecords'>DisplayRecords</a>");
			}
		}
		catch(Exception e) {
			res.getWriter().print(e.getMessage());
		}
	}
}
