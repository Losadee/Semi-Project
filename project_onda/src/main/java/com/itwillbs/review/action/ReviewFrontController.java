package com.itwillbs.review.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ReviewFrontController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();			
		String contextPath = request.getContextPath();
		String strpath = requestURI.substring(contextPath.length());
		
		ActionForward forward = null;
		Action action = null;
		
		if(strpath.equals("/ReviewWriteForm.rv")) {	
			forward = new ActionForward();
			forward.setPath("./review/writeForm.jsp");
			forward.setRedirect(false);
			
		} else if(strpath.equals("/AdminReviewList.rv")) {	
			action = new AdminReviewList();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
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
		} else if(strpath.equals("/MyReviewList.rv")) {	
			action = new MyReviewList();
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
			
		} else if(strpath.equals("/AdminReviewDelete.rv")) {	
			action = new AdminReviewDelete();
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
