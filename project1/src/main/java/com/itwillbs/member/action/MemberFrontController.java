package com.itwillbs.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// URI => 					  /Model2/insertForm.me
		String requestURI = request.getRequestURI();			// String 타입으로 리턴
		System.out.println("requestURI : " + requestURI);
// 프로젝트 명(Context명) => 	  /Model2
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath);
		System.out.println("contextPath 길이 : " + contextPath.length());
// 뽑은 가상주소		  =>			 /insertForm.me
		// 시작위치(contextPath길이)부터 끝까지 문자열을 잘라서 가져오기
		String strpath = requestURI.substring(contextPath.length());
		System.out.println("뽑은 주소 path : " + strpath);
				
		
		// 주소 비교
		// ActionForward 클래스, Action 인터페이스 파일 만들기
		ActionForward forward = null;
		Action action = null;
		
		if(strpath.equals("/MemberInsertForm.me")) {	
			forward = new ActionForward();
			forward.setPath("./member/insertForm.jsp");
			forward.setRedirect(false);
			
		} else if(strpath.equals("/MemberInsertPro.me")) {
			action = new MemberInsertPro();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}  else if(strpath.equals("/MemberPhoneCheck.me")) {
			forward = new ActionForward();
			forward.setPath("./member/phoneCheck.jsp");
			forward.setRedirect(false);
			
		} else if(strpath.equals("/MemberLoginForm.me")) {
			forward = new ActionForward();
			forward.setPath("./member/loginForm.jsp");
			forward.setRedirect(false);
			
		} else if(strpath.equals("/MemberLoginPro.me")) {
			action = new MemberLoginPro();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(strpath.equals("/MemberFinfId.me")) {
			forward = new ActionForward();
			forward.setPath("./member/findIdForm.jsp");
			forward.setRedirect(false);
			
		} else if(strpath.equals("/MemberFindIdPro.me")) {
			action = new MemberFindIdPro();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(strpath.equals("/MemberFindPw.me")) {
			forward = new ActionForward();
			forward.setPath("./member/findPwForm.jsp");
			forward.setRedirect(false);
			
		} else if(strpath.equals("/MemberFindPwPro.me")) {
			action = new MemberFindPwPro();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 이동 방법
		if(forward != null) {
			if(forward.isRedirect()) {
				// true : 주소 변경되면서 이동
				response.sendRedirect(forward.getPath());
			} else {
				// false : 주소 변경 없이 이동
				RequestDispatcher dis =  request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
}
