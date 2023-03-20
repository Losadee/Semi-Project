package com.itwillbs.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.review.db.ReviewDAO;

public class AdminReviewDelete implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int rv_num = Integer.parseInt(request.getParameter("num"));

		ReviewDAO dao=new ReviewDAO();
		// 리턴할형없음 deleteBoard(int num)메서드 정의
		// 디비작업 주소를 통해서 deleteBoard(num) 호출
		dao.deleteBoard(rv_num);
		
		ActionForward forward=new ActionForward();
		forward.setPath("./AdminReviewList.rv");
		forward.setRedirect(true);
		return forward;
	}
}
