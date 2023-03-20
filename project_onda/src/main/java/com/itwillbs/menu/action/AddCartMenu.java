package com.itwillbs.menu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.menu.db.MenuDAO;
import com.itwillbs.menu.db.MenuDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AddCartMenu implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uploadPath = request.getRealPath("/upload");
		System.out.println(uploadPath);
		
		int maxSize = 10*1024*1024;
		
		MultipartRequest multi 
				= new MultipartRequest(request, uploadPath, maxSize, "utf-8", new DefaultFileRenamePolicy()); 
		System.out.println("메뉴인설트 멀티");
		
		//파라미터 가져와서 변수에 저장
		String menu_name=multi.getParameter("menu_name");
		int menu_price=Integer.parseInt(multi.getParameter("menu_price"));
		String menu_img= multi.getFilesystemName("menu_img");
		int menu_num=Integer.parseInt(multi.getParameter("menu_num"));
		int cart_price=Integer.parseInt(multi.getParameter("cart_price"));
		int cart_count=Integer.parseInt(multi.getParameter("cart_count"));
		
		System.out.println("파라미터 변수저장");
		// set() get() 메서드 정의

		// BoardDTO객체생성(기억장소 할당)
		MenuDTO dto=new MenuDTO();
		// set메서드 호출 파라미터값 저장
	
		dto.setMenu_name(menu_name);
		dto.setMenu_price(menu_price);
		dto.setMenu_img(menu_img);
		

		// 패키지board 파일이름BoardDAO 자바 클래스 만들기
		// BoardDAO 객체생성(기억장소 할당)
		MenuDAO dao=new MenuDAO();
		// 리턴할형 없음 insertBoard(BoardDTO 주소값 저장하는 변수) 메서드 정의 
		// BoardDAO주소.insertBoard(BoardDTO 주소)메서드 호출
		dao.insertMenu(dto);
		System.out.println("메뉴 cartDB에 저장");
		ActionForward forward=new ActionForward();
		forward.setPath("./MenuBoardList.mn");
		forward.setRedirect(true);
		return forward;
	}

}
