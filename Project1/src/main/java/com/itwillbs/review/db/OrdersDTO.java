package com.itwillbs.review.db;

import java.sql.Timestamp;

public class OrdersDTO {
	private int ord_num;
	private int cus_num;
	private int menu_num;
	private int ord_price;
	private int ord_count;
	private Timestamp ord_date;
	private String ord_pick;
	
	public int getOrd_num() {
		return ord_num;
	}
	public void setOrd_num(int ord_num) {
		this.ord_num = ord_num;
	}
	public int getCus_num() {
		return cus_num;
	}
	public void setCus_num(int cus_num) {
		this.cus_num = cus_num;
	}
	public int getMenu_num() {
		return menu_num;
	}
	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
	}
	public int getOrd_price() {
		return ord_price;
	}
	public void setOrd_price(int ord_price) {
		this.ord_price = ord_price;
	}
	public int getOrd_count() {
		return ord_count;
	}
	public void setOrd_count(int ord_count) {
		this.ord_count = ord_count;
	}
	public Timestamp getOrd_date() {
		return ord_date;
	}
	public void setOrd_date(Timestamp ord_date) {
		this.ord_date = ord_date;
	}
	public String getOrd_pick() {
		return ord_pick;
	}
	public void setOrd_pick(String ord_pick) {
		this.ord_pick = ord_pick;
	}
	
	
	
	
}
