package com.vigplan.servlet.group;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vigplan.dao.group.GroupDao;
import com.vigplan.dao.member.MemberDao;
import com.vigplan.vo.GroupVo;
import com.vigplan.vo.MemberVo;
import com.vigplan.servlet.BaseServlet;


@WebServlet("/group/select")
public class GroupSelectServlet extends BaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		HttpSession session = request.getSession();
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		
		if (authUser == null) {
			//	리다이렉트
			response.sendRedirect(request.getContextPath() + "/member/login");
		} else {
		
		String gNo = request.getParameter("gNo");
		GroupDao dao = new GroupDao(dbuser, dbpass);
		GroupVo vo = dao.selectOne(Long.valueOf(gNo));
		request.setAttribute("group", vo);
		
		MemberDao mdao = new MemberDao(dbuser, dbpass);
		List<MemberVo> list = mdao.getMyMember(Long.valueOf(gNo));
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/group/groupselect.jsp");
		rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
