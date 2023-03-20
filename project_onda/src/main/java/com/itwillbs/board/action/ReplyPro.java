package com.itwillbs.board.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.BoardDTO;

public class ReplyPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
        
        BoardDAO dao = new BoardDAO();
        BoardDTO dto  = new BoardDTO();
        
        request.setCharacterEncoding("utf-8");
        // 답글 작성 후 원래 페이지로 돌아가기 위해 페이지 번호가 필요하다.
//        String pageNum = request.getParameter("page");
        String cus_id = request.getParameter("cus_id");
        String qna_title = request.getParameter("qna_title");
        String qna_content = request.getParameter("qna_content");
        int qna_num=Integer.parseInt(request.getParameter("qna_num"));
        Timestamp qna_reg = new Timestamp(System.currentTimeMillis());
        
        // 답글
        int qna_ref = Integer.parseInt(request.getParameter("qna_ref"));
        int qna_re_lev = Integer.parseInt(request.getParameter("qna_re_lev"));
        int qna_re_seq = Integer.parseInt(request.getParameter("qna_re_seq"));
        
        // 답글 저장
        dto.setQna_num(qna_num); 
        dto.setCus_id(cus_id);
        dto.setQna_title(qna_title);
        dto.setQna_content(qna_content);
        dto.setQna_ref(qna_ref);
        dto.setQna_re_lev(qna_re_lev);
        dto.setQna_re_seq(qna_re_seq);
        dto.setQna_reg(qna_reg);
        
        dao.replyBoard(dto);
        
        forward.setPath("./ReplyList.bo");
		forward.setRedirect(true);
		return forward;
	}
	

}
