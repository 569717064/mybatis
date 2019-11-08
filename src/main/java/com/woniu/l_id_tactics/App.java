package com.woniu.l_id_tactics;

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
	public void test1() throws Exception {
		SqlSession ss = MybatisUtils.getSqlSession();
		BookMapper mapper = ss.getMapper(BookMapper.class);
		Book b = new Book();
		b.setBname("狼来了");
		mapper.save(b);
		ss.close();
	}
	
}
