package com.itwillbs.member.db;
//import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


//import sql.SqlMapClient;

public class MemberDAO {
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
	public void insertCustomer(MemberDTO dto) {
		try {
			// 예외(에러)가 발생할 가능성 높은 코드(명령) - 외부에있는 파일, 드라이버 등을 가져오는 코드
			// 1, 2 단계 메서드 호출
			Connection con = getConnection(); // getConnection() 메서드로 리턴 받아 변수에 저장
			
			// 3단계: sql구문을 만들고 실행할 준비
			// String sql = "insert into 테이블명(열이름) values(값)"
			String sql = "insert into customer(cus_id, cus_pass, cus_name, cus_phone, cus_email, cus_birth) values(?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			// ?에 값을 넣어서 sql구문 완성
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getBirth());

			// 4단계: sql구문 실행 (insert)
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	} 
	
	public MemberDTO userCheck(String id,String pass) {
		// MemberDTO 변수 선언 초기값 null
		MemberDTO dto=null;
		try {
			//1,2 디비연결
			Connection con = getConnection();
			// 3단계 sql구문을 만들고 실행할 준비 select
			//String sql="select * from 테이블이름 where id=? and pass=?";
			String sql="select * from customer where cus_id=? and cus_pass=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			//4단계 : sql구문 실행 , 실행결과 저장(select)
			//ResultSet : sql구문 실행 결과를 저장하는 자바 내장객체
			ResultSet rs=pstmt.executeQuery();
			//5단계 : 결과를 출력, 배열저장 (select)
			//if 다음행이동=> 데이터 있으면 => true =>"아이디 비밀번호 일치"
			//else        데이터 없으면 => false => "아이디 비밀번호 틀림"
			if(rs.next()){
				//데이터 있으면 => true =>"아이디 비밀번호 일치"
//				out.println("아이디 비밀번호 일치");
				// id pass name date => 바구니 MemberDTO 저장
				// MemberDTO 객체생성
				dto=new MemberDTO();
				// set메서드 호출 값(디비 가져온값)을 저장
				dto.setId(rs.getString("cus_id"));
				dto.setPass(rs.getString("cus_pass"));
				dto.setName(rs.getString("cus_name"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//마무리
		}
		System.out.println("회원정보가 저장된 리턴할 주소 : " + dto);
		return dto;
	}
	
	public String findId(String name, String phone) {
		String id = null;
		try {
			// 1,2 디비연결
			Connection con = getConnection();
			
			String sql = "select cus_id from customer where cus_name=? and cus_phone=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			
			ResultSet rs = pstmt.executeQuery();
			
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
			Connection con = getConnection();
			
			String sql = "select cus_pass from customer where cus_id=? and cus_name=? and cus_phone=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, phone);
			
			ResultSet rs = pstmt.executeQuery();
			
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
