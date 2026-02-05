	package com.techouts;
	
	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;
	
	@WebServlet("/RemoveEmployee")
	public class RemoveEmployee extends HttpServlet {
		@Override
		public void init() {
			sf = new Configuration().configure().buildSessionFactory();
		}
		private static final long serialVersionUID = 1L;
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			try(Session session = sf.openSession()){
				session.beginTransaction();
				Employee emp = session.get(Employee.class, id);
				if(emp!=null) {
					session.remove(emp);
				}
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
