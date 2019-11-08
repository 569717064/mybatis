package com.woniu.g_many2many;

import java.io.Serializable;
import java.util.Set;

public class Student implements Serializable {
	private Integer sid;
	private String sname;
	private Set<Teacher> teas;
	public Student(Integer sid, String sname, Set<Teacher> teas) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.teas = teas;
	}
	public Student() {
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
	public Set<Teacher> getTeas() {
		return teas;
	}
	public void setTeas(Set<Teacher> teas) {
		this.teas = teas;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + "]";
	}
	
}
