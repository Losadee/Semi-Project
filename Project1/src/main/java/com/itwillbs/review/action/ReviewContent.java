package com.itwillbs.review.action;

import java.util.Map;

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
		
		Map<String, Object> param = dao.getRvBoard(num);	
//		String menu = dao.findMenu(dto.getMenu_num());	
		// TODO getparmeter로 ㅁㅔ뉴 이름 받아오기
		
		// dto 담기
		request.setAttribute("dto", param.get("dto"));
		request.setAttribute("menu", param.get("menu"));
		
		// 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./review/content.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
