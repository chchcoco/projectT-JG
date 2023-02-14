package com.greedy.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	public static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSession getSqlSession() {
		
		if(sqlSessionFactory == null) {
			String resource = "com/greedy/common/mybatis-config.xml";
			
			try {
				InputStream inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		
		System.out.println("sqlSession hashCode : " + sqlSession.hashCode());
		
		return sqlSession;
	}
	
//	public static void main(String[] args) {
//		System.out.println(getSqlSession().hashCode());
//	}
	
}
