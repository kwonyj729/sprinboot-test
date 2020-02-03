package com.cos.springboot.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.cos.springboot.repository")  //컴포넌트 스캔처럼 여기를 스캔한다. 레파지토리 패키지에 있는 모든것을 스캔함.
public class DataAccessConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        sessionFactory.setDataSource(dataSource);
        // 팩토리에서 dataSource를 참고해서 뭘 만든다.
        sessionFactory.setMapperLocations(
        		new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));//resource 파일에는 모두 접근 가능함.
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
