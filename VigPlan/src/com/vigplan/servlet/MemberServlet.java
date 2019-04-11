package com.vigplan.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vigplan.dao.MemberDao;
import com.vigplan.vo.MemberVO;

@WebServlet("/member")
public class MemberServlet extends BaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String action = request.getParameter("a");
		
		if (action == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/register_form.jsp");
			rd.forward(request, response);
		} else if ("success".equals(action)) {
			//	가입 성공 VIEW JSP로 포워드
			request.getRequestDispatcher("/WEB-INF/views/member/register_success.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
//		String rDate = request.getParameter("rDate");
		
		//	TODO: ERROR 체크
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(password);
		vo.setNickname(nickname);
		vo.setEmail(email);
		
		MemberDao dao = new MemberDao(dbuser, dbpass);
		int result = dao.insertMember(vo);
		
		/*
		 * => DAO로 추출
		String sql = "insert into member values(?,?,?,?,?)";
		
		ServletContext sct = getServletContext();
		String url = sct.getInitParameter("url");
		String user = sct.getInitParameter("user");
		String DBPwd = sct.getInitParameter("password");
		
		MemberVO vo = new MemberVO(id, password, nickName, eMail, rDate);
		String resURL = null;
		
		try {
			Connection conn = DriverManager.getConnection(url, user, DBPwd);
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, nickName);
			preparedStatement.setString(4, eMail);
			preparedStatement.setString(5, rDate);
			int cnt = preparedStatement.executeUpdate();
			System.out.println(cnt + "개의 주소가 입력되었습니다.");
			request.setAttribute("mvo", vo);
			resURL = "/res/register_success.jsp";
			// RequestDispatcher rdp = request.getRequestDispatcher("/res/regiset_success.jsp");
			// rdp.forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("error_message", e.getMessage());
			resURL = "/res/error.jsp";		
			// RequestDispatcher rdp = request.getRequestDispatcher("/res/error.jsp");
			// rdp.forward(request, response);
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher(resURL);
			rd.forward(request, response);
		}
		*/
		//	가입 절차 완료 -> /member?a=success 리다이렉트
	}
	
}





