package com.vigplan.servlet.group;

import com.vigplan.dao.group.GroupDao;
import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.GroupVo;
import com.vigplan.vo.MemberVo;
import com.vigplan.dao.member.MemberDao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/group/search")
public class GroupSearchServlet extends BaseServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		
		System.out.println("현재사용자:" + authUser);
		
		//	기본적으로 로그인 안된 사용자는 로그인 창으로 돌려보내기
		if (authUser == null) {
			//	리다이렉트
			response.sendRedirect(request.getContextPath() + "/member/login");
		} else {
		System.out.println("search: do Get");
		String gNo = request.getParameter("gNo");
		GroupDao dao = new GroupDao(dbuser, dbpass);
		GroupVo vo = dao.selectOne(Long.valueOf(gNo));
		System.out.println(vo);
		request.setAttribute("group", vo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/group/groupsearchform.jsp");
		rd.forward(request, response);
	}
		}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		
		System.out.println("현재사용자:" + authUser);
		
		//	기본적으로 로그인 안된 사용자는 로그인 창으로 돌려보내기
		if (authUser == null) {
			//	리다이렉트
			response.sendRedirect(request.getContextPath() + "/member/login");
		} else {
			
		System.out.println("search : do Post");
		String gNo = request.getParameter("gNo");
		String searchid = request.getParameter("searchid");
		GroupDao gdao = new GroupDao(dbuser, dbpass);
		GroupVo vo = gdao.selectOne(Long.valueOf(gNo));
		request.setAttribute("group", vo);

		MemberDao mdao = new MemberDao(dbuser, dbpass);
		List<MemberVo> list = mdao.getAllinvite(authUser,searchid);
		System.out.println(list);
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/group/groupsearchresult.jsp");
		rd.forward(request, response);
		System.out.println(gNo);
		
		}
	}
}
