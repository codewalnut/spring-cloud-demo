package com.study.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * Spring Cloud Gateway是Spring Cloud官方推出的第二代网关框架，取代Zuul网关。
 * 网关作为流量的，在微服务系统中有着非常作用，网关常见的功能有路由转发、权限校验、限流控制等作用。
 *
 * @author KelvinZ
 * @date 2018-12-28 18:00
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {
    private static final Logger log = LoggerFactory.getLogger(GatewayApplication.class);

    public static void main(String[] args) {
        log.info("<<<<<<<<< Gateway booting >>>>>>>>>");
        SpringApplication.run(GatewayApplication.class, args);
        log.info("<<<<<<<<< Gateway booting finished >>>>>>>>>");
    }

    @Bean
    public RequestTimeGatewayFilterFactory requestTimeGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }

}

