package com.woniu.e_one2one;

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
		HusbandMapper mapper = ss.getMapper(HusbandMapper.class);
		Husband h = mapper.findOne(1);
		System.out.println(h);//Husband [hid=1, hname=项羽]
		System.out.println(h.getWife());//Wife [wid=1, wname=虞姬]
		
//		WifeMapper mapper = ss.getMapper(WifeMapper.class);
//		Wife w = mapper.findOne(1);
//		System.out.println(w);//Wife [wid=1, wname=虞姬]
//		System.out.println(w.getHusband());//Husband [hid=1, hname=项羽]
		ss.close();
	}
	
}
