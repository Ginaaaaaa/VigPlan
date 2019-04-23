package com.vigplan.servlet.group;

import com.vigplan.servlet.BaseServlet;
import com.vigplan.dao.group.GroupDao;
import com.vigplan.vo.GroupVo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/group/update")
public class GroupUpdateServlet extends BaseServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update: do Get");
		String gNo = request.getParameter("gNo");
		GroupDao dao = new GroupDao(dbuser, dbpass);
		GroupVo vo = dao.selectOne(Long.valueOf(gNo));
		System.out.println(vo);
		request.setAttribute("group", vo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/group/groupupdateform.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		System.out.println("update : do Post");
		
		resp.setContentType("text/html;charset=UTF-8"); 
		resp.setCharacterEncoding("UTF-8"); 
		req.getParameter("gNo");
		
		String gNo = req.getParameter("gNo");
		String gName = req.getParameter("gName"); 
		String gRegdate = req.getParameter("gRegdate"); 
		String gPw = req.getParameter("gPw");
		
		GroupVo vo = new GroupVo();
		vo.setgNo(Long.valueOf(gNo));
		vo.setgName(req.getParameter("gName"));
		vo.setgRegdate(req.getParameter("gRegdate"));
		vo.setgPw(req.getParameter("gPw"));
		
		GroupDao dao = new GroupDao(dbuser, dbpass);
		int i = dao.updateGroup(vo);
		
		resp.sendRedirect(req.getContextPath() + "/group/select?gNo=" + gNo);
	}

}
