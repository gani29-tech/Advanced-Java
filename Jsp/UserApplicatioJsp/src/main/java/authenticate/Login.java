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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("Login.jsp").forward(request,response);
    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username.isEmpty()||password.isEmpty()) {
			request.setAttribute("error", "Username or Password can't be null");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;
		}
    		String url = "jdbc:postgresql://localhost:2010/student";
    		String dbusername = "postgres";
    		String dbpassword = "root";
    		HttpSession session = request.getSession();
    		try {
    			Class.forName("org.postgresql.Driver");
    		} catch (ClassNotFoundException e) {
    			request.setAttribute("error",e.getMessage());
        		request.getRequestDispatcher("Login.jsp").forward(request, response);
    		}
    	try(Connection con = DriverManager.getConnection(url,dbusername,dbpassword);
    			PreparedStatement ps = con.prepareStatement("select * from auth where username = ?")){
    		ps.setString(1, username);
    		ResultSet rs = ps.executeQuery();
    		if(rs.next()) {
    			if(rs.getString(2).equals(password)) {
				session.setAttribute("username", username);
	    		request.getRequestDispatcher("ProfilePage.jsp").forward(request, response);
	    		
				}
				else {
					request.setAttribute("error", "Invalid Password");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}	 	
    		}
    		else {
    			request.setAttribute("error", "User does not Exist");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
    		}
    	}
    	catch(Exception e) {
    		request.setAttribute("error", e.getMessage());
    		request.getRequestDispatcher("Login.jsp").forward(request, response);
    	}
	}

}
