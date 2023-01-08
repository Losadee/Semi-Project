package com.itwillbs.review.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ReviewFrontController extends HttpServlet {
	
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
		
		if(strpath.equals("/ReviewWriteForm.rv")) {	
			forward = new ActionForward();
			forward.setPath("./review/writeForm.jsp");
			forward.setRedirect(false);
			
		} else if(strpath.equals("/MyOrderForm.rv")) {	
			forward = new ActionForward();
			forward.setPath("./review/myOrders.jsp");
			forward.setRedirect(false);
			
		} else if(strpath.equals("/ReviewWritePro.rv")) {	
			action = new ReviewWritePro();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(strpath.equals("/ReviewList.rv")) {	
			action = new ReviewList();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(strpath.equals("/ReviewContent.rv")) {	
			action = new ReviewContent();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(strpath.equals("/ReviewUpdateForm.rv")) {	
			action = new ReviewUpdateForm();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(strpath.equals("/ReviewUpdatePro.rv")) {	
			action = new ReviewUpdatePro();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(strpath.equals("/ReviewDelete.rv")) {	
			action = new ReviewDelete();
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
