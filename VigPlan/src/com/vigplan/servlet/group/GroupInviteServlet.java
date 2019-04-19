package com.vigplan.servlet.group;

import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.GroupVo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.GroupVo;
import com.vigplan.vo.MemberVo;
import com.vigplan.dao.group.GroupDao;

@WebServlet("/group/invite")
public class GroupInviteServlet extends BaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gNo = request.getParameter("gNo");
		String no = request.getParameter("no");
		
		GroupVo gvo = new GroupVo();
		gvo.setgNo(Long.valueOf(gNo));
		
		MemberVo mvo = new MemberVo();
		mvo.setNo(Long.valueOf(no));
		
		GroupDao dao = new GroupDao(dbuser, dbpass);
		
		dao.insertbridge(mvo, gvo);

		System.out.println("invite : do Post");
		response.sendRedirect(request.getContextPath() + "/group/select?gNo=" + gNo);
		
	}

}
