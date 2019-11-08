package com.woniu.k_lazyload;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
/**
 	在主配置中加入此配置，就启动了延迟加载
  	<settings>
        	<setting name="lazyLoadingEnabled" value="true" />
	        <setting name="aggressiveLazyLoading" value="false" />
	</settings>
	延迟加载是只有需要的时候才会加载
 */
public class App {
	@Test
	public void test1() throws Exception {
		SqlSession ss = MybatisUtils.getSqlSession();
		/**
		 现在由于业务需求，需要查询出班级的名字，但是不需要查询班级的时候去顺带查询学生表，
		 只需要在调用班级中的学生信息时再去查询学生表，要求用一个动态sql语句完成，
		 所以就可以使用延迟加载
		 
		 为什么要这样做？
		 	在多表查询中，子表中信息特别庞大的情况下，只需要主表的一个信息，不需要加载其它子表信息，
		 	这样就不会造成内存的压力，就不会浪费资源
		 */
		ClazzMapper mapper = ss.getMapper(ClazzMapper.class);
		Clazz c = mapper.findOne(1);
		/*
		 注意：测试时应该使用c.getCname()来检测延迟加载是否配置成功，
		 因为如果直接输出clazz对象的话（哪怕clazz的toString中并没
		有访问stus），总是直接加载学生表的数据!
		 */
		System.out.println(c.getCname());//这里调用班级里的学生时，才触发了延迟加载
		System.out.println("enter");
		System.in.read();//这是标准输入，会等待键盘输入了回车才会继续运行程序
		System.out.println(c.getStus());
		ss.close();
	}
	
}
