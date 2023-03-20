package com.itwillbs.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.BoardDTO;


public class AdminQnaList implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDAO dao=new BoardDAO();
	
		int pageSize=10;
		System.out.println("pageSize="+pageSize);
		
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null){
			pageNum="1";
		}
		int currentPage=Integer.parseInt(pageNum);
		int startRow=(currentPage-1)*pageSize+1;
		int endRow=startRow+pageSize-1;
		
		List<BoardDTO> boardList = dao.getAdminQnaList(startRow,pageSize);
	
		int count = dao.getQnaCount();
		//readcount
		
		int pageBlock=3; 
		int startPage=(currentPage-1)/pageBlock*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		int pageCount = count/pageSize
                +(count%pageSize==0 ? 0 : 1);
		
		if(endPage > pageCount){
			endPage=pageCount;
		}
		request.setAttribute("boardList", boardList);
		
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("count", count);
		
		ActionForward forward=new ActionForward();
		forward.setPath("./board/adminQnaList.jsp");
		forward.setRedirect(false);
		return forward;
		}
	}
