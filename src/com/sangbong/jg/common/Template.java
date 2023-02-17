package com.sangbong.jg.common;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {
	
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "C##GREEDY";
	private static String PASSWORD ="GREEDY";
	
	public static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSession getSqlSession() {
		
		if(sqlSessionFactory == null) {
			Environment environment =
					new Environment("dev"
							, new JdbcTransactionFactory()
							, new PooledDataSource(DRIVER, URL, USER, PASSWORD));
			
			Configuration configuration = new Configuration(environment);
			
			/* 이 템플릿을 각 객체의 common파일로 복사한 후, 그 폴더의 DTO에 '객체명Mapper' 이라는 인터페이스를 만듦
			 * 그 후, 아래의 문장을 주석 해제한 후, 아래의 Mapper의 이름을 수정.
			 * 쿼리는 'mappers'라는 폴더에 각 객체의 Mapper가 저장되어있는 것과 같은 폴더(경로)를 만든 후,
			 * 인터페이스와 동일한 이름의 Mapper.xml파일을 만들어서 거기에 쿼리문을 작성한다.
			 * */
//			configuration.addMapper(ObjectMapper.class);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		}
		
		
		
		return  sqlSessionFactory.openSession(false);
	}
	
//	public static void main(String[] args) {
//		System.out.println(getSqlSession().hashCode());
//	}
	
}
