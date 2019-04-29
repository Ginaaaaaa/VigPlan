package com.vigplan.servlet.place;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.KakaoApiVo;

import api.KakaoApi;


@WebServlet("/place/search")
public class PlaceSearchServlet extends BaseServlet {
	private static int DISPLAY_COUNT = 10;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getParameter("a");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		String keyword = request.getParameter("keyword");
		System.out.println("[" + keyword + "]");
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		
//		Integer npage = page == null ? 1: Integer.valueOf(page);
//		Integer nsize = size == null ? DISPLAY_COUNT : Integer.valueOf(size);
		
//		request.setAttribute("nSize", nsize);
//		request.setAttribute("nPage", npage);
		
		if (keyword != null) {
			List<KakaoApiVo> list = KakaoApi.searchPlace(keyword );
			request.setAttribute("list", list);
			System.out.println(list);
		
		} 
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/place/place_search.jsp");
//		rd.forward(request, response);
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
