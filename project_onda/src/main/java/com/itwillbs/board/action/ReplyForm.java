package com.itwillbs.board.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.BoardDTO;

public class ReplyForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		BoardDAO dao = new BoardDAO();
        int num = Integer.parseInt(request.getParameter("num"));
        // 답글 작성 후 원래 페이지로 돌아가기 위해 페이지 번호가 필요하다.
//        String pageNum = request.getParameter("page");
        
        BoardDTO dto = dao.getBoard(num);
        request.setAttribute("dto", dto);
//        request.setAttribute("page", pageNum);
        
        ActionForward forward = new ActionForward();
        forward.setPath("./board/replyForm.jsp");
        forward.setRedirect(false); 
        return forward;
	}

}
