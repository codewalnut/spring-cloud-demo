package com.study.cloud.demoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 主程序入口
 *
 * @author KelvinZ
 * @date 2018-10-25
 */
@SpringBootApplication
@EnableEurekaClient
public class DemoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceApplication.class, args);
	}

}
