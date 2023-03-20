package com.itwillbs.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.customer.db.CustomerDAO;

public class CustomerFindPwPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String cus_id = request.getParameter("cus_id");
		String cus_name = request.getParameter("cus_name");
		String cus_phone = request.getParameter("cus_phone");
		
		CustomerDAO dao = new CustomerDAO();
		String pw = dao.findPw(cus_id, cus_name, cus_phone);
		
		request.setAttribute("cus_pass", pw);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./customer/findPwPro.jsp");	
		forward.setRedirect(false);	
		
		return forward;
	}

}
