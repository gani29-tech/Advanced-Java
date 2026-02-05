package com.techouts;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init() {
		sf = new Configuration().configure().buildSessionFactory();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/Login.jsp");
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try(Session session = sf.openSession()){
				session.beginTransaction();
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				User user = session.get(User.class, username);
				if(user!=null&&user.getPassword().equals(password)) {
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("user", user);
					response.sendRedirect(request.getContextPath()+"/ShowEmployee");
				}
				else {
					response.sendRedirect(request.getContextPath()+"/Login");;
				}
			}
	}
	private SessionFactory sf;
	@Override
	public void destroy() {
		if(sf!=null) {
			sf.close();
		}
	}
}
