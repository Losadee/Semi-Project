package com.itwillbs.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.board.db.BoardDAO;


public class AdminQnaDelete implements Action {
	
   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      int qna_num = Integer.parseInt(request.getParameter("qna_num"));
      
      BoardDAO dao=new BoardDAO();

      dao.deleteBoard(qna_num);

      ActionForward forward = new ActionForward();
      forward.setPath("./AdminQnaList.bo");
      forward.setRedirect(true);
      return forward;

   }

}