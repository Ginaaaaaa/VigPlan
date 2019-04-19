package com.vigplan.servlet.group;

import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.GroupVo;
import com.vigplan.vo.MemberVo;
import com.vigplan.dao.group.GroupDao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/group/write")
public class GroupWriteServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	TODO: Session Redirect -> 로그인 안한 요청이면 로그인 창으로
		HttpSession session = request.getSession();
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		
		System.out.println("현재사용자:" + authUser);
		
		//	기본적으로 로그인 안된 사용자는 로그인 창으로 돌려보내기
		if (authUser == null) {
			//	리다이렉트
			response.sendRedirect(request.getContextPath() + "/member/login");
		} else {
		// 로그인 했으면 write 창으로
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/group/groupwriteform.jsp");
		rd.forward(request, response);
		System.out.println("write : do Get");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String gName = req.getParameter("gName");
		String gPw = req.getParameter("gPw");
		
		resp.setContentType("text/html);charset=UTF-8"); 
		resp.setCharacterEncoding("UTF-8");
		System.out.println("write : do Post");
		
		GroupVo vo = new GroupVo(); 
		vo.setgName(gName);
		vo.setgPw(gPw);

		GroupDao dao = new GroupDao(dbuser, dbpass);
		int i = dao.insertgboard(vo);
		
		Long maxno = dao.getgNo(vo);
		
		
		HttpSession session = req.getSession();
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		dao.insertbridge(authUser, vo);

		// sendRedirect
		resp.sendRedirect(req.getContextPath() + "/group/select?gNo=" + maxno);
		
	}

}
