package com.itwillbs.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.review.db.ReviewDAO;
import com.itwillbs.review.db.ReviewDTO;


public class ReviewContent implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int num = Integer.parseInt(request.getParameter("num"));
		// 객체생성 기억장소 할당 => dao 기억장소 주소 저장
		ReviewDAO dao = new ReviewDAO();
		
		dao.updateReadcount(num);
		
		ReviewDTO dto = dao.getRvBoard(num);	
		
		// dto 담기
		request.setAttribute("dto", dto);
		
		// 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./review/content.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
