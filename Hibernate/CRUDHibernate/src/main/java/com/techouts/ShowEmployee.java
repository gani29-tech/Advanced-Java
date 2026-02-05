package com.techouts;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet("/ShowEmployee")
public class ShowEmployee extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SessionFactory sf;

    @Override
    public void init() {
        sf = new Configuration().configure().buildSessionFactory();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (Session session = sf.openSession()) {
            List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
            request.setAttribute("employees", employees); 
            request.getRequestDispatcher("ShowEmployee.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        if (sf != null) {
            sf.close();
        }
    }
}
