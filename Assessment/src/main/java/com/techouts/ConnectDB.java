package com.techouts;

import java.io.IOException;
import java.sql.DriverManager;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ConnectDB")
public class ConnectDB extends GenericServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:2010/student";
			String username = "postgres";
			String password = "root";
			DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			res.getWriter().print(e.getMessage());
		}
	}
}
