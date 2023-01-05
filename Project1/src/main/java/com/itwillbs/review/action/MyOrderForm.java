package com.itwillbs.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyOrderForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		forward.setPath("./ReviewWriteForm.rv");
		forward.setRedirect(true);
		
		return forward;
	}

}
