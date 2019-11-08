package com.woniu.f_one2many;

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
//		ClazzMapper mapper = ss.getMapper(ClazzMapper.class);
//		Clazz c = mapper.findOne(1);
//		System.out.println(c);//Clazz [cid=1, cname=一班]
//		System.out.println(c.getStus());//[Stu [sid=2, sname=李四], Stu [sid=1, sname=张三]]
		
		StuMapper mapper = ss.getMapper(StuMapper.class);
		Stu s = mapper.findOne(1);
		System.out.println(s);//Stu [sid=1, sname=张三]
		System.out.println(s.getClazz());//Clazz [cid=1, cname=一班]
		ss.close();
	}
	
}
