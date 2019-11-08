package com.woniu.b_parametertype;

import java.util.Date;

public class Foo {
	private Integer id;
	private String name;
	private Date birthday;
	private Double money;
	public Foo(Integer id, String name, Date birthday, Double money) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.money = money;
	}
	public Foo() {
		super();
	}
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Foo [id=" + id + ", name=" + name + ", birthday=" + birthday + ", money=" + money + "]";
	}
	
}
