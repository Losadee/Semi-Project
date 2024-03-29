package com.itwillbs.customer.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.customer.db.CustomerDAO;
import com.itwillbs.customer.db.CustomerDTO;

public class CustomerPhoneCheck implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String cus_phone = request.getParameter("cus_phone");
		
		CustomerDAO dao = new CustomerDAO();
		CustomerDTO dto = dao.phoneCheck(cus_phone);
		
		String result="";
		
		if(dto==null) {
			// 아이디 없음, 사용가능
			result="true";
		} else {
			// 아이디 있음, 사용불가능
			result="false";
		}
		
		// 웹으로 출력 => ajax 되돌아감
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print(result);
		out.close();	
		
		return null;


		
	}
	
	
}
