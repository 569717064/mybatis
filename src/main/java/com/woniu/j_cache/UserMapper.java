package com.woniu.j_cache;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

public interface UserMapper {
	User find(Integer id);
	User find2(Integer id);
	List<User> find3(RowBounds rb);
	User find4(UserExample ue);
}
