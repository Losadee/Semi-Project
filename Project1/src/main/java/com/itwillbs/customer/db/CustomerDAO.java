package com.itwillbs.customer.db;
//import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


//import sql.SqlMapClient;

public class CustomerDAO {
	//	private SqlSessionFactory sqlSessionFactory = SqlMapClient.getSqlSession();
	
	// 마무리 작업을 메서드로 만들기 위해 close()할 변수들 멤버변수로 선언해주기.
	Connection con = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	// getConnection() : DB 연결 메서드
	public Connection getConnection() throws Exception {
		Context init = new InitialContext();
		// 자원의 이름(name) 호출("자원의 위치/자원의 이름")
		// import javax.sql.DataSource;
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/Mysql");
		// con에 저장 (DataSource -> Connection)
		con = ds.getConnection();

		return con; // 연결정보를 리턴
	}
	
	// close() : 마무리 작업 메서드
	public void close() {
		if (pstmt2 != null) try {pstmt2.close();} catch (SQLException ex) {ex.printStackTrace();}
		if (pstmt != null) 	try {pstmt.close();}  catch (SQLException ex) {ex.printStackTrace();}
		if (con != null)	try {con.close();} 	  catch (SQLException ex) {ex.printStackTrace();}
		if (rs != null)		try {rs.close();} 	  catch (SQLException ex) {ex.printStackTrace();}
	}
	
	// 회원 추가 insert
	public void insertCustomer(CustomerDTO dto) {
		try {
			con = getConnection();
			
			String sql2 = "select max(num) as maxnum from customer";
			pstmt2 = con.prepareStatement(sql2);
			
			rs = pstmt2.executeQuery();
			int num = 0;
			if (rs.next()) {
				num = rs.getInt("maxnum") + 1;
			}
			String sql = "insert into customer values(?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getCus_id());
			pstmt.setString(3, dto.getCus_pass());
			pstmt.setString(4, dto.getCus_name());
			pstmt.setString(5, dto.getCus_phone());
			pstmt.setString(6, dto.getCus_email());

			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}	
	
	public CustomerDTO userCheck(String id, String pass) {
		// MemberDTO 변수 선언	(초기값은 null로 선언)
		CustomerDTO dto = null;
		try {
			// 1,2 디비연결
			con = getConnection();
			// 3단계: sql구문을 만들고 실행할 준비
			// String sql = "select * from 테이블명 where id=? and pass=?";
			String sql = "select * from customer where cus_id=? and cus_pass=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			// 4단계: sql구문 실행 , 실행결과 저장(select)
			// ResultSet : sql구문 실행 결과를 저장하는 자바 내장객체
			rs = pstmt.executeQuery();
			//5단계: 결과를 출력, 배열저장 (select)
			//if 다음행 이동 => 데이터 있으면 => true => "아이디 비밀번호 일치"
//						     데이터 없으면 => false => "아이디 비밀번호 틀림"	
			if(rs.next()) {
				// 데이터 있으면 => true => "아이디 비밀번호 일치"
//				out.println("아이디 비밀번호 일치");
				// id pass name date => 바구니 MemberDTO 저장
				// MemberDTO 객체생성
				dto = new CustomerDTO();
				// set메서드 호출 값(디비 가져온 값)을 저장 (id, pass 이외의 값은 나중에 사용할 것)
				dto.setCus_id(rs.getString("cus_id"));
				dto.setCus_pass(rs.getString("cus_pass"));
				dto.setCus_name(rs.getString("cus_name"));
				dto.setCus_phone(rs.getString("cus_phone"));
				dto.setCus_email(rs.getString("cus_email"));
			} 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 마무리
		}
		return dto;
	} 
	
	
	public CustomerDTO findPhone(String phone) {
		CustomerDTO dto=null;
		try {
			con = getConnection();	
			
			String sql = "select * from customer where cus_phone=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phone);
			
			rs=pstmt.executeQuery();

			if(rs.next()) {
				dto = new CustomerDTO();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		System.out.println("dto : " + dto);
		return dto;
	}
	
	public String findId(String name, String phone) {
		String id = null;
		try {
			// 1,2 디비연결
			con = getConnection();
			
			String sql = "select cus_id from customer where cus_name=? and cus_phone=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getString("cus_id");
			} 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return id;
	}
	
	public String findPw(String id, String name, String phone) {
		String pw = null;
		try {
			// 1,2 디비연결
			con = getConnection();
			
			String sql = "select cus_pass from customer where cus_id=? and cus_name=? and cus_phone=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, phone);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pw = rs.getString("cus_pass");
			} 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return pw;
	}
}
