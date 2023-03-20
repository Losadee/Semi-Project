package com.itwillbs.customer.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.customer.db.CustomerDAO;
import com.itwillbs.customer.db.CustomerDTO;

public class CustomerUpdatePro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");

		// 폼에서 입력한 파라미터값(id,pass,name)을 서버에 request에 저장
		// 변수 = request에 저장된 값 가져오기
		String cus_id = request.getParameter("cus_id");
		String cus_pass = request.getParameter("cus_pass");
		String cus_name = request.getParameter("cus_name");
		String cus_phone = request.getParameter("cus_phone");
		String cus_email = request.getParameter("cus_email");

		//MemberDAO 객체 생성
		CustomerDAO dao = new CustomerDAO();

		//MemberDTO dto =디비작업주소.userCheck(String id, String pass) 메서드 호출
		CustomerDTO dto=dao.userCheck(cus_id,cus_pass);

		//dto null이 아니면 =>"아이디 비밀번호 일치" => 수정, 메인이동
//		    null이면     => "아이디 비밀번호 틀림" => 뒤로이동

		if(dto!=null) {
		//  if 다음행이동=> 데이터 있으면 => true =>"아이디 비밀번호 일치"
			// 수정할 정보를 MemberDTO에 객체생성 set 호출 저장
			CustomerDTO dtoUpdate = new CustomerDTO();
			dtoUpdate.setCus_id(cus_id);
			dtoUpdate.setCus_pass(cus_pass);
			dtoUpdate.setCus_name(cus_name);
			dtoUpdate.setCus_phone(cus_phone);
			dtoUpdate.setCus_email(cus_email);

			// 리턴할형 없음 void updateMember(수정할정보) 메서드 정의
			dao.updateCustomer(dtoUpdate);
			
			//MemberMain.me 이동
			ActionForward forward=new ActionForward();
			forward.setPath("./CustomerMypage.cu");
			forward.setRedirect(true);
			return forward;
			
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>");
			out.print("alert('입력하신 정보 틀림');");
			out.print("history.back();");
			out.print("</script>");	
			out.close();	
			return null;
		}
		
		
	}

	
	
}
