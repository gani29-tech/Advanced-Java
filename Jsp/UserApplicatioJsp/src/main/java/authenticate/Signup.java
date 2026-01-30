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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("SignUp.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username==null||password==null||username.isEmpty()||password.isEmpty()) {
			request.setAttribute("error", "Name or Password can't be null");
			request.getRequestDispatcher("SignUp.jsp").forward(request, response);
			return;
		}
		String url = "jdbc:postgresql://localhost:2010/student";
		String dbusername = "postgres";
		String dbpassword = "root";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			request.setAttribute("error",e.getMessage());
    		request.getRequestDispatcher("SignUp.jsp").forward(request, response);
		}
		try(Connection con = DriverManager.getConnection(url,dbusername,dbpassword);
    		PreparedStatement ps = con.prepareStatement("insert into auth(username,password) values(?,?)")) {
    		ps.setString(1, username);
    		ps.setString(2, password);
    		ps.executeUpdate();
    		request.setAttribute("message", "SignUp Successful");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
    		ps.close();
    		con.close();
    		session.setAttribute("username", username);
    	}
    	catch(Exception e) {
    		request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("SignUp.jsp").forward(request, response);
    	}
	}

}
