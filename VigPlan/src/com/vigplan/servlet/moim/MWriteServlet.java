package com.vigplan.servlet.moim;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vigplan.dao.group.GroupDao;
import com.vigplan.dao.moim.MDao;
import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.GroupVo;
import com.vigplan.vo.MVo;
import com.vigplan.vo.MemberVo;

@WebServlet("/moim/write")
public class MWriteServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("moim write : do get");
	
	HttpSession session = request.getSession();
	MemberVo authUser = (MemberVo)session.getAttribute("authUser");
	
	System.out.println("현재사용자:" + authUser);
	
	//	기본적으로 로그인 안된 사용자는 로그인 창으로 돌려보내기
	if (authUser == null) {
		//	리다이렉트
		response.sendRedirect(request.getContextPath() + "/member/login");
		} else {
	String gNo = request.getParameter("gNo");
	GroupDao dao = new GroupDao(dbuser, dbpass);
	GroupVo gvo = dao.selectOne(Long.valueOf(gNo));
	request.setAttribute("group", gvo);
	request.setAttribute("gno", gNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/moim/mWriteForm.jsp");
		rd.forward(request, response);
	}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String mTitle = req.getParameter("mTitle"); 
		String mDate = req.getParameter("mDate"); 
		String mPlace = req.getParameter("mPlace");
		String mContent = req.getParameter("mContent");
		String gNo = req.getParameter("gNo");
		
		System.out.println("doPost");
		
		resp.setContentType("text/html);charset=UTF-8"); 
		resp.setCharacterEncoding("UTF-8"); 

		GroupVo gvo = new GroupVo();
		gvo.setgNo(Long.valueOf(gNo));
		
		MVo vo = new MVo(); 
		vo.setmTitle(mTitle);
		vo.setmDate(mDate);
		vo.setmPlace(mPlace);
		vo.setmContent(mContent);

		MDao dao = new MDao(dbuser, dbpass);
		int i = dao.insertmBoard(vo);
		dao.insertbridge2(gvo, vo);

		
		resp.sendRedirect(req.getContextPath() + "/group/select?gNo=" + gNo);
	}

}

