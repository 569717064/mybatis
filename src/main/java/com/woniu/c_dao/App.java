package com.woniu.c_dao;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class App {
	@Test
	public void testSave() throws Exception {
		SqlSession ss = MybatisUtils.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		User user = new User();
		user.setName("李白");
		user.setBirthday(new Date());
		user.setMoney(6564d);
		mapper.save(user);
		ss.close();
	}
	
	@Test
	public void testDelete() throws Exception {
		SqlSession ss = MybatisUtils.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		mapper.delete(7);
		ss.close();
	}
	
	@Test
	public void testUpdate() throws Exception {
		SqlSession ss = MybatisUtils.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		User user = new User();
		user.setId(5);
		user.setName("杜甫");
		user.setBirthday(new Date());
		user.setMoney(489489d);
		mapper.update(user);
		ss.close();
	}
	
	@Test
	public void testFindOne() throws Exception {
		SqlSession ss = MybatisUtils.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		User user = mapper.findOne(9);
		System.out.println(user);
		ss.close();
	}
	
	@Test
	public void testFindAll() throws Exception {
		SqlSession ss = MybatisUtils.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		List<User> users = mapper.findAll();
		for (User user : users) {
			System.out.println(user);
		}
		ss.close();
	}
}
