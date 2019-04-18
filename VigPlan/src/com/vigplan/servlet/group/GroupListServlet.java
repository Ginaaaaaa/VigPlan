package com.vigplan.servlet.group;

import com.vigplan.dao.group.GroupDao;import com.vigplan.vo.GroupVo;
import com.vigplan.vo.MemberVo;

import java.util.List;
import com.vigplan.servlet.BaseServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/group")
public class GroupListServlet extends BaseServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		
		System.out.println("현재사용자:" + authUser);
		
		//	기본적으로 로그인 안된 사용자는 로그인 창으로 돌려보내기
		if (authUser == null) {
			//	리다이렉트
			response.sendRedirect(request.getContextPath() + "/member/login");
		} else {
			GroupDao dao = new GroupDao(dbuser, dbpass);
			List<GroupVo> list = dao.getMyGboard(authUser.getNo());
			
			System.out.println("list?");
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/group/grouplist.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
