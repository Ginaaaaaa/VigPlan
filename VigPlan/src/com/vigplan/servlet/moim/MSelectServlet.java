package com.vigplan.servlet.moim;

import com.vigplan.dao.moim.MDao;
import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.MVo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/moim/select")
public class MSelectServlet extends BaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("select: do Get");
		String mNo = request.getParameter("mNo");
		MDao dao = new MDao(dbuser, dbpass);
		MVo vo = dao.selectOne(Long.valueOf(mNo));
		System.out.println(vo);
		request.setAttribute("moim", vo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/moim/mSelect.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
