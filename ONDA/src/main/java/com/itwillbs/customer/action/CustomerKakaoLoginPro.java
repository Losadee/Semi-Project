package com.itwillbs.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.customer.db.CustomerDAO;
import com.itwillbs.customer.db.CustomerDTO;

//import com.itwillbs.customer.db.CustomerDAO;
//import com.itwillbs.customer.db.CustomerDTO;

public class CustomerKakaoLoginPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String k_id = request.getParameter("k_id");
		String k_email = request.getParameter("k_email");
		
//		HttpSession session = request.getSession();
		
		CustomerDAO dao = new CustomerDAO();
		
		CustomerDTO dto = dao.userCheck(k_id);
		System.out.println("dto: " + dto);
		
		if (dto == null) {
			// 데이터 있으면 => true => "아이디 비밀번호 일치"
//			out.println("아이디 비밀번호 일치");
			// 페이지 상관없이 값이 유지 => 세션값 부여(저장)
			// session 내장객체생성
			dto = new CustomerDTO();
			
			dto.setId(k_id);
			dto.setEmail(k_email);
			dto.setKakao("Y");	// 카카오 회원 로그인가입이면 Y 입력
			
			dao.insertKaCustomer(dto);
			
		}
		
		HttpSession session = request.getSession();	// request에서 session값을 받아올 수 있다.
		
		session.setAttribute("id", k_id);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./CustomerMain.cu");
		forward.setRedirect(true);
		
		return forward;

	}

}
