package com.study.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Zuul的主要功能是路由转发和过滤器。
 *
 * @author KelvinZ
 * @date 2018-11-05 19:57
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableZuulProxy
public class ServiceZuulApplication {
    private static final Logger log = LoggerFactory.getLogger(ServiceZuulApplication.class);

    public static void main(String[] args) {
        log.info("<<<<<<<<< Zuul booting >>>>>>>>>");
        SpringApplication.run(ServiceZuulApplication.class, args);
        log.info("<<<<<<<<< Zuul booting finished >>>>>>>>>");
    }

}
