package com.study.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序入口
 *
 * @author KelvinZ
 * @date 2018-11-19 22:30
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com")
@ComponentScan(basePackages = {"com"})
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
