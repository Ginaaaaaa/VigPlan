package com.vigplan.home;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vigplan.dao.group.GroupDao;
import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.GroupVo;
import com.vigplan.vo.MemberVo;

@WebServlet("/")
public class HomeServlet extends BaseServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		HttpSession session = request.getSession();
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		if (authUser != null)  {
			String gNo = request.getParameter("gNo");
			GroupDao dao = new GroupDao(dbuser, dbpass);
			List<GroupVo> list = dao.getMyGroup(authUser.getNo());
			
			System.out.println("list");
			request.setAttribute("list", list);
		
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/home/home.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
