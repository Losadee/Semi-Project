package com.itwillbs.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.review.db.ReviewDAO;
import com.itwillbs.review.db.ReviewDTO;

public class ReviewUpdateForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//updateForm.jsp?num=1
				int num=Integer.parseInt(request.getParameter("num"));
				ReviewDAO dao=new ReviewDAO();

				ReviewDTO dto=dao.getRvBoard(num);
				
				// dto 가져가기
				request.setAttribute("dto", dto);
				
				// 이동
				ActionForward forward = new ActionForward();
				forward.setPath("./review/updateForm.jsp");
				forward.setRedirect(false);
				
				return forward;
	}

}
