package com.study.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Config Client 项目
 *
 * @author KelvinZ
 * @date 2018-11-13 22:03
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@RefreshScope
public class ConfigClientApplication {
    private static final Logger log = LoggerFactory.getLogger(ConfigClientApplication.class);

    public static void main(String[] args) {
        log.info("<<<<<<<<< Config Client booting >>>>>>>>>");
        SpringApplication.run(ConfigClientApplication.class, args);
        log.info("<<<<<<<<< Config Client booting finished >>>>>>>>>");
    }

    @Value("${cloud.test}")
    private String test;

    @RequestMapping(value = "/test")
    public String test() {
        return test;
    }

}
