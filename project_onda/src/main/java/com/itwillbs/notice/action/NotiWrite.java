package com.itwillbs.notice.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.notice.db.NoticeDAO;
import com.itwillbs.notice.db.NoticeDTO;

public class NotiWrite implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String cus_id=request.getParameter("cus_id");
		String nt_title=request.getParameter("nt_title");
		String nt_content=request.getParameter("nt_content");
		
		NoticeDTO dto = new NoticeDTO();

		dto.setCus_id(cus_id);
		dto.setNt_title(nt_title);
		dto.setNt_content(nt_content);
		dto.setNt_date(new Timestamp(System.currentTimeMillis()));
		dto.setNt_view(0);

		NoticeDAO dao = new NoticeDAO();

		dao.insertBoard(dto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./NotiList.no");
		forward.setRedirect(true);
		return forward;
	}
	

}
