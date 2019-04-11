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
			BoardDao dao = new BoardDao(dbuser, dbpass);

			List<BoardVo> list = dao.getAllLogs(); // 다 보여주는것
			req.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/board/board_main.jsp");
			rd.forward(req, resp);

		} else if ("form".equals(action)) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/board/boardform.jsp");
			rd.forward(req, resp);

		} else if ("show".equals(action)) {
			String id = req.getParameter("id");
			BoardDao dao = new BoardDao(dbuser, dbpass);
			BoardVo vo = dao.getBoardItem(Long.valueOf(id)); // id의 값을 string으로 받아오니까
			req.setAttribute("item", vo);

			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/board/board_show.jsp");
			rd.forward(req, resp);

		} else if ("edit".equals(action)) {
			String id = req.getParameter("id");
			BoardDao dao = new BoardDao(dbuser, dbpass);
			BoardVo vo = dao.getBoardItem(Long.valueOf(id)); // id의 값을 string으로 받아오니까
			req.setAttribute("item", vo);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/board/board_edit.jsp");
//			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/board/board_edit.jsp");
			rd.forward(req, resp);
			

		} else if ("delete".equals(action)) {
			String id = req.getParameter("id");
			BoardDao dao = new BoardDao(dbuser, dbpass);
			dao.deleteBoardItem(Long.valueOf(id));
			
			resp.sendRedirect(req.getServletContext().getContextPath() + "/board");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("a");

		// boardform 수행시 parameter
		if ("write".equals(action)) {
			String password = req.getParameter("password");
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");

			BoardVo vo = new BoardVo();

			vo.setPassword(password);
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			

			BoardDao dao = new BoardDao(dbuser, dbpass);
			/*int insertedCount = */dao.insertBoard(vo);

//			System.out.println("SUCCESS?:" + (insertedCount == 1));

			resp.sendRedirect(req.getServletContext().getContextPath() + "/board");

			// 메인창에서 title 클릭시 넘어가는 창(내용 보여주기)
		} else if ("editer".equals(action)) {
			
			BoardDao dao = new BoardDao(dbuser,dbpass);
		
			String id = req.getParameter("id");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
				
			BoardVo vo = dao.getBoardItem(Long.valueOf(id));
			
			if (title == null || title.length() == 0) {
				title = vo.getTitle();
			}
			if (content == null || content.length() == 0) {
				content = vo.getContent();
			}
			
		
//			
//			System.out.println(vo.toString());
//		
			vo.setId(Long.valueOf(id));
			vo.setTitle(title);
			vo.setContent(content);
			
			
			
			System.out.println(vo.toString());		
//			vo.setWriter(writer);
//			vo.setReg_date(reg_date);
//			vo.setview_cnt(view_cnt);
	
			int result = dao.updateBoard(vo);
			System.out.println("SUCCESS?:" + (result == 1));
			resp.sendRedirect(req.getServletContext().getContextPath() + "/board");
//			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/board/board_main.jsp");
//			rd.forward(req, resp);

			// TODO: board 리스트로 다시 리다이렉트
		}
		//
	}

}
