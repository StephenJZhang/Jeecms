package com.jeecms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import tk.mybatis.spring.annotation.MapperScan;



//开启异步调用方法
@EnableAsync
//扫描 mybatis mapper 包路径
@MapperScan(basePackages = "com.jeecms.*.dao")
//扫描 所有需要的包, 包含一些自用的工具类包 所在的路径
@SpringBootApplication
public class JeecmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeecmsApplication.class, args);
	}
}
