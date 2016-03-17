package com.jdw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.v5ent.distribut.transaction.DistributTransactionInterceptor;

@Configuration
@ImportResource(value={"classpath:config/spring-mybatis.xml","classpath:config/test-dubbo.xml"})
public class WebConfig {
	@Bean
	public DistributTransactionInterceptor distributTransactionInterceptor(){
		return new DistributTransactionInterceptor();
	}
}
