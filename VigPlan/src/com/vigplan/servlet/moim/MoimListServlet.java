package com.vigplan.servlet.moim;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vigplan.dao.moim.MDao;
import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.MVo;

@WebServlet("/moim")
public class MoimListServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MDao dao = new MDao(dbuser, dbpass);
		List<MVo> list = dao.getAllmboard();
		
		req.setAttribute("list", list);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/moim/mList.jsp");
		rd.forward(req, resp);
	}

}
