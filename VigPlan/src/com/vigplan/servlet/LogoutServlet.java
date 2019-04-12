package com.vigplan.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vigplan.vo.MemberVo;

public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		MemberVo vo = (MemberVo)session.getAttribute("login_info");
		
		if(vo==null) {
			request.setAttribute("error_message", "로그인 후 로그아웃 할 수 있습니다.");
		} else {
			session.invalidate(); // 세션 없애기
		}
		RequestDispatcher rdp = request.getRequestDispatcher("/login_form.jsp");
		rdp.forward(request, response);
	}
}
