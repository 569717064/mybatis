package com.woniu.g_many2many;

import java.io.Serializable;
import java.util.Set;

public class Teacher implements Serializable {
	private Integer tid;
	private String tname;
	private Set<Student> stus;
	public Teacher(Integer tid, String tname, Set<Student> stus) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.stus = stus;
	}
	public Teacher() {
		super();
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Set<Student> getStus() {
		return stus;
	}
	public void setStus(Set<Student> stus) {
		this.stus = stus;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + "]";
	}
	
}
