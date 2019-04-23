package com.vigplan.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.MemberVo;

@WebServlet("/member/info")
public class InfoServlet extends BaseServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberVo vo = (MemberVo)session.getAttribute("authUser");
		
		if (vo != null) {	
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/info_form.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath());
		}
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
