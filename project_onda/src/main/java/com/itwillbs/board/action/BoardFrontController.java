package com.itwillbs.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.res.action.AdminResDelete;
import com.itwillbs.res.action.AdminResList;

public class BoardFrontController extends HttpServlet{

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardFrontController doProcess()");
		//가상주소 뽑아오기
		String requestURI = request.getRequestURI();
		System.out.println("requestURI : " + requestURI);
		
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath);
		System.out.println("contextPath길이 : " + contextPath.length());
		
		String strpath=requestURI.substring(contextPath.length());
		System.out.println("뽑은 주소 strpath : "+strpath);
		
		ActionForward forward = null;
		Action action = null;
		
		if(strpath.equals("/BoardWriteForm.bo")) {
			forward = new ActionForward();
			forward.setPath("./board/writeForm.jsp");
			forward.setRedirect(false);
		}
		 else if(strpath.equals("/BoardWritePro.bo")) {
			action=new BoardWritePro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(strpath.equals("/BoardContent.bo")) {
			action=new BoardContent();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(strpath.equals("/BoardUpdateForm.bo")) {
			action=new BoardUpdateForm();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(strpath.equals("/BoardUpdatePro.bo")) {
			action=new BoardUpdatePro();
			
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(strpath.equals("/BoardDelete.bo")) {
			action=new BoardDelete();
			
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace(); }
			
		 } else if(strpath.equals("/MyQnaList.bo")) {
				action=new MyQnaList();
				try {
					forward=action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
		 }else if(strpath.equals("/MyContent.bo")) {
				action=new MyContent();
				try {
					forward=action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if(strpath.equals("/ReplyList.bo")) {
			action=new ReplyList();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		 } else if(strpath.equals("/ReplyForm.bo")) {
			 
			 	forward = new ActionForward();
				forward.setPath("./board/replyForm.jsp");
				forward.setRedirect(false); 
				
		 } else if(strpath.equals("/ReplyPro.bo")) {
				action=new ReplyPro();
				try {
					forward=action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
		 } else if(strpath.equals("/ReplyUpdateForm.bo")) {
				action=new ReplyUpdateForm();
				try {
					forward=action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
		 } else if(strpath.equals("/ReplyUpdatePro.bo")) {
				action=new ReplyUpdatePro();
				
				try {
					forward=action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}	
		} else if (strpath.equals("/AdminQnaList.bo")) { //관리자 문의내역 목록
				action = new AdminQnaList();
				try {forward=action.execute(request, response);
			} catch (Exception e) {e.printStackTrace();}	
			
			} else if (strpath.equals("/AdminQnaDelete.bo")) { //관리자 문의,답변삭제
				action = new AdminQnaDelete();
			try {forward=action.execute(request, response);
			} catch (Exception e) {e.printStackTrace();}		
				
			}
		
			//이동
		if(forward!=null) {
			if(forward.isRedirect()) {
				//true : 주소변경 되면서 이동
				System.out.println("true:"+ forward.getPath() +"sendRedirect() 이동");
				response.sendRedirect(forward.getPath());
			}else {
				//false : 주소변경 안되면서 이동
				System.out.println("false:"+ forward.getPath() +"foward() 이동");
				RequestDispatcher dis
				=request.getRequestDispatcher(forward.getPath());
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
