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

@WebServlet("/sidebar")
public class SidebarServlet extends BaseServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		if (authUser != null)  {
			String gNo = req.getParameter("gNo");
			GroupDao dao = new GroupDao(dbuser, dbpass);
			List<GroupVo> list = dao.getMyGroup(authUser.getNo());
			
			System.out.println("sidebarGlist");
			req.setAttribute("sidebarGlist", list);
		
			
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/includes/sidebar2.jsp");
		rd.include(req, resp);
		
	}

}
