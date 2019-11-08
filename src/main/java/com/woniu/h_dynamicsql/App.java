package com.woniu.h_dynamicsql;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class App {
	@Test
	public void test1() throws Exception {//if标签测试
		SqlSession ss = MybatisUtils.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		UserExample ue = new UserExample();
		/**
		 *只设置id的sql语句:SELECT * FROM user WHERE id = ? 
		 *只设置name的sql语句:SELECT * FROM user WHERE name = ? 
		 *只设置maxId的sql语句:SELECT * FROM user WHERE id < ?
		 *设置id、name、maxId的sql语句: SELECT * FROM user WHERE id = ? and name = ? and id < ?
		 *全不设置的sql语句: SELECT * FROM user 
		 */
//		ue.setId(1);
//		ue.setName("扫地僧");
//		ue.setMaxId(5);
		List<User> list = mapper.find(ue);
		for (User user : list) {
			System.out.println(user);
		}
		ss.close();
	}
	
	
	@Test
	public void test2() throws Exception {//choose、when、otherwire标签测试
		SqlSession ss = MybatisUtils.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		UserExample ue = new UserExample();
		/**
		 *只设置id的sql语句:SELECT * FROM user WHERE id = ? 
		 *只设置name的sql语句:SELECT * FROM user WHERE name = ? 
		 *只设置maxId的sql语句:SELECT * FROM user WHERE id < ?
		 *设置id、name、maxId的sql语句: SELECT * FROM user WHERE id = ?
		 *全不设置的sql语句: SELECT * FROM user WHERE 1 = 1 
		 */
//		ue.setId(1);
//		ue.setName("扫地僧");
//		ue.setMaxId(5);
		List<User> list = mapper.find2(ue);
		for (User user : list) {
			System.out.println(user);
		}
		ss.close();
	}
	
	
	@Test
	public void test3() throws Exception {//foreach标签测试
		SqlSession ss = MybatisUtils.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		UserExample ue = new UserExample();
		ue.setIds(Arrays.asList(4,6,8));
		//SELECT * FROM user WHERE id in( ? , ? , ? )  
		List<User> list = mapper.find3(ue);
		for (User user : list) {
			System.out.println(user);
		}
		ss.close();
	}
	
	@Test
	public void test4() throws Exception {//set标签测试
		SqlSession ss = MybatisUtils.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		User user = new User();
		user.setId(3);
		user.setName("张无忌");
		user.setBirthday(new Date());
		user.setMoney(5000d);
		//UPDATE user SET name = ?, birthday = ?, money = ? WHERE id = ? 
		mapper.update(user);
		ss.close();
	}
	
	
	@Test
	public void test5() throws Exception {//trim标签测试
		SqlSession ss = MybatisUtils.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		User user = new User();
		user.setId(1);
		user.setName("林动");
		user.setBirthday(new Date());
		user.setMoney(8000d);
		//UPDATE user set name = ?, birthday = ?, money = ? WHERE id = ? 
		mapper.update2(user);
		ss.close();
	}
	
}
