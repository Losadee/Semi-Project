package com.itwillbs.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.BoardDTO;

public class MyQnaList implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int pageSize = 10;
		
		String pageNum = request.getParameter("pageNum");
		String cus_id = (String)session.getAttribute("cus_id");
				
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1) * pageSize+1;
		int endRow = startRow + pageSize-1;
		
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> myQnaList = dao.getMyQnaList(cus_id, startRow, pageSize);
		
		// 한페이지 10개 페이지 번호 보이게 설정
		int count = dao.getMyCount(cus_id);
		
		int pageBlock = 3;
		int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;
		int pageCount = count / pageSize + ((count % pageSize != 0) ? 1 : 0);
		
		if(endPage > pageCount) {
			endPage = pageCount;
		}

		request.setAttribute("myQnaList", myQnaList);
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("count", count);
		
		ActionForward forward=new ActionForward();
		forward.setPath("./board/myQnaList.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
