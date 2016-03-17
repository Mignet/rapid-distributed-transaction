package com.jdw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value={"classpath:config/main-dubbo.xml","classpath:config/spring-mybatis.xml"})
public class WebConfig {

}
