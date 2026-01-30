package model;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Pagenation")
public class PagenationServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		int page=1;
		if(request.getParameter("page")!=null) {
			 try {
	                page = Integer.parseInt(request.getParameter("page"));
	                if (page < 1) page = 1;
	            } catch (NumberFormatException e) {
	                page = 1;
	       }
		}
		int page_Size=5;
		int totalPages = 0;
		int totalEntries = 0;
		response.setContentType("text/html");
		List<User> users = new ArrayList<>();
		try(Connection con = DB.getConnection()){
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select Count(*) from users");
			if(rs.next()) {
				totalEntries = rs.getInt(1);
				System.out.println("TOTAL ENTRIES = " + totalEntries);

			}
			
				int offset = (page -1)*page_Size;
				totalPages = (int)Math.ceil(totalEntries*1.0/page_Size);
				PreparedStatement ps = con.prepareStatement("Select * from users ORDER BY id LIMIT ? OFFSET ?");
				ps.setInt(1,page_Size);
				ps.setInt(2, offset);
				rs = ps.executeQuery();
				while(rs.next()) {
					users.add(new User(rs.getInt("id"),rs.getString("name"),rs.getString("email")));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("users", users);
		request.setAttribute("currentPage", page);
		request.setAttribute("totalPages",totalPages);
		request.getRequestDispatcher("pagenation.jsp").forward(request, response);
	}
}