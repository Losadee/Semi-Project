package com.itwillbs.board.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.res.db.ReservationDTO;


public class BoardDAO {
	
	Connection con=null;
	PreparedStatement pstmt2 =null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
		public Connection getConnection() throws Exception {
			
			Context init=new InitialContext();
			DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/Mysql");
			con=ds.getConnection();
			return con;
		}
		public void close() {
			if(rs!=null) try{rs.close();}catch(SQLException ex) {}
			if(pstmt2!=null) try{pstmt2.close();}catch(SQLException ex) {}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex) {}
			if(con!=null) try{con.close();}catch(SQLException ex) {}
		}
		
	public void insertBoard(BoardDTO dto) {
		
		int qna_ref=0;
		int qna_re_seq=1;
		int qna_re_lev=1;
		
		try {
			con = getConnection();
			String sql2 = "select max(qna_num) as maxnum from qna_board";
			pstmt2 = con.prepareStatement(sql2);
			rs = pstmt2.executeQuery();
			
			int num=0;
			if(rs.next()) {
				num=rs.getInt("maxnum")+1;
			}
			String sql="insert into qna_board(qna_num, cus_id, qna_title, qna_content, qna_view, qna_reg,"
					+ "qna_ref, qna_re_seq, qna_re_lev)"
					+ "values(?,?,?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getCus_id());
			pstmt.setString(3, dto.getQna_title());
			pstmt.setString(4, dto.getQna_content());
			pstmt.setInt(5, dto.getQna_view());
			pstmt.setTimestamp(6, dto.getQna_reg());
			pstmt.setInt(7, dto.getQna_ref());
			pstmt.setInt(8,  qna_re_seq);
			pstmt.setInt(9, qna_re_lev);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}//insertBoard()
	
		public List<BoardDTO> getBoardList(int startRow, int pageSize) {
	
		List<BoardDTO> boardList=new ArrayList<BoardDTO>();
		try {
		
		con = getConnection();
		
	//		String sql="select * from board";
	//		String sql="select * from board order by num desc limit 시작행-1,글개수";
		
		String sql="select * from qna_board order by qna_num desc limit ?,?";
		pstmt =con.prepareStatement(sql);
		pstmt.setInt(1, startRow-1);
		pstmt.setInt(2, pageSize);
		rs=pstmt.executeQuery();
		
		while(rs.next()) {
			BoardDTO dto=new BoardDTO();
			
			dto.setQna_num(rs.getInt("qna_num"));
			dto.setCus_id(rs.getString("cus_id"));
			dto.setQna_title(rs.getString("qna_title"));
			dto.setQna_content("qna_content");
			dto.setQna_view(rs.getInt("qna_view"));
			dto.setQna_reg(rs.getTimestamp("qna_reg"));

			boardList.add(dto);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		close();
	}
	// 배열의 주소 리턴
	return boardList;
	}//getBoardList()
	
	public BoardDTO getBoard(int num) {
		
		BoardDTO dto=null;
		
		try {
			con=getConnection();
			
			String sql="select * from qna_board where qna_num=?";
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				//결과 있으면  =>num에 대한 글있음
				dto = new BoardDTO();
				dto.setQna_num(rs.getInt("qna_num"));
				dto.setCus_id(rs.getString("cus_id"));
				dto.setQna_title(rs.getString("qna_title"));
				dto.setQna_content(rs.getString("qna_content"));
				dto.setQna_view(rs.getInt("qna_view"));
				dto.setQna_reg(rs.getTimestamp("qna_reg"));
				
				// 답글
				dto.setQna_ref(rs.getInt("qna_ref"));
				dto.setQna_re_lev(rs.getInt("qna_re_lev"));				
				dto.setQna_re_seq(rs.getInt("qna_re_seq"));

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}//

	public void updateReadcount(int num) {

			try {
				con = getConnection();
				String sql="update qna_board set qna_view=qna_view+1 where qna_num=?";
				
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close();
			}
		}//
			
		public void updateBoard(BoardDTO dto) {
	
			try {
				con = getConnection();
				String sql="update qna_board set qna_title=?,qna_content=? where qna_num=?";
				
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, dto.getQna_title());
				pstmt.setString(2, dto.getQna_content());
				pstmt.setInt(3, dto.getQna_num());
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close();
			}
		}//
			
		public void deleteBoard(int num) {
	
			try {
				con = getConnection();
				String sql="delete from qna_board where qna_num=?";
				
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, num);
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close();
			}
		}	
		
		// 전체 qna게시판 
		public int getBoardCount() {
			int count=0;
			try {
				con=getConnection();
				String sql="select count(*) from qna_board";
				
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					count=rs.getInt("count(*)");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return count;
		}
		
		public void name() {
			
		}
		
		
		
		// 나의 qna목록 가져오기
		public List<BoardDTO> getMyQnaList(String cus_id, int startRow, int pageSize) {
			List<BoardDTO> myQnaList =new ArrayList<BoardDTO>();
			
	        try {
	        	con=getConnection();
	        	
				String sql = "WITH RECURSIVE cte AS (SELECT qna_num, cus_id, qna_title, qna_content, qna_view, qna_reg, qna_ref, qna_re_lev, qna_re_seq, \r\n"
						+ "@rn:=(@rn+1) AS pnum FROM  ( SELECT * FROM qna_board ORDER BY qna_num DESC ) t1, \r\n"
						+ "(SELECT @rn:=0) t2 \r\n"
						+ "WHERE qna_ref = 0 and cus_id = ? \r\n"
						+ "UNION  ALL \r\n"
						+ "SELECT q.qna_num, q.cus_id,  CONCAT(' └ ', q.qna_title) as qna_title, q.qna_content, q.qna_view, q.qna_reg, q.qna_ref, \r\n"
						+ "q.qna_re_lev, q.qna_re_seq, p.pnum AS pnum \r\n"
						+ "FROM qna_board q INNER JOIN cte p \r\n"
						+ "ON p.qna_num = q.qna_ref) \r\n"
						+ "SELECT * FROM cte ORDER BY pnum, qna_re_seq \r\n"
						+ "LIMIT ?, ?";
				
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, cus_id);
				pstmt.setInt(2, startRow-1);
				pstmt.setInt(3, pageSize);
				rs=pstmt.executeQuery();
	            
	            while(rs.next()) {
	            	BoardDTO dto=new BoardDTO();
	            	
	                dto=new BoardDTO();
	                dto.setCus_id(sql);
	                dto.setQna_num(rs.getInt("qna_num"));
	                dto.setCus_id(rs.getString("cus_id"));
	                dto.setQna_title(rs.getString("qna_title"));
					dto.setQna_content(rs.getString("qna_content"));
	                dto.setQna_reg(rs.getTimestamp("qna_reg"));
	                dto.setQna_ref(rs.getInt("qna_ref"));
					dto.setQna_re_lev(rs.getInt("qna_re_lev"));				
					dto.setQna_re_seq(rs.getInt("qna_re_seq"));
	                
	               myQnaList.add(dto);
	            }
           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            close();
	        }
	        return myQnaList;
	    }
		
		// 나의 qna 글개수
		public int getMyCount(String cus_id) {
			int count=0;
			try {
				con=getConnection();				
				String sql="WITH RECURSIVE cte AS (SELECT qna_num, cus_id, qna_title, qna_content, qna_view, qna_reg, qna_ref, qna_re_lev, qna_re_seq, \r\n"
						+ "@rn:=(@rn+1) AS pnum FROM  ( SELECT * FROM qna_board ORDER BY qna_num DESC ) t1, \r\n"
						+ "(SELECT @rn:=0) t2 \r\n"
						+ "WHERE qna_ref = 0 and cus_id = ? \r\n"
						+ "UNION  ALL \r\n"
						+ "SELECT q.qna_num, q.cus_id,  CONCAT(' └ ', q.qna_title) as qna_title, q.qna_content, q.qna_view, q.qna_reg, q.qna_ref, \r\n"
						+ "q.qna_re_lev, q.qna_re_seq, p.pnum AS pnum \r\n"
						+ "FROM qna_board q INNER JOIN cte p \r\n"
						+ "ON p.qna_num = q.qna_ref) \r\n"
						+ "SELECT * FROM cte ORDER BY pnum, qna_re_seq";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, cus_id);
				
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					count=rs.getInt("count(*)");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return count;
		}	
		
		public void replyBoard(BoardDTO dto) {
		
//			int qna_num = dto.getQna_num();
//			int qna_ref = qna_num;
			
			try {
				con = getConnection();
				String sql2 = "select max(qna_num) as maxnum from qna_board";
				pstmt2 = con.prepareStatement(sql2);
				rs = pstmt2.executeQuery();
				
				int num=0;
				if(rs.next()) {
					num=rs.getInt("maxnum")+1;
				}
				
//				String sql3="update qna_board set qna_re_seq = qna_re_seq+1 where qna_ref = ? and qna_re_seq > ?";
//				pstmt =con.prepareStatement(sql3);	
//				pstmt.setInt(1, dto.getQna_ref());	// re_ref 그룹번호 == 일반글 번호
//				pstmt.setInt(2, dto.getQna_re_lev()+1);
//				pstmt.executeUpdate();
				
				String sql="insert into qna_board(qna_num, cus_id, qna_title, qna_content, qna_view, qna_reg,"
						+ "qna_ref, qna_re_seq, qna_re_lev)"
						+ "values(?,?,?,?,?,?,?,?,?)";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, num);
				pstmt.setString(2, dto.getCus_id());
				pstmt.setString(3, dto.getQna_title());
				pstmt.setString(4, dto.getQna_content());
				pstmt.setInt(5, dto.getQna_view());
				pstmt.setTimestamp(6, dto.getQna_reg());
				pstmt.setInt(7, dto.getQna_num());
				pstmt.setInt(8, dto.getQna_re_lev()+1);
				pstmt.setInt(9, dto.getQna_re_seq()+1);
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}finally {
				close();
			}
		}
			
			// 답글 리스트
			public List<BoardDTO> replyBoardList(int startRow, int pageSize) {
					
				List<BoardDTO> reBoardList=new ArrayList<BoardDTO>();
				
				try {	
					con = getConnection();
					String sql2 = "WITH RECURSIVE cte AS (SELECT qna_num, cus_id, qna_title, qna_view, qna_reg, qna_ref, qna_re_lev, qna_re_seq, \r\n"
							+ "@rn:=(@rn+1) AS pnum FROM  ( SELECT * FROM qna_board ORDER BY qna_num DESC ) t1, \r\n"
							+ "(SELECT @rn:=0) t2 \r\n"
							+ "WHERE qna_ref = 0 \r\n"
							+ "UNION  ALL \r\n"
							+ "SELECT q.qna_num, q.cus_id,  CONCAT(' └ ', q.qna_title) as qna_title, q.qna_view, q.qna_reg, q.qna_ref, \r\n"
							+ "q.qna_re_lev, q.qna_re_seq, p.pnum AS pnum \r\n"
							+ "FROM qna_board q INNER JOIN cte p \r\n"
							+ "ON p.qna_num = q.qna_ref) \r\n"
							+ "SELECT * FROM cte ORDER BY pnum, qna_re_seq \r\n"
							+ "LIMIT ?, ?";
					
					pstmt2 =con.prepareStatement(sql2);
					pstmt2.setInt(1, startRow-1);
					pstmt2.setInt(2, pageSize);
					rs=pstmt2.executeQuery();
					
				while(rs.next()) {
					
					BoardDTO dto =new BoardDTO();
				
					dto.setQna_num(rs.getInt("qna_num"));
					dto.setCus_id(rs.getString("cus_id"));
					dto.setQna_title(rs.getString("qna_title"));
					dto.setQna_view(rs.getInt("qna_view"));
					dto.setQna_reg(rs.getTimestamp("qna_reg"));
					// 답글
					dto.setQna_ref(rs.getInt("qna_ref"));
					dto.setQna_re_lev(rs.getInt("qna_re_lev"));				
					dto.setQna_re_seq(rs.getInt("qna_re_seq"));
					
					reBoardList.add(dto);
				}
				
			} catch (Exception e) {
				e.printStackTrace();			
				
			}finally {
				close();
			}
			return reBoardList;
		}
			
			
		// 관리자용 문의내역 조회
		public List<BoardDTO> getAdminQnaList(int startRow,int pageSize) {
			List<BoardDTO> boardList =new ArrayList<BoardDTO>();
	    		
	        try {
	        	con=getConnection();
				String sql="WITH RECURSIVE cte AS (SELECT qna_num, cus_id, qna_title, qna_content, qna_view, qna_reg, qna_ref, qna_re_lev, qna_re_seq, \r\n"
					+ "@rn:=(@rn+1) AS pnum FROM  ( SELECT * FROM qna_board ORDER BY qna_num DESC ) t1, \r\n"
					+ "(SELECT @rn:=0) t2 \r\n"
					+ "WHERE qna_ref = 0 \r\n"
					+ "UNION  ALL \r\n"
					+ "SELECT q.qna_num, q.cus_id,  CONCAT(' └ ', q.qna_title) as qna_title, q.qna_content, q.qna_view, q.qna_reg, q.qna_ref, \r\n"
					+ "q.qna_re_lev, q.qna_re_seq, p.pnum AS pnum \r\n"
					+ "FROM qna_board q INNER JOIN cte p \r\n"
					+ "ON p.qna_num = q.qna_ref) \r\n"
					+ "SELECT * FROM cte ORDER BY pnum, qna_re_seq limit ?,?;";
				
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, startRow-1);
				pstmt.setInt(2, pageSize);
				rs=pstmt.executeQuery();
	            
	            while(rs.next()) {
	            	BoardDTO dto=new BoardDTO();
	            	
	                dto=new BoardDTO();
	                dto.setCus_id(sql);
	                dto.setQna_num(rs.getInt("qna_num"));
	                dto.setCus_id(rs.getString("cus_id"));
	                dto.setQna_title(rs.getString("qna_title"));
					dto.setQna_content(rs.getString("qna_content"));
	                dto.setQna_reg(rs.getTimestamp("qna_reg"));
	                dto.setQna_ref(rs.getInt("qna_ref"));
					dto.setQna_re_lev(rs.getInt("qna_re_lev"));				
					dto.setQna_re_seq(rs.getInt("qna_re_seq"));
	                
	               boardList.add(dto);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            close();
	        }
	        return boardList;
	    }
				
		// 페이징	
	    public int getQnaCount() {
	    	
			int count=0;
			try {
				con=getConnection();				
				String sql="select count(*) from qna_board;";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					count=rs.getInt("count(*)");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return count;
		}	
		
			
	        
}//class
