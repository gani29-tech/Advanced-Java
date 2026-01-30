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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write("<p>enter the name of Employee to remove");
		pw.write("<form method='post'><br><br><label>name</label><input type='text' name ='name'><br><input type='submit' value='submit'></form>");

	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	PrintWriter pw = response.getWriter();
    	try {
    		Class.forName("org.postgresql.Driver");
    		String url = "jdbc:postgresql://localhost:2010/student";
    		String username = "postgres";
    		String password = "root";
    		Connection con = DriverManager.getConnection(url,username,password);
    		PreparedStatement ps = con.prepareStatement("Delete from StudentDetails where name = ?");
    		String name = request.getParameter("name");
    		ps.setString(1, name);
    		int n = ps.executeUpdate();
    		if(n>0) {
    			pw.write("<p>Removed Successfully</p><br>");
    		}
    		else {
    			pw.write("<p>No Entries Exist</p> ");
    			pw.write("<a href='"+request.getContextPath()+"/AddStudent'>Add Employee Details</a>");
    		}
    		pw.write("<a href='"+request.getContextPath()+"/ViewDetails'>View Employee Details</a>");
    		ps.close();
    		con.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
	}
}
