package com.woniu.j_cache;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class App {
	/*
	什么是缓存：
		缓存就是一片内存。（map）
	
	缓存的作用：
		让数据更接近于使用者。从而提高程序的性能。  
	
	mybatis中的一级缓存： （重点）
	a. mybatis的一级缓存，是SqlSession级别的缓存。 
		也就是说，只要把SqlSession关闭了，那么一级缓存也就释放了！
		简单来说，一级缓存不能跨会话！！
	b. mybatis的一级缓存其实是SqlSession内部封装的一个HashMap。
	   	既然是map，那必定要存储：键值对，问题是，该map的键值是什么？ 值有是什么？
	   
		键值的组成：
			statementId + rowBounds + 	传递给JDBC的SQL + 传递给JDBC的参数值
			语句id		  rowBounds对象	 sql语句			sql语句的参数
			
		以mapper.find(11);为例，该查询使用的键值是： 
			find + null + “select * from user where id = ?” +  11
			
	c. 执行了close clearCache update delete insert就会清空一级缓存
			
	mybatis的二级缓存
	a. mybatis的二级缓存，是SqlSessionFactory级别的缓存。
	 	也就是说，只要把SqlSessionFactory关闭了，那么二级缓存也就释放了！
		所以二级缓存可以跨会话，毕竟SqlSessionFactory就是用来创建不同的SqlSession，
		也就是说，SqlSessionFactory的生命周期中，有多个SqlSession的生命周期！
		SqlSessionFactory往往与整个应用同生共死，就是在web应用启动的时候，
		SqlSessionFactory就被创建了
		知道web应用被卸载的时候，SqlSessionFactory才被关闭！
	b. mybatis的二级缓存其实是SqlSessionFactory内部封装的一个HashMap。
		二级缓存的键值组成与一级缓存的键值组成是一样的！ 
	c. mybaits的二级缓存，默认是关闭着的，不会其效果的，而mybatis的一级缓存是开启的（也无法关闭）
	d. 想让二级缓存生效，必须添加配置来开启二级缓存
		1) 在主配置中
			<settings>
				<setting name="cacheEnabled" value="true"/>
			</settings>
		2) 在子配置中
			<cache />
	e. 执行了close clearCache update delete insert就会清空二级缓存
	
	f. 既然二级缓存可以跨会话，那么必然对提升系统性能有更大的帮助，那为什么默认是关闭着的呢？？
	因为二级缓存并不是用的越多就越好。 针对于经常被查询的操作，可以使用二级缓存，
	针对于经常修改的操作不适合用二级缓存。
*/		
	@Test
	public void test1() throws Exception {//测试一级缓存不能跨会话
		SqlSession ss = MybatisUtils.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		/**
		 这里查询了两次，只有一条sql语句，证明mybatis有一级缓存
		 select * from user where id = ? 
		 */
		User user = mapper.find(1);
		User user2 = mapper.find(1);
		System.out.println(user);
		System.out.println(user2);
		ss.close();
		
		System.out.println("================================================================");
		SqlSession ss2 = MybatisUtils.getSqlSession();
		UserMapper mapper2 = ss2.getMapper(UserMapper.class);
		/**
		 这里在上面的会话结束后，开启新的会话，查询两次，结果在分割线上下共出现了两条sql语句，
		 证明了一级缓存不能跨会话，当sqlSession关闭后会清空一级缓存
		 */
		User user3 = mapper2.find(1);
		User user4 = mapper2.find(1);
		System.out.println(user3);
		System.out.println(user4);
		ss.close();
	}
	
	
	@Test
	public void test2() throws Exception {//测试一级缓存底层的map键值
		SqlSession ss = MybatisUtils.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		/**
		 map的键值由4部分组成：它会一级缓存内把这四部分分装到一个对象里，有一点不同则键值不同
		 	statementId + rowBounds + 	传递给JDBC的SQL + 传递给JDBC的参数值
		 	语句id         用于分页                    sql语句                    传给sql的参数
		 */
		
		/**
		 测试语句id不同的情况:
		 	会输出两条sql语句，就是访问了两次数据库
		 	select * from user where id = ? 
		 	select * from user where id = ? 
		 */
//		User user = mapper.find(1);
//		User user2 = mapper.find2(1);
		
		/**
		 测试rowBounds不同的情况：
		 	rowBounds具有分页的功能，但是不会拼接limit语句，它是在内存中进行分页的
		 	会输出两条sql语句，就是访问了两次数据库
		 	select * from user 
		 	select * from user 
		 */
//		RowBounds rb = new RowBounds(1,2);
//		List<User> user = mapper.find3(rb);
//		RowBounds rb2 = new RowBounds(1,3);
//		List<User> user2 = mapper.find3(rb2);
//		System.out.println(user);
//		System.out.println(user2);
		
		/**
		 测试sql语句不同的情况：
		 	会输出两条sql语句，就是访问了两次数据库
		 	select * from user where id = ? 
		 	select * from user WHERE name = ? 
		 */
		User user = mapper.find(1);
		UserExample ue = new UserExample();
		ue.setName("林动");
		User user2 = mapper.find4(ue);
		System.out.println(user);
		System.out.println(user2);
		ss.close();
	}
	
	@Test
	public void test3() throws Exception {//测试清空一级缓存的方法
		SqlSession ss = MybatisUtils.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		User user = mapper.find(1);
		System.out.println(user);
		/**
		 清空一级缓存的方法有：
		 	close、clearChche、update、delete、insert
		 */
		//ss.clearCache();
		User user2 = mapper.find(1);
		System.out.println(user2);
		ss.close();
	}
}
