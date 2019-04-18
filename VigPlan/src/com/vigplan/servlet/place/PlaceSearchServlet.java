package com.vigplan.servlet.place;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vigplan.vo.PlaceVo;

import api.NaverApi;


@WebServlet("/place/search")
public class PlaceSearchServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getParameter("a");
		String keyword = request.getParameter("keyword");

		if (keyword != null) {
			List<PlaceVo> list = NaverApi.searchPlace(keyword);
			request.setAttribute("list", list);
			System.out.println(list);
		
		} 
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/place/place_search.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
