package com.itwillbs.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.customer.db.CustomerDAO;

public class CustomerFindIdPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String cus_name = request.getParameter("cus_name");
		String cus_phone = request.getParameter("cus_phone");
		
		CustomerDAO dao = new CustomerDAO();
		String cus_id = dao.findId(cus_name, cus_phone);
		
		request.setAttribute("cus_id", cus_id);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./customer/findIdPro.jsp");	
		forward.setRedirect(false);	
		
		return forward;
	}

}
