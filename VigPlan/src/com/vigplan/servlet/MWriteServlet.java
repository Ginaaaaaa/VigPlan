package com.vigplan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vigplan.dao.MDao;
import com.vigplan.vo.MVo;

@WebServlet("/MWriteServlet")
public class MWriteServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    public MWriteServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String mTitle = req.getParameter("mTitle"); 
		String mDate = req.getParameter("mDate"); 
		String mPlace = req.getParameter("mPlace");
		String mContent = req.getParameter("mContent");
		
		System.out.println("doPost");
		
		resp.setContentType("text/html);charset=UTF-8"); 
		resp.setCharacterEncoding("UTF-8"); 

		MVo vo = new MVo(); 
		vo.setmTitle(mTitle);
		vo.setmDate(mDate);
		vo.setmPlace(mPlace);
		vo.setmContent(mContent);

		
		MDao dao = new MDao(dbuser, dbpass);
		int i = dao.insertmBoard(vo);
		
		
		resp.sendRedirect("./mForm/mList.jsp");
	}

}

