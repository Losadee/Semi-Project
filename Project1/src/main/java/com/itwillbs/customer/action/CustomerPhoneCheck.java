package com.itwillbs.customer.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.customer.db.CustomerDAO;
import com.itwillbs.customer.db.CustomerDTO;

public class CustomerPhoneCheck implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String phone = request.getParameter("phone");
		System.out.println(phone);
		CustomerDAO dao = new CustomerDAO();
		CustomerDTO dto =dao.findPhone(phone);
		System.out.println(dto);
		String result = "true";
		if(dto != null) {
			result = "false";
		} 
		// 웹으로 출력 => ajax 되돌아감
		response.setContentType("text/html; charset=UTF-8");	// java파일을 이 형태로 변환
		PrintWriter out = response.getWriter();
		out.print(result);	// 결과 값 가지고 되돌아감
		out.close();
		return null;
	}

}
