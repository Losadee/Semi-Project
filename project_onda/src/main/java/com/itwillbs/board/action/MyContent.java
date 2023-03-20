package com.itwillbs.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.BoardDTO;

public class MyContent implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
//		String qna_content = request.getParameter("qna_content");
		
		BoardDAO dao=new BoardDAO();
		
		dao.updateReadcount(num);
		
		BoardDTO dto = dao.getBoard(num); 
		request.setAttribute("dto", dto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./board/Mycontent.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
