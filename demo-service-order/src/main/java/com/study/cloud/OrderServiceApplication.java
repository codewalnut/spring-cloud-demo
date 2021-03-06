package com.study.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 主程序入口
 *
 * @author KelvinZ
 * @date 2018-11-19 22:30
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class OrderServiceApplication {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceApplication.class);

    public static void main(String[] args) {
        log.info("<<<<<<<<< Service booting >>>>>>>>>");
        SpringApplication.run(OrderServiceApplication.class, args);
        log.info("<<<<<<<<< Service booting finished >>>>>>>>>");
    }

}
