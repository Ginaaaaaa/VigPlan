package com.vigplan.servlet.group;

import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.GroupVo;
import com.vigplan.dao.group.GroupDao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/group/write")
public class GroupWriteServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("groupwriteservlet");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/group/groupwriteform.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String gName = req.getParameter("gName");
		String gPw = req.getParameter("gPw");
		
		resp.setContentType("text/html);charset=UTF-8"); 
		resp.setCharacterEncoding("UTF-8");
		System.out.println("do Post");
		
		GroupVo vo = new GroupVo(); 
		vo.setgName(gName);
		vo.setgPw(gPw);

		GroupDao dao = new GroupDao(dbuser, dbpass);
		int i = dao.insertgboard(vo);
		
		resp.sendRedirect(req.getContextPath() + "/group");
	}

}
