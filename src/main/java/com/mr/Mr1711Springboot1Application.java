package com.mr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication//启动的入口
// @ComponentScan(value = "com.mr.controller")// component 注入到Spring容器中 Scan:扫描指定的包
@MapperScan("com.mr.mapper")//扫描mapper的xml文件
@EnableTransactionManagement// 启动时添加事物管理
@EntityScan("com.mr.model")// 扫描实体类
@EnableCaching// redis缓存的扫描
public class Mr1711Springboot1Application {

	public static void main(String[] args) {
		SpringApplication.run(Mr1711Springboot1Application.class, args);
	}
}
