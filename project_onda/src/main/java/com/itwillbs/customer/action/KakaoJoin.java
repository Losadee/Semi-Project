package com.itwillbs.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.customer.db.CustomerDAO;
import com.itwillbs.customer.db.CustomerDTO;


public class KakaoJoin implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		request.setCharacterEncoding("utf-8");

		String cus_id = request.getParameter("cus_id");
		String cus_pass = request.getParameter("cus_pass");
		String cus_name = request.getParameter("cus_name");
		String cus_email = request.getParameter("cus_email");
		
		CustomerDTO dto = new CustomerDTO();
		dto.setCus_id(cus_id);
		dto.setCus_email(cus_pass);
		dto.setCus_name(cus_name);
		dto.setCus_email(cus_email);

		CustomerDAO dao = new CustomerDAO();
		
		dao.KinsertCustomer(dto);

		ActionForward forward=new ActionForward();
		forward.setPath("./CustomerLoginForm.cu");
		forward.setRedirect(true);
		
		return forward;
		
	}
	
}
