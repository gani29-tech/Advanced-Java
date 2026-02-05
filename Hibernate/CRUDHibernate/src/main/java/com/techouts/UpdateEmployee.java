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

@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
		public void init() {
		sf = new Configuration().configure().buildSessionFactory();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/UpdateEmployee.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(Session session = sf.openSession()){
			var t = session.beginTransaction();
			try {
		
			int id =Integer.parseInt( request.getParameter("id"));
			String name = request.getParameter("name");
			Double salary = Double.parseDouble(request.getParameter("salary"));
			Employee emp = session.get(Employee.class, id);
			if(emp!=null) {
				emp.setName(name);
				emp.setSalary(salary);
				session.merge(emp);
			}
			t.commit();
		}
			catch(Exception e) {
				t.rollback();
			}
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
