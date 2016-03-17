package com.jdw.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 *test01
 */
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.jdw"})
public class Web01Application {
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Web01Application.class, args);
    }
}
