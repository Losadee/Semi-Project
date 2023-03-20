package com.itwillbs.menu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.menu.db.MenuDAO;
import com.itwillbs.menu.db.MenuDTO;

public class veberageList implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		String menu_category = request.getParameter("menu_category");
	
		MenuDAO dao = new MenuDAO();
		
		List<MenuDTO> menuList =dao.MenuList(menu_category);

		request.setAttribute("menuList",menuList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./menu/veberageList.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
