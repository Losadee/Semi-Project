package com.itwillbs.review.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.review.db.ReviewDAO;

public class MyReviewList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		String cus_id = (String) session.getAttribute("cus_id");

		
		ReviewDAO dao = new ReviewDAO();
		
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		List<Map<String, Object>> reviewList = dao.getMyReviewList(cus_id, startRow, pageSize);
		// TODO : menu 이름 가져오기
		
		int count = dao.getMyRvBoardCount(cus_id);
		System.out.println("count=" + count);
		
		// 페이징 처리
		int pageBlock = 3;
		int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;
		int pageCount = count / pageSize + ((count % pageSize != 0) ? 1 : 0);
		
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("count", count);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./review/myReview.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
