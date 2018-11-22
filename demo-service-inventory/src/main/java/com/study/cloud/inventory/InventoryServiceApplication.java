package com.study.cloud.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序入口
 *
 * @author KelvinZ
 * @date 2018-10-25
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com")
@ComponentScan(basePackages = {"com"})
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

}
