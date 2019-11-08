package com.woniu.a_hello;

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
		//加载mybatis主配置文件,这里写的是相对路径
		InputStream in = App.class.getResourceAsStream("mybatis-config.xml");
		//创建SqlSessionFactory，SqlSessionFactory是专门用来生成sqlSession的
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		// 获取一个会话，这里的会话，是从连接数据库开始， 到关闭了数据库连接为止。
		//每一个SqlSession对象中都封装了一个Connection对象
		// 注意，在获取会话的同时，事务已经开启了，这一点和hibernate不一样！
		SqlSession ss = ssf.openSession();
		//这个代表了事务的自动提交，就不用再写ss.commit()了
		//SqlSession ss = ssf.openSession(true);
		User user = new User();
		user.setName("扫地僧");
		user.setBirthday(new Date(0));
		user.setMoney(8888d);
		ss.insert("com.woniu.a_hello.UserMapper.save", user);
		// 提交事务，虽然事务是自动开启的，但是提交，还必须手动提交。
		ss.commit();
		// 关闭会话，表面上是关闭mybatis的会话，实际上底层是关闭了数据库连接！
		ss.close();
	}
	
	@Test
	public void testDelete() throws Exception {
		InputStream in = App.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		// 在通过 sf.openSession();获取会话对象的时候，如果传入了true，则表示事务会在s.close()的时候，自动提交！
		SqlSession ss = ssf.openSession(true);
		ss.delete("com.woniu.a_hello.UserMapper.delete",10);
		ss.close();
	}
	
	@Test
	public void testUpdate() throws Exception {
		InputStream in = App.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		SqlSession ss = ssf.openSession(true);
		User user = new User();
		user.setId(8);
		user.setName("张三丰");
		user.setBirthday(new Date());
		user.setMoney(9595d);
		ss.update("com.woniu.a_hello.UserMapper.update",user);
		ss.close();
	}
	
	@Test
	public void testFindOne() throws Exception {
		InputStream in = App.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		SqlSession ss = ssf.openSession(true);
		User user = ss.selectOne("com.woniu.a_hello.UserMapper.findOne", 9);
		System.out.println(user);
		ss.close();
	}
	
	@Test
	public void testFindAll() throws Exception {
		InputStream in = App.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		SqlSession ss = ssf.openSession(true);
		List<User> users = ss.selectList("com.woniu.a_hello.UserMapper.findAll");
		for (User user : users) {
			System.out.println(user);
		}
	}
}
