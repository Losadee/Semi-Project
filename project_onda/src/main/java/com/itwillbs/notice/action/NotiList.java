package com.itwillbs.notice.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.notice.db.NoticeDAO;
import com.itwillbs.notice.db.NoticeDTO;


public class NotiList implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NoticeDAO dao=new NoticeDAO();

		int pageSize = 10;
		
		String pageNum=request.getParameter("pageNum");
		if(pageNum == null){
			pageNum = "1";
		}
		
		int currentPage=Integer.parseInt(pageNum);
		int startRow=(currentPage-1)*pageSize+1;
		int endRow = startRow + pageSize-1;

		List<NoticeDTO> boardList = dao.getBoardList(startRow, pageSize);

		int count = dao.getBoardCount();
		int pageBlock = 3; 
		int startPage=(currentPage-1)/pageBlock*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		int pageCount = count/pageSize
		                +(count%pageSize==0 ? 0 : 1);
		
		if(endPage > pageCount){
			endPage=pageCount;
		}
		
		
		request.setAttribute("boardList",boardList);
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		
		ActionForward forward=new ActionForward();
		forward.setPath("./notice/list.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
