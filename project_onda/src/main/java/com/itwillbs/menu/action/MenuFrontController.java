package com.itwillbs.menu.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenuFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 주소 매핑

		// 가상주소 임의로 뽑아오기 => http://localhost:8080/Model2/insertForm.me
		// toString: 정보 문자열로 전환 -> 전체 주소를 가져옴
		String requestURL = request.getRequestURL().toString();
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String strpath = request.getServletPath();
		// 주소비교
		Action action=null;
		ActionForward forward=null;
		
		if(strpath.equals("/MenuInsertForm.mn")) {
			forward=new ActionForward();
			forward.setPath("./menu/insertForm.jsp");
			forward.setRedirect(false);
			
		}else if(strpath.equals("/MenuInsertPro.mn")) {
			action=new MenuInsertPro();
			try {forward = action.execute(request, response);} catch (Exception e) {e.printStackTrace();}
			
		} else if (strpath.equals("/MenuDelete.mn")) {
			action= new MenuDelete();
			try {forward = action.execute(request, response);} catch (Exception e) {e.printStackTrace();}	
		
		}else if (strpath.equals("/MenuBoardList.mn")) {
			action=new MenuBoardList();
			try {forward = action.execute(request, response);} catch (Exception e) {e.printStackTrace();}
			
		}else if(strpath.equals("/MenuUpdateForm.mn")) {
			action=new MenuUpdateForm();
			try {forward = action.execute(request, response);} catch (Exception e) {e.printStackTrace();}
			
		}else if(strpath.equals("/MenuUpdatePro.mn")) {
			action=new MenuUpdatePro();
			try {forward = action.execute(request, response);} catch (Exception e) {e.printStackTrace();}		
			
		}else if(strpath.equals("/MenuDelete.mn")) {
			action=new MenuDelete();
			try {forward = action.execute(request, response);} catch (Exception e) {e.printStackTrace();}			
			
		} else if(strpath.equals("/MenuDetailPage.mn")) {
			forward=new ActionForward();
			forward.setPath("./menu/mainMenu.jsp");
			forward.setRedirect(false);
			
		} else if(strpath.equals("/CoffeeList.mn")) {
			action=new coffeeList();
			try {forward = action.execute(request, response);} catch (Exception e) {e.printStackTrace();}		
		
		}else if(strpath.equals("/FoodList.mn")) {
			action=new FoodList();
			try {forward = action.execute(request, response);} catch (Exception e) {e.printStackTrace();}
		
		}else if(strpath.equals("/VeberageList.mn")) {
			action=new veberageList();
			try {forward = action.execute(request, response);} catch (Exception e) {e.printStackTrace();}
		
		} else if(strpath.equals("/MainMenu.mn")) {
			forward=new ActionForward();
			forward.setPath("./menu/mainMenu.jsp");
			forward.setRedirect(false);
		} 
			
		
//		이동 (-> (request)정보가 있으면 이동)
			if(forward != null) {
				if(forward.isRedirect()) {
					
					// true : 주소변경 되면서 이동
					System.out.println("true:"+ forward.getPath() +" sendRedirect() 이동");
					response.sendRedirect(forward.getPath());
				} else {
					
					// false : 주소변경 안되면서 이동
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