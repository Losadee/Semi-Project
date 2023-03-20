package com.itwillbs.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.customer.db.CustomerDAO;
import com.itwillbs.customer.db.CustomerDTO;

public class CustomerJoinPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//request 한글처리
		request.setCharacterEncoding("utf-8");

		// 폼에 입력한 데이터 => 서버request 저장
		// id pass name 변수 파라미터값 가져와서 저장
		String cus_id = request.getParameter("cus_id");
		String cus_pass = request.getParameter("cus_pass1");
		String cus_name = request.getParameter("cus_name");
		String cus_phone = request.getParameter("cus_phone");
		String cus_email = request.getParameter("cus_email");
		
		// package member, 파일이름 MemberDTO
		CustomerDTO dto = new CustomerDTO();
		// id,pass,name,date 변수 담기 => 변수 private 접근제한
		dto.setCus_id(cus_id);
		dto.setCus_pass(cus_pass);
		dto.setCus_name(cus_name);
		dto.setCus_phone(cus_phone);
		dto.setCus_email(cus_email);

		CustomerDAO dao = new CustomerDAO();
		
		// dao.insertMember(id, pass, name, date);
		dao.insertCustomer(dto);

		//리턴 이동할 주소로그인 페이지로 이동
		// ActionForward 객체 생성
		// 이동경로, 이동방식 담아서 리턴
		ActionForward forward=new ActionForward();
		forward.setPath("./CustomerLoginForm.cu");
		forward.setRedirect(true);
		
		return forward;
		
	}
	
}
