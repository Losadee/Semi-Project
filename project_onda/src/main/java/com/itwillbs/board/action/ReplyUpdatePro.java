package com.itwillbs.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.BoardDTO;

public class ReplyUpdatePro implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		int num=Integer.parseInt(request.getParameter("qna_num"));
		String cus_id=request.getParameter("cus_id");
		String qna_title=request.getParameter("qna_title");
		String qna_content=request.getParameter("qna_content");

		BoardDTO dto=new BoardDTO();
		
		dto.setQna_num(num);
		dto.setCus_id(cus_id);
		dto.setQna_title(qna_title);
		dto.setQna_content(qna_content);

		BoardDAO dao=new BoardDAO();
		
		dao.updateBoard(dto);
		ActionForward forward=new ActionForward();
		forward.setPath("./ReplyList.bo");
		forward.setRedirect(true);
		return forward;
	}
}
