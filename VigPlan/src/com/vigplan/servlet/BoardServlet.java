package com.vigplan.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vigplan.dao.BoardDao;
import com.vigplan.vo.BoardVo;


@WebServlet("/board")
public class BoardServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String action = req.getParameter("a");
		
		if (action == null) {
			BoardDao dao = new BoardDao(dbuser,dbpass);
			List<BoardVo> list = dao.getAllLogs();
			req.setAttribute("list", list);
			RequestDispatcher rd =
					req.getRequestDispatcher("/WEB-INF/views/board_main.jsp");
			rd.forward(req, resp);
		} else if ("form".equals(action)) {
			RequestDispatcher rd =
					req.getRequestDispatcher("/WEB-INF/views/boardform.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String password = req.getParameter("password");
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		BoardVo vo = new BoardVo();
		vo.setPassword(password);
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		

//		
		BoardDao dao = new BoardDao(dbuser,dbpass);
		int insertedCount = dao.insertBoard(vo);
		
		System.out.println("SUCCESS?:" + (insertedCount == 1));
		resp.sendRedirect(req.getServletContext().getContextPath()+"/board");
//
	}



}
