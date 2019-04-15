package com.vigplan.servlet.place;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vigplan.dao.place.PlaceDao;
import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.PlaceVo;

@WebServlet("/place")
public class PlaceServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String action = req.getParameter("a");
		
		if(action == null) {
			PlaceDao dao = new PlaceDao(dbuser, dbpass);
			
			List<PlaceVo> list = dao.getAllLogs();
			System.out.println(list);
			
			req.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/place/place_main.jsp");
			rd.forward(req, resp);
		}
	}

	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	}





}
