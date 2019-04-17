package com.vigplan.home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class HomeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("a");
		
	if (action == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/home/home.jsp");
		rd.forward(request, response);
		} else if ("success".equals(action)){	//	/member/login?a=success
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/login_success.jsp");
			rd.forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}