package com.itwillbs.customer.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.customer.db.CustomerDAO;
import com.itwillbs.customer.db.CustomerDTO;

public class CustomerInfo implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// String id = "id" 세션값 가져오기
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");

		CustomerDAO dao = new CustomerDAO();
		
		CustomerDTO dto = dao.getCustomer(id);
		
		// MemberDTO 정보를 request 담아서 오기
		request.setAttribute("dto", dto);

		ActionForward forward=new ActionForward();
		forward.setPath("./customer/info.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	
	
}
