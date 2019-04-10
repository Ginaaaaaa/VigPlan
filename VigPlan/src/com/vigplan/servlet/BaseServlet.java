package com.vigplan.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet {
	protected String dbuser = null;
	protected String dbpass = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config); // 절대 지우지 맙시다.
		
		ServletContext context = getServletContext();
		dbuser = context.getInitParameter("dbuser");
		dbpass = context.getInitParameter("dbpass");
		

	}

}
