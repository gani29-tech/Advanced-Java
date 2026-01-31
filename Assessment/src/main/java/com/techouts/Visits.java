package com.techouts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Visits")
public class Visits extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(true);
		Integer visitCount = (Integer)session.getAttribute("visitCount");
		if(visitCount==null) {
			visitCount=1;
			response.getWriter().write("Welcome");
		}
		else {
			visitCount++;
			response.getWriter().write("Welcome back");
		}
		session.setAttribute("visitCount", visitCount);
		response.getWriter().write("Your Session Id : "+session.getId()+"<br>");
		response.getWriter().write("Number of Visits : "+visitCount);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
