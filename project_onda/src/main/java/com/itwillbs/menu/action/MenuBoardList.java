package com.itwillbs.menu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.menu.db.MenuDAO;
import com.itwillbs.menu.db.MenuDTO;


public class MenuBoardList implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		MenuDAO dao = new MenuDAO();

		int pageSize= 10;

		String pageNum = request.getParameter("pageNum");

		if(pageNum == null) {
			   pageNum = "1";
			}
		int currentPage = Integer.parseInt(pageNum);

		int startRow= (currentPage-1)*pageSize+1;
		int endRow = startRow+pageSize-1;

		List<MenuDTO> menuList = dao.getMenuList(startRow, pageSize);

		int count = dao.getMenuCount();
		int pageBlock=3;

		int startPage=(currentPage-1)/pageBlock*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		int pageCount = count/pageSize
                +(count%pageSize==0 ? 0 : 1);
		
		if(endPage > pageCount){
			endPage=pageCount;
		}
		request.setAttribute("menuList", menuList);
		// startPage, pageBlock, currentPage, endPage,  pageCount
		request.setAttribute("startPage",  startPage);
		request.setAttribute("pageBlock",  pageBlock);
		request.setAttribute("currentPage",currentPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		
//		이동정보 저장 => ./board/list.jsp
		ActionForward forward = new ActionForward();
		forward.setPath("./menu/menuAdminpage.jsp");
		forward.setRedirect(false);

		return forward;
	}
}
