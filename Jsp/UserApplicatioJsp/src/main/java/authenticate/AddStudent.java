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

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("AddStudent.jsp").forward(request, response);
	}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String url = "jdbc:postgresql://localhost:2010/student";
		String username = "postgres";
		String password = "root";
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			request.setAttribute("error",e.getMessage());
    		request.getRequestDispatcher("AddStudent.jsp").forward(request, response);
		}
    	try(Connection con = DriverManager.getConnection(url,username,password);
    		PreparedStatement ps = con.prepareStatement("Insert into StudentDetails(id,name) values(?,?)")) {
    		if(id==null||id.isEmpty()||name==null||name.isEmpty()) {
    			request.setAttribute("error","Id and name cannot be empty");
    			request.getRequestDispatcher("AddStudent.jsp").forward(request, response);
    		}
    		ps.setInt(1, Integer.parseInt(id));
    		ps.setString(2, name);
    		ps.executeUpdate();
    		request.setAttribute("message", "Student Inserted Successfully");
    		request.getRequestDispatcher("AddStudent.jsp").forward(request, response);
    	}
    	catch(Exception e) {
    		request.setAttribute("error",e.getMessage());
    		request.getRequestDispatcher("AddStudent.jsp").forward(request, response);
    	}
	}
}
