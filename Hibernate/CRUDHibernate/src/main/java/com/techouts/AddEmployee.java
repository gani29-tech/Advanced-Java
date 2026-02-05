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

@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init() {
		sf = new Configuration().configure().buildSessionFactory();
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try(Session session = sf.openSession()){
				session.beginTransaction();
				int id =Integer.parseInt( request.getParameter("id"));
				String name = request.getParameter("name");
				Double salary = Double.parseDouble(request.getParameter("salary"));
				Employee emp = new Employee(id, name,salary);
				HttpSession httpsession = request.getSession(false);
				User user = (User)httpsession.getAttribute("user");
				emp.setUser(user);
				session.persist(emp);
				session.getTransaction().commit();
			}
			response.sendRedirect(request.getContextPath()+"/ShowEmployee");
	}
	private SessionFactory sf;
	@Override
	public void destroy() {
		if(sf!=null) {
			sf.close();
		}
	}
}
