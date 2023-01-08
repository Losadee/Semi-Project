package com.itwillbs.customer.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.customer.db.CustomerDAO;
import com.itwillbs.customer.db.CustomerDTO;

public class CustomerList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id==null) {
			// 세션값이 없으면
			response.sendRedirect("CustomerLogin.cu");
		} else if(! (id.equals("admin"))) {
			// 세션값이 있으면 => admin 아니면 => main.jsp
			response.sendRedirect("CustomerMain.cu");
			
		}
		
		CustomerDAO dao = new CustomerDAO();

		List<CustomerDTO> customerList =dao.getCustomerList();
		
		// MemberDTO 정보를 request 담아서 오기
		request.setAttribute("customerList", customerList);

		ActionForward forward=new ActionForward();
		forward.setPath("./customer/list.jsp");
		forward.setRedirect(false);
		return forward;
	}

	
}
