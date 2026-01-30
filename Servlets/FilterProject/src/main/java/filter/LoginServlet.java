package filter;
 
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
 
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		response.getWriter().println("<h1>Login Servlet Executed !!</h1>");
		String user = request.getParameter("name");
		String password = request.getParameter("pwd");
		HttpSession session = request.getSession();
	    session.setAttribute("user", user); 
	    session.setAttribute("password",password);
	    
	    response.sendRedirect("welcome.jsp"); 
	}
 
}