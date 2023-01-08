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
		String cus_id = request.getParameter("id");
		String rv_title = request.getParameter("subject");
		String rv_content =request.getParameter("content");
		int rv_star = Integer.parseInt(request.getParameter("star"));
		String menu_name = request.getParameter("menu");
		
		ReviewDAO dao = new ReviewDAO();
		
		// menu_name을 이용한 menu_num 가져오기 	
		// TODO : menu_num 주문 목록에서 request로 담아오도록 수정할 것
		int menu_num = dao.findMenuNum(menu_name);
//		System.out.println("menu_num : " + menu_num);
		ReviewDTO dto = new ReviewDTO();
		
		dto.setCus_id(cus_id);
		dto.setRv_title(rv_title);
		dto.setRv_content(rv_content);
		// 현시스템 날짜시간
		dto.setRv_date(new Timestamp(System.currentTimeMillis()));
		dto.setRv_star(rv_star);
		//조회수 0 설정
		dto.setRv_view(0);
		// 글번호 num => BoardDAO에서 작업
		if(menu_num != 0) {
			dto.setMenu_num(menu_num);
		}
		
		
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
