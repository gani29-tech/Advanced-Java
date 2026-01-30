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

@WebServlet("/RemoveStudent")
public class RemoveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("RemoveStudent.jsp").forward(request, response);
	}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String url = "jdbc:postgresql://localhost:2010/student";
		String username = "postgres";
		String password = "root";
		String name = request.getParameter("name");
		if(name==null||name.isEmpty()) {
			request.setAttribute("error", "Name cannot be Empty");
			request.getRequestDispatcher("RemoveStudent.jsp").forward(request, response);
			return;
		}
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			request.setAttribute("error",e.getMessage());
    		request.getRequestDispatcher("RemoveStudent.jsp").forward(request, response);
		}
    	try(Connection con = DriverManager.getConnection(url,username,password);
    		PreparedStatement ps = con.prepareStatement("Delete from StudentDetails where name = ?")) {
    		ps.setString(1, name);
    		int n = ps.executeUpdate();
    		if(n>0) {
    			request.setAttribute("message", "Removed Successfully");
    			request.getRequestDispatcher("ViewStudent.jsp").forward(request, response);
    		}
    		else {
    			request.setAttribute("error", "No entries Exist");
    			request.getRequestDispatcher("AddStudent.jsp").forward(request, response);
    		}
    	}
    	catch(Exception e) {
    		request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("RemoveStudent.jsp").forward(request, response);
    	}
	}
}
