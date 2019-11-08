package com.woniu.g_many2many;

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
		TeacherMapper mapper = ss.getMapper(TeacherMapper.class);
		Teacher t = mapper.findOne(1);
		System.out.println(t);//Teacher [tid=1, tname=江南七怪]
		System.out.println(t.getStus());//[Student [sid=2, sname=陈旋风], Student [sid=1, sname=郭靖]]
		
//		StudentMapper mapper = ss.getMapper(StudentMapper.class);
//		Student s = mapper.findOne(1);
//		System.out.println(s);//Student [sid=1, sname=郭靖]
//		System.out.println(s.getTeas());//[Teacher [tid=2, tname=洪七公], Teacher [tid=1, tname=江南七怪]]
		ss.close();
	}
	
}
