package com.itwillbs.review.db;

import java.sql.Timestamp;

public class ReviewDTO {
	private int rv_num;
	private String cus_id;
	private String rv_title;
	private String rv_content;
	private Timestamp rv_date;
	private int rv_star;
	private int rv_view;
	private int menu_num;
	
	
	public int getMenu_num() {
		return menu_num;
	}
	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
	}
	public int getRv_num() {
		return rv_num;
	}
	public void setRv_num(int rv_num) {
		this.rv_num = rv_num;
	}
	public String getCus_id() {
		return cus_id;
	}
	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}
	public String getRv_title() {
		return rv_title;
	}
	public void setRv_title(String rv_title) {
		this.rv_title = rv_title;
	}
	public String getRv_content() {
		return rv_content;
	}
	public void setRv_content(String rv_content) {
		this.rv_content = rv_content;
	}
	public Timestamp getRv_date() {
		return rv_date;
	}
	public void setRv_date(Timestamp rv_date) {
		this.rv_date = rv_date;
	}
	public int getRv_star() {
		return rv_star;
	}
	public void setRv_star(int rv_star) {
		this.rv_star = rv_star;
	}
	public int getRv_view() {
		return rv_view;
	}
	public void setRv_view(int rv_view) {
		this.rv_view = rv_view;
	}
	
	
}
