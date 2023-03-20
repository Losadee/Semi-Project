package com.itwillbs.res.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.res.db.ReservationDAO;
import com.itwillbs.res.db.ReservationDTO;
import com.itwillbs.res.action.ActionForward;

public class AdminResList implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReservationDAO dao=new ReservationDAO();

		int pageSize=10;
		
		String pageNum=request.getParameter("pageNum");
		// 페이지 번호가 없으면 => "1" 설정
		if(pageNum==null){
			pageNum="1";
		}
		int currentPage=Integer.parseInt(pageNum);
		int startRow=(currentPage-1)*pageSize+1;
		int endRow=startRow+pageSize-1;
		
		List<ReservationDTO> reservationList =dao.getAdminReservationList(startRow,pageSize);
	
		int count=dao.getReservationCount2();
		int pageBlock=3; 
		int startPage=(currentPage-1)/pageBlock*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		int pageCount = count/pageSize
                +(count%pageSize==0 ? 0 : 1);
		
		if(endPage > pageCount){
			endPage=pageCount;
		}
		
		request.setAttribute("reservationList", reservationList);
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		
		ActionForward forward=new ActionForward();
		forward.setPath("./reservation/AdminResList.jsp");
		forward.setRedirect(false);
		return forward;
		}
	}
