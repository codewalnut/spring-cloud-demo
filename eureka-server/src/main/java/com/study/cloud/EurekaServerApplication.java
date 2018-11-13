package com.study.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 主程序入口
 *
 * @author KelvinZ
 * @date 2018-10-25
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    private static Logger log = LoggerFactory.getLogger(EurekaServerApplication.class);

    public static void main(String[] args) {
        log.info("Eureka Server booting ...");
        SpringApplication.run(EurekaServerApplication.class, args);
        log.info("Eureka Server booting finished ...");
    }
}
