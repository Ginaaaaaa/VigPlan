package com.vigplan.servlet.moim;

import com.vigplan.dao.MDao;
import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.MVo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/moim/delete")
public class MDeleteServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do Get");
		String mNo = request.getParameter("mNo");
		MDao dao = new MDao(dbuser, dbpass);
		dao.deletemBoard(Integer.valueOf(mNo));
		System.out.println("ok?");
		response.sendRedirect(request.getContextPath() + "/moim");
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
