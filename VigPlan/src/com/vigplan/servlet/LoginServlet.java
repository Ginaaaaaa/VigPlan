package com.vigplan.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vigplan.vo.MemberVO;

public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 1. 요청 파라미터 조회
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// Business Login 처리
		ServletContext sct = getServletContext();
		String url = sct.getInitParameter("url");
		String user = sct.getInitParameter("user");
		String DBPwd = sct.getInitParameter("password");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "select id, password, nickName, eMail, rDate from member where id=?";
		
		String resURL = null;
		
		try {
			conn = DriverManager.getConnection(url, user, DBPwd);
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			// 아이디가 있으면
			if(rs.next()) { // 아이디가 있는 경우 실행
				// 패스워드 비교
				if(password.equals(rs.getString(2))) { // ID와 PW가 맞는 경우
					HttpSession session = request.getSession();
					MemberVO vo = new MemberVO(id, password, rs.getString(3), 
							rs.getString(4), rs.getString(5));
					
					session.setAttribute("login_info", vo);
					response.sendRedirect("/com/vigplan/res/login_success.jsp");
				} else { // 패스워드가 틀린 경우
					request.setAttribute("error_message","패스워드가 틀렸습니다.");
					resURL = "/login_form.jsp";
				}
			} else { // id가 없는 경우
				request.setAttribute("error_message", id + "는 없는 ID 입니다.");
				resURL = "login_form.jsp";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error_message", e.getMessage());
			resURL = "/res/error.jsp";
		} finally {
		}
		if(resURL != null){
			RequestDispatcher rdp = request.getRequestDispatcher(resURL);
			rdp.forward(request, response);
		}
	}
}
















