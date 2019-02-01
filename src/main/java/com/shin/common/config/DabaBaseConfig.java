package com.shin.common.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class DabaBaseConfig {
    @Bean
    public DataSource getDataSource() throws IOException
    {
        return new HikariDataSource();
    }

    @Bean
    public SqlSessionFactory getSqlSessionFactory() throws Exception
    {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(getDataSource());
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate getSqlSessionTemplate() throws Exception
    {
        return new SqlSessionTemplate(getSqlSessionFactory());
    }
}
