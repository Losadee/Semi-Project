package com.itwillbs.review.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.review.db.ReviewDAO;
import com.itwillbs.review.db.ReviewDTO;

public class ReviewUpdateForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//updateForm.jsp?num=1
		int rv_num = Integer.parseInt(request.getParameter("num"));
		ReviewDAO dao=new ReviewDAO();
		
		Map<String, Object> param =dao.getRvBoard(rv_num);
		
		// dto, menu 저장
		request.setAttribute("dto", param.get("dto"));
		request.setAttribute("menu", param.get("menu"));
		
		// 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./review/updateForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
