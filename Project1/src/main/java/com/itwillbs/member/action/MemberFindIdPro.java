package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;

public class MemberFindIdPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		MemberDAO dao = new MemberDAO();
		String id = dao.findId(name, phone);
		
		request.setAttribute("id", id);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./member/findIdPro.jsp");	
		forward.setRedirect(false);	
		
		return forward;
	}

}
