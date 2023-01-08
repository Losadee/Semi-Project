package com.itwillbs.customer.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CustomerDAO {
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	// 디비연결 메서드
	public Connection getConnection() throws Exception {
		Context init=new InitialContext();
		DataSource ds= (DataSource)init.lookup("java:comp/env/jdbc/Mysql");
		con=ds.getConnection();
		return con;
	} // 디비연결 메서드
	
	// close 메서드
	public void close() {
		if(con!=null)try{con.close();} catch(SQLException e) {}
		if(pstmt!=null)try{pstmt.close();} catch(SQLException e) {}
		if(rs!=null)try{rs.close();} catch(SQLException e) {}
	} // close 메서드
	
   // 전화번호 중복 확인
	public CustomerDTO phoneCheck(String phone) {
		CustomerDTO dto=null;
		
		try {
			con=getConnection();
			String sql="select * from customer where cus_phone=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, phone);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto=new CustomerDTO();
			} else {}
		} catch (Exception e) {e.printStackTrace();} finally {close();}
		return dto;
	} // 전화번호 중복 확인
		
	// insertMember 메서드
	public void insertCustomer(CustomerDTO dto) {
		
		try {
			con=getConnection();
			String sql="insert into customer(cus_id,cus_pass,cus_name,cus_phone,cus_email) values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getCus_id());
			pstmt.setString(2, dto.getCus_pass());
			pstmt.setString(3, dto.getCus_name());
			pstmt.setString(4, dto.getCus_phone());
			pstmt.setString(5, dto.getCus_email());
			
			pstmt.executeUpdate(); //sql insert,update,delete 때 사용
			
		} catch (Exception e) {e.printStackTrace();} finally {close();}
	
	} // insertMember 메서드
	
	// 카카오 insertMember 메서드
	public void KinsertCustomer(CustomerDTO dto) {
		
		try {
			con=getConnection();
			String sql="insert into customer(cus_id,cus_pass,cus_name,cus_email) values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getCus_id());
			pstmt.setString(2, dto.getCus_email());
			pstmt.setString(3, dto.getCus_name());
			pstmt.setString(4, dto.getCus_email());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {e.printStackTrace();} finally {close();}
		
	} // 카카오 KinsertMember 메서드 닫음
	
	// userCheck()
	public CustomerDTO userCheck(String id, String pass) {
		CustomerDTO dto=null;
		
		try {
			con=getConnection();
			String sql="select * from customer where cus_id=? and cus_pass=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto=new CustomerDTO();
				dto.setCus_id(rs.getString("cus_id"));
				dto.setCus_pass(rs.getString("cus_pass"));
			} else {}
			
		} catch (Exception e) {e.printStackTrace();} finally {close();}
		
		return dto;
	} // userCheck()
	
	// 아이디찾기 메서드
	public String findId(String name, String phone) {
		String id = null;
		try {
			// 1,2 디비연결
			Connection con = getConnection();
			
			String sql = "select cus_id from customer where cus_name=? and cus_phone=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getString("cus_id");
			} 
		} catch (Exception e) {e.printStackTrace();} finally {close();}
		
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
		} catch (Exception e) {e.printStackTrace();} finally {close();}
		
		return pw;
	}
	
	// 멤버정보조회 메서드
	public CustomerDTO getCustomer(String id) {
		CustomerDTO dto=null;
		
		try {
			con=getConnection();
			String sql="select * from customer where cus_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto=new CustomerDTO();
				dto.setCus_id(rs.getString("cus_id"));
				dto.setCus_pass(rs.getString("cus_pass"));
				dto.setCus_name(rs.getString("cus_name"));
				dto.setCus_phone(rs.getString("cus_phone"));
				dto.setCus_email(rs.getString("cus_email"));
				
			} else {}
		} catch (Exception e) {e.printStackTrace();} finally {close();}
		return dto;
	} // 멤버정보조회 메서드
	
	//updateMember()
	public void updateCustomer(CustomerDTO dtoUpdate) {
		
		try {
			con=getConnection();
			String sql="update customer set cus_name=?,cus_phone=?,cus_email=? where cus_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dtoUpdate.getCus_name());
			pstmt.setString(2, dtoUpdate.getCus_phone());
			pstmt.setString(3, dtoUpdate.getCus_email());
			pstmt.setString(4, dtoUpdate.getCus_id());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {e.printStackTrace();} finally {close();}
	} //updateMember()
	
	// 멤버 삭제
	public void deleteCustomer(String id) {
		
		try {
			con=getConnection();
			String sql="delete from customer where cus_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {e.printStackTrace();} finally {close();}
	} // 멤버 삭제
	
	// 멤버 목록 조회
	public List getCustomerList() {
		List<CustomerDTO> customerList=new ArrayList<CustomerDTO>();
		
		try {
			con=getConnection();
			String sql="select * from customer";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				CustomerDTO dto=new CustomerDTO();
				dto.setCus_id(sql);
				dto.setCus_pass(rs.getString("cus_pass"));
				dto.setCus_name(rs.getString("cus_name"));
				
				customerList.add(dto);
			}
		} catch (Exception e) {e.printStackTrace();} finally {close();}
		return customerList;
	} // 멤버 목록 조회
	
}
