package com.woniu.i_function;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class App {
	@Test
	public void test1() throws Exception {
		SqlSession ss = MybatisUtils.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		Map map = mapper.find();
		System.out.println(map);
		//{最小id=1, 最大id=12, 数量=9, 余额总数=1317471.0, 平均余额=146385.66666666666}
		ss.close();
	}
	
	
	@Test
	public void test2() throws Exception {
		SqlSession ss = MybatisUtils.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		List<Map> list = mapper.find2();
		for (Map map : list) {
			System.out.println(map);
			/**
			 * {count(*)=5, 名字长度=6}
			 * {count(*)=4, 名字长度=9}
			 */
		}
		ss.close();
	}
	
	@Test
	public void test3() throws Exception {
		SqlSession ss = MybatisUtils.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		List<Map> list = mapper.find3();
		for (Map map : list) {
			System.out.println(map);
		}
		ss.close();
	}
	
	
}
