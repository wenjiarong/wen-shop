package com.w;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 支付服务任务调度
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AppPayJob {

	public static void main(String[] args) {
		SpringApplication.run(AppPayJob.class, args);
	}

}
