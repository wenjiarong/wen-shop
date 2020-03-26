package com.w;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 积分服务启动
 */
@SpringBootApplication
@MapperScan(basePackages = "com.w.integral.mapper")
public class AppIntegral {

	public static void main(String[] args) {
		SpringApplication.run(AppIntegral.class, args);
	}

}
