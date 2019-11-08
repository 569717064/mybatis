package com.woniu.c_dao;

import java.util.List;

public interface UserMapper {
	void save(User user);
	void update(User user);
	void delete(Integer id);
	User findOne(Integer id);
	List<User> findAll();
}
