package authenticate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ProfilePage")
public class ProfilePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException,ServletException {
		response.setContentType("text/html");
		String name = request.getParameter("username");
		PrintWriter out = response.getWriter();
		out.write("Welcome "+name+"");
		out.write("<br><a href = '"+request.getContextPath()+"/AddStudent'>Add</a> ");
		out.write("<a href = '"+request.getContextPath()+"/RemoveStudent'>Remove</a> ");
		out.write("<a href = '"+request.getContextPath()+"/ViewDetails'>View</a> ");
	}
}
