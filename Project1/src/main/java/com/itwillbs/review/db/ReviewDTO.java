package com.itwillbs.review.db;

import java.sql.Timestamp;

public class ReviewDTO {
	private int rv_num;
	private int cus_num;
	private String rv_title;
	private String rv_content;
	private Timestamp rv_date;
	private int rv_rate;
	private int rv_view;
	
	
	public int getRv_num() {
		return rv_num;
	}
	public void setRv_num(int rv_num) {
		this.rv_num = rv_num;
	}
	public int getCus_num() {
		return cus_num;
	}
	public void setCus_num(int cus_num) {
		this.cus_num = cus_num;
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
	public int getRv_rate() {
		return rv_rate;
	}
	public void setRv_rate(int rv_rate) {
		this.rv_rate = rv_rate;
	}
	public int getRv_view() {
		return rv_view;
	}
	public void setRv_view(int rv_view) {
		this.rv_view = rv_view;
	}
	
	
}
