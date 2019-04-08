package com.vigplan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vigplan.dao.BoardDao;
import com.vigplan.vo.BoardVo;


@WebServlet("/boardform")
public class WriteFormServelt extends BaseServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		/*
		PrintWriter writer = resp.getWriter();
		writer.println("name=" + name + ", log=" + log);
		writer.close();
		*/
		BoardVo vo = new BoardVo();
		
		vo.setTitle(title);
		vo.setContent(content);
	
		
		resp.sendRedirect(req.getServletContext().getContextPath()+"/boardform");
		
	}

}
