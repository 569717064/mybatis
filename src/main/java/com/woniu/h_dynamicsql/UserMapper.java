package com.woniu.h_dynamicsql;

import java.util.List;
import java.util.Map;

public interface UserMapper {
	List<User> find(UserExample ue);
	List<User> find2(UserExample ue);
	List<User> find3(UserExample ue);
	void update(User user);
	void update2(User user);
}
