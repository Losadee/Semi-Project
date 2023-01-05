package com.itwillbs.review.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ReviewDAO {
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
	
	public int findCusNum(String id) {
		int cus_num = 0;
		
		try {
			con = getConnection();
			
			String sql = "select cus_num from customer where id = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()){
				cus_num = rs.getInt(cus_num);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cus_num;
	}
	
	public void insertReview(ReviewDTO dto) {
		
		System.out.println("ReviewDTO num :"+dto.getCus_num());
		System.out.println("ReviewDTO subject :"+dto.getRv_title());
		System.out.println("ReviewDTO content :"+dto.getRv_content());
		System.out.println("ReviewDTO date :"+dto.getRv_date());
		System.out.println("ReviewDTO rate :"+dto.getRv_rate());
		System.out.println("ReviewDTO readcount :"+dto.getRv_view());
		
		try {
			//1,2 메서드호출
			con=getConnection();
			//리뷰 글번호 구하기  가장 큰번호 +1 => 이번에 입력할 글번호
			String sql2="select max(rv_num) as max from rv_board";
			pstmt2 =con.prepareStatement(sql2);
			//4. 실행 => 결과 저장
			rs=pstmt2.executeQuery();
			//5. 결과접근 max(num)가져와서 +1 
			int rv_num = 0;
			if(rs.next()) {
				rv_num=rs.getInt("max")+1;
			}
			//3 sql구문 만들기
			String sql="insert into rv_board values(?,?,?,?,?,?,?)";
			pstmt =con.prepareStatement(sql);
			//게시판 글번호 
			pstmt.setInt(1, rv_num);
			pstmt.setInt(2, dto.getCus_num());
			pstmt.setString(3, dto.getRv_title());
			pstmt.setString(4, dto.getRv_content());
			pstmt.setTimestamp(5, dto.getRv_date());
			pstmt.setInt(6, dto.getRv_rate());
			pstmt.setInt(7, dto.getRv_view());
			//4 sql구문 실행
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
}
