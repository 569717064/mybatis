package com.woniu.k_lazyload;

import java.io.Serializable;
import java.util.Set;

public class Clazz implements Serializable {
	private Integer cid;
	private String cname;
	private Set<Stu> stus;
	public Clazz(Integer cid, String cname, Set<Stu> stus) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.stus = stus;
	}
	public Clazz() {
		super();
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Stu> getStus() {
		return stus;
	}
	public void setStus(Set<Stu> stus) {
		this.stus = stus;
	}
	@Override
	public String toString() {
		return "Clazz [cid=" + cid + ", cname=" + cname + "]";
	}
	
	
}
