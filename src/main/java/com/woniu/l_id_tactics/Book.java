package com.woniu.l_id_tactics;

import java.io.Serializable;

public class Book implements Serializable {
	private String bid;
	private String bname;
	public Book(String bid, String bname) {
		super();
		this.bid = bid;
		this.bname = bname;
	}
	public Book() {
		super();
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + "]";
	}
	
	
}
