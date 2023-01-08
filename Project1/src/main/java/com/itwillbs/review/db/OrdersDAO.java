package com.itwillbs.review.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OrdersDAO {
	Connection con = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	// getConnection() : DB 연결 메서드
	public Connection getConnection() throws Exception {
		Context init = new InitialContext();
		// 자원의 이름(name) 호출("자원의 위치/자원의 이름")
		// import javax.sql.DataSource;
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/Mysql");
		// con에 저장 (DataSource -> Connection)
		con = ds.getConnection();

		return con; // 연결정보를 리턴
	}
	
	// close() : 마무리 작업 메서드
	public void close() {
		//마무리=> 내장객체 => 기억장소 해제
		// con pstmt pstmt2 rs => 기억장소 해제
		if(rs!=null) try{rs.close();}catch(SQLException ex) {}
		if(pstmt2!=null) try{pstmt2.close();}catch(SQLException ex) {}
		if(pstmt!=null) try{pstmt.close();}catch(SQLException ex) {}
		if(con!=null) try{con.close();}catch(SQLException ex) {}
	}
	
	public String findMenu(String cus_id) {
		String menu_name = "";
		try {
			con = getConnection();
			
			// 
			String sql = "select m.menu_name from orders o join menu m \r\n"
					+ "on o.menu_num = m.menu_num where o.cus_id = ?;";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, cus_id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				menu_name = rs.getString("menu_name");
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return menu_name;
	}
	
}
