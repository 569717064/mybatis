package com.woniu.h_dynamicsql;

import java.io.Serializable;
import java.util.List;

public class UserExample implements Serializable {
	private Integer id;
	private String name;
	private Integer maxId;
	private List<Integer> ids;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMaxId() {
		return maxId;
	}
	public void setMaxId(Integer maxId) {
		this.maxId = maxId;
	}
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
}
