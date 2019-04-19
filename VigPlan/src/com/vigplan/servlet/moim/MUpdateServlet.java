package com.vigplan.servlet.moim;

import com.vigplan.dao.moim.MDao;
import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.MVo;

import java.io.IOException;

import java.lang.Integer.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/moim/update")
public class MUpdateServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		String mNo = request.getParameter("mNo");
		MDao dao = new MDao(dbuser, dbpass);
		MVo vo = dao.selectOne(Long.valueOf(mNo));
		System.out.println(vo);
		request.setAttribute("moim", vo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/moim/mUpdateForm.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		System.out.println("doPost");
		
		resp.setContentType("text/html;charset=UTF-8"); 
		resp.setCharacterEncoding("UTF-8"); 
		req.getParameter("mNo");
		
		String mNo = req.getParameter("mNo");
		String mTitle = req.getParameter("mTitle"); 
		String mDate = req.getParameter("mDate"); 
		String mContent = req.getParameter("mContent");
		
		MVo vo = new MVo();
		vo.setmNo(Long.valueOf(mNo));
		vo.setmTitle(req.getParameter("mTitle"));
		vo.setmDate(req.getParameter("mDate"));
		vo.setmContent(req.getParameter("mConent"));
		System.out.println("do Post 2");
		
		MDao dao = new MDao(dbuser, dbpass);
		int i = dao.updatemBoard(Long.valueOf(mNo), mTitle, mDate, mContent);
		
		resp.sendRedirect(req.getContextPath() + "/moim/select?mNo=" + mNo);

	    }

	}
