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


//	TODO: 서블릿 요청을 만들고(extends BaseServlet 구조)
//	TODO: 데이터 접속부는 모두 DAO로 추출
@SuppressWarnings("serial")
@WebServlet("/member/login")
public class LoginServlet extends BaseServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String action = request.getParameter("a");
			
		if (action == null) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/login_form.jsp");
			rd.forward(request, response);
			} else if ("success".equals(action)){	//	/member/login?a=success
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/login_success.jsp");
				rd.forward(request, response);
			} else if ("fail".equals(action)) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/login_fail.jsp");
				rd.forward(request, response);
			}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 1. 요청 파라미터 조회
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("pw");
//		String nickname = request.getParameter("nickname");
//		String email = request.getParameter("email");
		
		/*
		ResultSet rs = null;
		String sql = "select id, password, nickname, email, rDate from member where id=?";
		
		HttpSession session = request.getSession();
		*/
		MemberDao dao = new MemberDao(dbuser, dbpass);
		
		MemberVo vo = dao.getMember(id, password);
		System.out.println("LOGIN: VO = " + vo);
		if (vo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("authUser", vo);
			
			//	TODO: 로그인 성공 페이지로 리다이렉트
			response.sendRedirect(request.getContextPath() + "/member/login?a=success");
		} else {
//			TODO: 실패 -> login 페이지로 리다이렉트
			response.sendRedirect(request.getContextPath() + "/member/login?a=fail");
		}
		
//		session.setAttribute("id", "pw");

		/*
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
		*/
	}
}

















