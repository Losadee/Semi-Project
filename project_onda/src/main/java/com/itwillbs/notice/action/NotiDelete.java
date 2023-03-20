package com.itwillbs.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.notice.db.NoticeDAO;

public class NotiDelete implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int num=Integer.parseInt(request.getParameter("num"));
		NoticeDAO dao=new NoticeDAO();
		
		dao.deleteBoard(num);
		
		ActionForward forward=new ActionForward();
		forward.setPath("./NotiList.no");
		forward.setRedirect(true);
		return forward;
	}
}
