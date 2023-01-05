package com.itwillbs.review.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.review.db.ReviewDAO;
import com.itwillbs.review.db.ReviewDTO;

public class ReviewList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 사용 => BoardDAO 기억장소 할당(객체생성)
		ReviewDAO dao = new ReviewDAO();
		// List<BoardDTO> 리턴할형 getBoardList()메서드 정의

		// 한 화면에 보여줄 글 개수 설정 (10개 설정) -> 테스트 : 3으로 변경
		int pageSize = 3;
		System.out.println("pageSize=" + pageSize);
		// http://localhost:8080/JspProject/board/list.jsp
		// http://localhost:8080/jspProject/board/list.jsp?pageNum=1
		// 현 페이지 번호 파라미터값 가져오기
		String pageNum = request.getParameter("pageNum");
		// 페이지 번호가 없으면 => "1" 설정
		if(pageNum == null) {
			pageNum = "1";
		}
		System.out.println("pageNum=" + pageNum);
		// pageNum => 정수형 숫자 변경
		int currentPage = Integer.parseInt(pageNum);
		System.out.println("currentPage=" + currentPage);
		
		// 최근글 위로 정렬(num 기준으로 내림차순)
		// 구간값 가져오기 limit 시작행, 글개수
		// select * from board order by num desc limit 1,  10	(1행부터, 10개)
		// select * from board order by num desc limit 11, 10	(11행부터, 10개)
		// select * from board order by num desc limit 21, 10	(21행부터, 10개)
		// 시작행 알고리즘(계산식)으로 구하기
		// currentPage	pageSize	=>	startRow
		//		1		  10		=>	  0*10+1=>0+1=>1
		//		2		  10		=>	  1*10+1=>10+1=>11
		//		3		  10		=>	  2*10+1=>20+1=>21
		int startRow = (currentPage - 1) * pageSize + 1;
		System.out.println("startRow=" + startRow);
		
		// 끝행 알고리즘(계산식)으로 구하기
		// startRow		pageSize	=>	endRow
		//	  1		 	   10		=>	  10
		//	  11		   10		=>	  20
		//	  21		   10		=>	  30
		int endRow = startRow + pageSize - 1;
		System.out.println("endRow=" + endRow);

		// dao주소를 통해서 메서드 호출
		// 여러명을 저장하는 List 배열변수 = dao.getBoardList();
		// List<BoardDTO> boardList = dao.getBoardList();
		// 여러글을 저장하는 List배열변수 = dao.getBoardList(시작행, 글개수); => 메서드 수정
		List<ReviewDTO> reviewList = dao.getReviewList(startRow, pageSize);

		// 전체 게시판 글의 개수 알아보기
		// select count(*) from board;
		int count = dao.getReviewCount();
		System.out.println("count=" + count);
		
		
		// 페이징 처리
		// 한 화면에 보여줄 페이지 개수 설정
		int pageBlock = 3;
		// currentPage 	pageBlock =>  startPage
		// 1  ~ 10(0~9)    10     =>  0*10+1=> 1
		// 11 ~ 20(10~19)  10	  =>  1*10+1=> 11
		// 21 ~ 30(20~29)  10	  =>  2*10+1=> 21
		int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;
		System.out.println("startPage=" + startPage);
		// startPage  pageBlock	 =>	 endRow
		// 	 1 	     	 10		 =>	   10
		// 	 11     	 10		 =>	   20
		//	 21 	     10		 =>	   30
		int endPage = startPage + pageBlock - 1;
		// 글이 있는 페이지만 보이기 1~10 => 1~2
		// 전체 페이지 개수 구하기
		// 20개 글 / 10 글개수 나머지 0 => 2 페이지 + 나머지 없으면 0
		// 15개 글 / 10 글개수 나머지 5 => 1 페이지 + 나머지 있으면 1
		int pageCount = count / pageSize + ((count % pageSize != 0) ? 1 : 0);
		System.out.println("pageCount=" + pageCount);
		// endPage 수정
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		System.out.println("endPage=" + endPage);
		
		// 데이터를 request에 담아서 list.jsp 이동 
		// boardList (boardList에 필요한 값들이 저장되있음)
		request.setAttribute("reviewList", reviewList);
		// + a (startPagge pageBlock currentPage endPage pageCount count)
		// 위 값들을 따로 담아가도 되고 한번에 가져가도 됨
		// 따로 담아가는 방법
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("count", count);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./review/list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
