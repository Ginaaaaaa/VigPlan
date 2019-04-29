package com.vigplan.servlet.group;

import com.vigplan.dao.group.GroupDao;
import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.GroupVo;
import com.vigplan.vo.MemberVo;
import com.vigplan.vo.MVo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/group/delete")
public class GroupDeleteServlet extends BaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	로그인 해야 함
		HttpSession session = request.getSession();
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		
		if (authUser == null) {
			//	리다이렉트
			response.sendRedirect(request.getContextPath() + "/member/login");
		} else {
		
		
		String gNo = request.getParameter("gNo");
		GroupDao dao = new GroupDao(dbuser, dbpass);
		GroupVo vo = dao.selectOne(Long.valueOf(gNo));
		System.out.println(vo);
		request.setAttribute("group", vo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/group/groupdeleteform.jsp");
		rd.forward(request, response);
	}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String gNo = request.getParameter("gNo");
		String pw = request.getParameter("pw");
		GroupDao dao = new GroupDao(dbuser, dbpass);
		PrintWriter out = response.getWriter();
		
		String gpw = dao.getGpw(Long.valueOf(gNo));		// 맞는 패스워드 호출
		System.out.println(gpw);
		
		if(gpw != String.valueOf(pw)) {					// 입력한 패스워드와 맞는 패스워드 비교
			out.println("<script type=\"text/javascript\">");
			out.println("alert('비밀번호가 틀립니다.');");
			out.println("history.back();");
			out.println("</script>");
			
		} else {
			
			dao.deleteMoimPlaceBridge(Long.valueOf(gNo));		// group 내 moim 내 moim_place_bridge의 mNo 레코드 삭제
			dao.deleteMoimInGroup(Long.valueOf(gNo));			// group 내 mboard 데이터 삭제
			int d = dao.deleteGroupMoimBridge(Long.valueOf(gNo));	//group_moim_bridge의 gNo 레코드 삭제
			int r = dao.deleteMemberGroupBridge(Long.valueOf(gNo));	//member_group_bridge의 gNo 레코드 삭제
			int i = dao.deleteGroup(Long.valueOf(gNo));	// group 데이터 삭제
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('삭제하였습니다.');");
			out.println("document.location.href='" + request.getContextPath() + "/group'");
			out.println("</script>");
			
		out.close();
		System.out.println("ok?");
		
	}
	}
}


