package com.itwillbs.review.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	// 메뉴 번호 찾기
	public int findMenuNum(String menu_name) {
		int menu_num = 0;
		try {
			//1,2 메서드호출
			con=getConnection();
			//리뷰 글번호 구하기  가장 큰번호 +1 => 이번에 입력할 글번호
			String sql="select menu_num from menu where menu_name = ?";
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, menu_name);
			
			//4. 실행 => 결과 저장
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				menu_num = rs.getInt("menu_num");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return menu_num;
	}
	
	
	public void insertReview(ReviewDTO dto) {
		
		System.out.println("ReviewDTO id :"+dto.getCus_id());
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
			String sql="insert into rv_board values(?,?,?,?,?,?,?,?)";
			pstmt =con.prepareStatement(sql);
			//게시판 글번호 
			pstmt.setInt(1, rv_num);
			pstmt.setString(2, dto.getCus_id());
			pstmt.setString(3, dto.getRv_title());
			pstmt.setString(4, dto.getRv_content());
			pstmt.setTimestamp(5, dto.getRv_date());
			pstmt.setInt(6, dto.getRv_rate());
			pstmt.setInt(7, dto.getRv_view());
			pstmt.setInt(8, dto.getMenu_num());
			//4 sql구문 실행
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public List<ReviewDTO> getReviewList(int startRow, int pageSize) {
		List<ReviewDTO> reviewList = new ArrayList<>();

		try {
			// 1, 2 단계 DB연결
			con = getConnection();
			// 3단계 : sql구문
			String sql = "select * from rv_board order by rv_num desc limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			// 4단계 : sql구문 실행 , 실행결과 저장(select)
			// ResultSet : sql구문 실행 결과를 저장하는 자바 내장객체
			rs = pstmt.executeQuery();
			// 5단계 : while 결과를 출력, 배열저장 (select)
			// => BoardDTO
			// => 글 하나를 배열 한 칸에 저장
			while (rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setRv_num(rs.getInt("rv_num"));
				dto.setCus_id(rs.getString("cus_id"));
				dto.setRv_title(rs.getString("rv_title"));
				dto.setRv_content(rs.getString("rv_content"));
				dto.setRv_date(rs.getTimestamp("rv_date"));
				dto.setRv_rate(rs.getInt("rv_rate"));
				dto.setRv_view(rs.getInt("rv_view"));
				dto.setMenu_num(rs.getInt("menu_num"));
				// 한 사람의 데이터를 배열에 한 칸에 저장 => boardList
				reviewList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 마무리
			close();
		}
		return reviewList;
	}
	
	public int getReviewCount() {
		int count = 0;
		try {
			// 1,2 디비연결
			con = getConnection();

			// 3단계: sql구문을 만들고 실행할 준비
			String sql = "select count(*) as cnt from rv_board";
			pstmt = con.prepareStatement(sql);
			
			// 4단계: 실행 => 결과 저장
			rs = pstmt.executeQuery();
			// 5 결과 접근 글개수 가져오기
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 마무리
			close();
		}
		
		return count;
	}
	
	public void updateReadcount(int num) {
		try {
			// 1,2 디비연결
			con = getConnection();

			// 3단계: sql구문을 만들고 실행할 준비
			String sql = "update board set readcount = readcount + 1 where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			// 4단계: 실행
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 마무리
			close();
		}

	} // updateReadcount()
	
}
