package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberDAO;

public class MemberFindPwPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		MemberDAO dao = new MemberDAO();
		String pw = dao.findPw(id, name, phone);
		
		request.setAttribute("pass", pw);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./member/findPwPro.jsp");	
		forward.setRedirect(false);	
		
		return forward;
	}

}
