package com.vigplan.servlet.place;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vigplan.dao.moim.MDao;
import com.vigplan.dao.place.PlaceDao;
import com.vigplan.servlet.BaseServlet;
import com.vigplan.vo.MVo;
import com.vigplan.vo.PlaceVo;

@WebServlet("/place")
public class PlaceServlet extends BaseServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		

		String action = req.getParameter("a");


		if (action == null) {
			String mNo = req.getParameter("mNo");
			PlaceDao listdao = new PlaceDao(dbuser, dbpass);
			MDao dao = new MDao(dbuser, dbpass);
			List<PlaceVo> list = listdao.getMyPlace(Long.valueOf(mNo));
			//	moim 넘기기? -> mNo로 moim 받아와서 -> setAttribute 해야
			MVo moim = new MVo();
			moim = dao.selectOne(Long.valueOf(mNo));	
			req.setAttribute("list", list);
			req.setAttribute("moim", moim);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/place/place_main.jsp");
//			rd.forward(req, resp);
			rd.include(req, resp);

		} else if ("form".equals(action)) {
			String mNo = req.getParameter("mNo");
			
			MDao dao = new MDao(dbuser, dbpass);
			
			MVo moim = new MVo();
			moim = dao.selectOne(Long.valueOf(mNo));
			req.setAttribute("moim", moim);
			
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/place/place_form.jsp");
			rd.forward(req, resp);
		} else if("content".equals(action)) {
				String pk = req.getParameter("pk");
				String mNo = req.getParameter("mNo");
				
				PlaceDao placedao = new PlaceDao(dbuser, dbpass);
				MDao dao = new MDao(dbuser, dbpass);
				
				PlaceVo contentvo = placedao.getPlaceItem(Long.valueOf(pk));
				req.setAttribute("item", contentvo);
				
				MVo moim = new MVo();
				moim = dao.selectOne(Long.valueOf(mNo));	
				req.setAttribute("moim", moim);
				
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/place/place_content.jsp");
				rd.forward(req, resp);		
				
			} 
		}

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("a");
		

		if ("insert".equals(action)) {
			
			String mNo = req.getParameter("mNo");
			String title = req.getParameter("title");
			String link = req.getParameter("link");
			String description = req.getParameter("description");
			String telephone = req.getParameter("telephone");
			String address = req.getParameter("address");
			String roadAddress = req.getParameter("roadAddress");
			String mapx = req.getParameter("mapx");
			String mapy = req.getParameter("mapy");

			PlaceVo insertvo = new PlaceVo();
			MVo insertMvo = new MVo();
			insertMvo.setmNo(Long.valueOf(mNo));
			
			insertvo.setTitle(title);
			insertvo.setLink(link);
			insertvo.setDescription(description);
			insertvo.setTelephone(telephone);
			insertvo.setAddress(address);
			insertvo.setRoadAddress(roadAddress);
			insertvo.setMapx(Integer.valueOf(mapx));
			insertvo.setMapy(Integer.valueOf(mapy));

			

			PlaceDao insertdao = new PlaceDao(dbuser, dbpass);
			insertdao.insertPlace(insertvo);
			insertdao.insertbridge(insertMvo);
//			req.setAttribute("mNo", moimNo);
			resp.sendRedirect(req.getServletContext().getContextPath() + "/moim/select?mNo=" + mNo);
			

		}  else if("edit".equals(action)) {
			String pk = req.getParameter("pk");
			PlaceDao dao = new PlaceDao(dbuser, dbpass);
			PlaceVo vo = dao.getPlaceItem(Long.valueOf(pk));
			System.out.println(vo);
			req.setAttribute("item", vo);
			
			MVo mvo = new MVo();
			
			
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/place/place_edit.jsp");
			rd.forward(req, resp);	
			
		} else if("editer".equals(action)) {
		  PlaceDao editdao = new PlaceDao(dbuser,dbpass);
		  
		  String pk = req.getParameter("pk");
		  String title = req.getParameter("title");
		  String link = req.getParameter("link");
		  String description = req.getParameter("description");
		  String telephone = req.getParameter("telephone");
		  String address = req.getParameter("address");
		  String roadAddress = req.getParameter("roadAddress");
		  String mapx = req.getParameter("mapx");
		  String mapy = req.getParameter("mapy");
		  
		  PlaceVo editvo = editdao.getPlaceItem(Long.valueOf(pk));
		  MVo mvo = editdao.selectbridge(Long.valueOf(pk));
		  Long mNo = mvo.getmNo();
		  
		  
		  if (title == null || title.length() == 0) {
				title = editvo.getTitle();
			}
			if (link == null || link.length() == 0) {
				link = editvo.getTitle();
			}
			if (description == null || description.length() == 0) {
				description = editvo.getDescription();
			}
			if (telephone == null || telephone.length() == 0) {
				telephone = editvo.getTelephone();
			}
			if (address == null || address.length() == 0) {
				address = editvo.getAddress();
			}
			if (roadAddress == null || roadAddress.length() == 0) {
				roadAddress = editvo.getRoadAddress();
			}
			if (mapx == null || mapx.length() == 0) {
				mapx = String.valueOf(editvo.getMapx());
				editvo.setMapx(Integer.valueOf(mapx));
				
			}
			if (mapy == null || mapy.length() == 0) {
				mapy = String.valueOf(editvo.getMapy());
				editvo.setMapy(Integer.valueOf(mapy));
			}
			
			
			editvo.setPk(Long.valueOf(pk));
			editvo.setTitle(title);
			editvo.setLink(link);
			editvo.setDescription(description);
			editvo.setTelephone(telephone);
			editvo.setAddress(address);
			editvo.setRoadAddress(roadAddress);
			editvo.setMapx(Integer.valueOf(mapx));
			editvo.setMapy(Integer.valueOf(mapy));
			
			
		  int result = editdao.updatePlace(editvo);
		  
		  MVo vo = new MVo();
		  vo = editdao.selectbridge(Long.valueOf(pk));

		  resp.sendRedirect(req.getServletContext().getContextPath() + "/moim/select?mNo=" + mNo);
		  
			
		} else if("delete".equals(action)) {
			String pk = req.getParameter("pk");
			String mNo = req.getParameter("mNo");
			PlaceVo deletevo = new PlaceVo();
			
			
			deletevo.setPk(Long.valueOf(pk));
			
			PlaceDao deletedao = new PlaceDao(dbuser,dbpass);
			MVo vo = new MVo();
			vo = deletedao.selectbridge(Long.valueOf(pk));
			
			int result = deletedao.deletebridge(Long.valueOf(pk));

		   resp.sendRedirect(req.getServletContext().getContextPath() + "/moim/select?mNo=" + mNo);
			
		}

	}

}