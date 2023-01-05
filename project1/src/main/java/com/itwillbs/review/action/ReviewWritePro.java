package com.itwillbs.review.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.review.db.ReviewDAO;
import com.itwillbs.review.db.ReviewDTO;

public class ReviewWritePro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		// request name,subject,content 파라미터 가져와서 변수에 저장
		String id = request.getParameter("id");
		String rv_title = request.getParameter("subject");
		String rv_content =request.getParameter("content");
		int rv_rate = Integer.parseInt(request.getParameter("star"));
		
		ReviewDAO dao = new ReviewDAO();
		// id를 이용하여 cus_num 가져오는 메서드 만들기
		int cus_num = dao.findCusNum(id);
		
		ReviewDTO dto = new ReviewDTO();
		
		dto.setCus_num(cus_num);
		dto.setRv_title(rv_title);
		dto.setRv_content(rv_content);
		// 현시스템 날짜시간
		dto.setRv_date(new Timestamp(System.currentTimeMillis()));
		dto.setRv_rate(rv_rate);
		//조회수 0 설정
		dto.setRv_view(0);
		// 글번호 num => BoardDAO에서 작업

		// 리턴할형 없음 insertBoard(BoardDTO 주소값 저장하는 변수) 메서드 정의 
		// BoardDAO주소.insertBoard(BoardDTO 주소)메서드 호출
		dao.insertReview(dto);
		
		//글목록 이동
		ActionForward forward=new ActionForward();
		forward.setPath("./ReviewList.rv");
		forward.setRedirect(true);
		return forward;
		
	}

}
