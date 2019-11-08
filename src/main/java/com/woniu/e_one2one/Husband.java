package com.woniu.e_one2one;

import java.io.Serializable;

public class Husband implements Serializable {
	private Integer hid;
	private String hname;
	private Wife wife;
	public Husband(Integer hid, String hname, Wife wife) {
		super();
		this.hid = hid;
		this.hname = hname;
		this.wife = wife;
	}
	public Husband() {
		super();
	}
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	@Override
	public String toString() {
		return "Husband [hid=" + hid + ", hname=" + hname + "]";
	}
	
}
