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

@WebServlet("/ViewDetails")
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
    	PrintWriter pw = response.getWriter();
    	try {
    		Class.forName("org.postgresql.Driver");
    		System.out.println("1");
    		String url = "jdbc:postgresql://localhost:2010/student";
    		String username = "postgres";
    		String password = "root";
    		Connection con = DriverManager.getConnection(url,username,password);
    		PreparedStatement ps = con.prepareStatement("Select * from StudentDetails");
    		ResultSet rs = ps.executeQuery();
    		System.out.println("2");
    		if(!rs.isBeforeFirst()) {
    			pw.write("No entries");
    			
    		}
    		else {
    			pw.write("<table>");
    			pw.write("<tr><td>Id</td><td>Name</td></tr>");
        		while(rs.next()) {
        			pw.write("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td></tr>");
        		}
        		pw.write("</table>");
    		}
    		ps.close();
    		con.close();
    		System.out.println("2");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}

	}
  
}
