package com.vigplan.servlet.group;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vigplan.dao.group.GroupDao;
import com.vigplan.vo.GroupVo;
import com.vigplan.servlet.BaseServlet;


@WebServlet("/group/select")
public class GroupSelectServlet extends BaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		String gNo = request.getParameter("gNo");
		GroupDao dao = new GroupDao(dbuser, dbpass);
		GroupVo vo = dao.selectOne(Long.valueOf(gNo));
		System.out.println(vo);
		request.setAttribute("group", vo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/group/groupselect.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
