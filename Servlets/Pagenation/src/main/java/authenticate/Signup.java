package authenticate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write("<form method='post'><label>username</label><input type='text' name ='username'><br><br><label>password</label><input type='password' name ='password'><br><input type='submit' value='signup'></form>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username==null||password==null||username.isEmpty()||password.isEmpty()) {
			pw.write("<p>username or password can't be null or empty</p>");
			pw.write("<a href = '"+request.getContextPath()+"/Signup'>SignUp</a>");
			return;
		}

		try {
    		Class.forName("org.postgresql.Driver");
    		String url = "jdbc:postgresql://localhost:2010/student";
    		String dbusername = "postgres";
    		String dbpassword = "root";
    		Connection con = DriverManager.getConnection(url,dbusername,dbpassword);
    		PreparedStatement ps = con.prepareStatement("insert into auth(username,password) values(?,?)");
    		ps.setString(1, username);
    		ps.setString(2, password);
    		ps.executeUpdate();
    		pw.write("Sign up Successful");
    		pw.write("<a href='"+request.getContextPath()+"/Login'>Go to Login</a>");
    		ps.close();
    		con.close();
    		session.setAttribute("username", username);
    	}
    	catch(Exception e) {
    		pw.write("<p>"+e.getMessage()+"</p>");
    		pw.write("<br><a href = '"+request.getContextPath()+"/Signup'>SignUp Again</a>");
    	}
	}

}
