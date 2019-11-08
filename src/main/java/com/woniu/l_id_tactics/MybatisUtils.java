package com.woniu.l_id_tactics;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class MybatisUtils {
	private static SqlSessionFactory ssf;
	static {
		InputStream in = MybatisUtils.class.getResourceAsStream("mybatis-config.xml");
		ssf = new SqlSessionFactoryBuilder().build(in);
	}
	public static SqlSession getSqlSession() {
		return ssf.openSession(true);
	}
}
