package com.vigplan.servlet.group;

import com.vigplan.dao.group.GroupDao;import com.vigplan.vo.GroupVo;

import java.util.List;
import com.vigplan.servlet.BaseServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/group")
public class GroupListServlet extends BaseServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GroupDao dao = new GroupDao(dbuser, dbpass);
		List<GroupVo> list = dao.getAllgboard();
		
		System.out.println("list?");
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/group/grouplist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
