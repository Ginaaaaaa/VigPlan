package com.vigplan.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vigplan.dao.member.MemberDao;
import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.MemberVo;


@SuppressWarnings("serial")
@WebServlet("/member/logout")
public class LogoutServlet extends BaseServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String action = request.getParameter("a");
		
		if (action == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/login_form.jsp");
		rd.forward(request, response);

		}
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		
		MemberDao dao = new MemberDao(dbuser, dbpass);
			HttpSession session = request.getSession();
			session.invalidate();
			MemberVo vo = dao.getMember(id, password);
			System.out.println("LOGout: VO = " + vo);
	}

}
