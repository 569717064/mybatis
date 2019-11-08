package com.woniu.f_one2many;

import java.io.Serializable;

public class Stu implements Serializable {
	private Integer sid;
	private String sname;
	private Clazz clazz;
	public Stu(Integer sid, String sname, Clazz clazz) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.clazz = clazz;
	}
	public Stu() {
		super();
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	@Override
	public String toString() {
		return "Stu [sid=" + sid + ", sname=" + sname + "]";
	}
	
}
