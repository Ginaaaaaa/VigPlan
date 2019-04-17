package com.vigplan.servlet.group;

import com.vigplan.dao.group.GroupDao;
import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.GroupVo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/group/delete")
public class GroupDeleteServlet extends BaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gNo = request.getParameter("gNo");
		GroupDao dao = new GroupDao(dbuser, dbpass);
		GroupVo vo = dao.selectOne(Long.valueOf(gNo));
		System.out.println(vo);
		request.setAttribute("group", vo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/group/groupdeleteform.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String gNo = request.getParameter("gNo");
		String pw = request.getParameter("pw");
		GroupDao dao = new GroupDao(dbuser, dbpass);
		PrintWriter out = response.getWriter();
		int i = dao.deletegBoard(Long.valueOf(gNo), pw);
		if(i == 0) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('비밀번호가 틀립니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('삭제하였습니다');");
			out.println("document.location.href='" + request.getContextPath() + "/group'");
			out.println("</script>");
		}
		out.close();
		System.out.println("ok?");
		response.sendRedirect(request.getContextPath() + "/group");
	}

}
