package authenticate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write("<br><p>welcome to Login page!!");
		pw.write("<form method='post'><label>username</label><input type='text' name ='username'><br><br><label>password</label><input type='password' name ='password'><br><input type = 'submit' value='Login'></form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		try {
    		Class.forName("org.postgresql.Driver");
    		String url = "jdbc:postgresql://localhost:2010/student";
    		String dbusername = "postgres";
    		String dbpassword = "root";
    		HttpSession session = request.getSession();
    		Connection con = DriverManager.getConnection(url,dbusername,dbpassword);
    		PreparedStatement ps = con.prepareStatement("select * from auth where username = ?");
    		String username = request.getParameter("username");
    		String password = request.getParameter("password");
    		ps.setString(1, username);
    		ResultSet rs = ps.executeQuery();
    		if(username.isEmpty()||password.isEmpty()) {
    			pw.write("Username or Password can't be null");
    			pw.write("<br><a href = '"+request.getContextPath()+"/Login'>Login again</a>");
    		}
    		else if(rs.next()) {
    			if(rs.getString(2).equals(password)) {
				pw.write("Login Successful<br>");
				session.setAttribute("username", username);
	    		request.getRequestDispatcher("/ProfilePage").include(request, response);
	    		
				}
				else {
					pw.write("Invalid Password");
					pw.write("<br><a href = '"+request.getContextPath()+"/Login'>Login again</a>");
				}	 	
    		}
    		else {
    			pw.write("User does not exist!!!");
    			pw.write("<br><a href = '"+request.getContextPath()+"/Login'>Login again</a>");
    		}
    		ps.close();
    		con.close();
    	}
    	catch(Exception e) {
    		pw.write("<p>"+e.getMessage()+"</p>");
    	}
		
	}

}
