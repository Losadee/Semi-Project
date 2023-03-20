package com.itwillbs.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.review.db.ReviewDAO;
import com.itwillbs.review.db.ReviewDTO;

public class ReviewUpdatePro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// request 한글처리
				request.setCharacterEncoding("utf-8");
				// request 정보 가져오기
				int rv_num = Integer.parseInt(request.getParameter("num"));
				String rv_title = request.getParameter("rv_title");
				String rv_content = request.getParameter("rv_content");
				int rv_star = Integer.parseInt(request.getParameter("star"));

				ReviewDTO dto=new ReviewDTO();
				// set메서드호출 num name subject content 저장
				dto.setRv_num(rv_num);
				dto.setRv_title(rv_title);
				dto.setRv_content(rv_content);
				dto.setRv_star(rv_star);
				
				// 수정작업
				ReviewDAO dao=new ReviewDAO();
				
				dao.updateRvBoard(dto);
				
				ActionForward forward=new ActionForward();
				forward.setPath("./ReviewList.rv");
				forward.setRedirect(true);
				return forward;
		
	}

}
