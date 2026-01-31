package com.techouts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ForwardRequest")
public class ForwardRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =  request.getParameter("name");
		request.setAttribute("username", name);
		request.getRequestDispatcher("ForwardRequest.jsp").forward(request, response);
	}

}
