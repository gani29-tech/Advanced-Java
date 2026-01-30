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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write("<form method='post'><label>id</label><input type='number' name ='id'><br><br><label>name</label><input type='text' name ='name'><br><input type='submit' value='submit'></form>");

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
    		PreparedStatement ps = con.prepareStatement("Insert into StudentDetails(id,name) values(?,?)");
    		String id = request.getParameter("id");
    		String name = request.getParameter("name");
    		ps.setInt(1, Integer.parseInt(id));
    		ps.setString(2, name);
    		ps.executeUpdate();
    		pw.write("<p>Inserted Successfully</p><br>");
    		pw.write("<a href='"+request.getContextPath()+"/ViewDetails'>View Employee Details</a>");
    		ps.close();
    		con.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
	}
}
