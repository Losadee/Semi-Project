package com.itwillbs.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.customer.db.CustomerDAO;
import com.itwillbs.customer.db.CustomerDTO;

public class CustomerInsertPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request 한글처리
			request.setCharacterEncoding("utf-8");
			// 폼에 입력한 데이터 -> 서버 request 저장
			// id pass name 변수 파라미터값 가져와서 저장
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String birth = request.getParameter("birth");
			String email = request.getParameter("email");
			
			// MemberDAO 자바파일 => 객체생성(기억장소 할당)
			CustomerDAO dao = new CustomerDAO();
			
			// MemberDTO => 객체생성(기억장소 할당)
			CustomerDTO dto = new CustomerDTO();
			
			dto.setId(id);
			dto.setPass(pass);
			dto.setName(name);
			dto.setPhone(phone);
			dto.setBirth(birth);
			dto.setEmail(email);

			// dao.insertMember(id, pass, name, date);
			// dao.insertMember(memberDTO 주소);
			dao.insertCustomer(dto);
			
			// script로 회원가입 성공 alert창 띄우기
			ActionForward forward = new ActionForward();
			forward.setPath("./CustomerLoginForm.cu");	
			forward.setRedirect(true);	// 가상 주소니까 주소가 바뀌면서 이동해야하므로 true(response.sendRe~)
		
			return forward;
	}

}
