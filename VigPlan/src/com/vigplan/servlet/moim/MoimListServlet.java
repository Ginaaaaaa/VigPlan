package com.vigplan.servlet.moim;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vigplan.dao.moim.MDao;
import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.MVo;
import com.vigplan.vo.MemberVo;

@WebServlet("/moim")
public class MoimListServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		기본적으로 로그인 안된 사용자는 로그인 창으로 돌려보내기
		HttpSession session = req.getSession();
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
			if (authUser == null) {
				//	리다이렉트
				resp.sendRedirect(req.getContextPath() + "/member/login");
			} else {
				MDao dao = new MDao(dbuser, dbpass);
				List<MVo> list = dao.getAllmboard();
						
				req.setAttribute("list", list);
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/moim/mList.jsp");
				rd.forward(req, resp);
				
			}
		

	}

}
