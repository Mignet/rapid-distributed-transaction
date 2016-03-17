package com.jdw.config;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
@Configuration
@EnableConfigurationProperties({ConfigBean.class})  
public class DataSourceConfigration {
	private static Logger logger=Logger.getLogger(DataSourceConfigration.class);
	@Autowired
	private  ConfigBean configBean;
	@Bean(name="dataSource",destroyMethod="close",initMethod="init")
	public DruidDataSource initDataSource(){
		logger.info("----------------------- init DruidDataSource start -----------------------");
		DruidDataSource dataSource=new DruidDataSource();
		dataSource.setDriverClassName(configBean.getDriverClassName());
		dataSource.setUrl(configBean.getUrl());
		dataSource.setPassword(configBean.getPassword());
		dataSource.setUsername(configBean.getUsername());
		if(configBean.getMaxActive()!=null){
			dataSource.setMaxActive(configBean.getMaxActive());
		}
		if(configBean.getInitialSize()!=null){
			dataSource.setInitialSize(configBean.getInitialSize());
		}
		if(configBean.getMinIdle()!=null){
			dataSource.setMinIdle(configBean.getMinIdle());
		}
		if(configBean.getMaxWait()!=null){
			dataSource.setMaxWait(configBean.getMaxWait());
		}
		if(configBean.getValidationQuery()!=null){
			dataSource.setValidationQuery(configBean.getValidationQuery());
		}
		dataSource.setTestOnBorrow(false);
		dataSource.setTestOnReturn(false);
		dataSource.setTestWhileIdle(false);
		dataSource.setTimeBetweenEvictionRunsMillis(60000);
		dataSource.setMinEvictableIdleTimeMillis(25200000);
		dataSource.setRemoveAbandoned(true);
		dataSource.setRemoveAbandonedTimeout(1800);
		dataSource.setLogAbandoned(true);
		try {
			dataSource.setFilters("mergeStat");
		} catch (SQLException e) {

		}
		logger.info("-----------------------DruidDataSource-----------------------");
		return dataSource;
	}
	
}