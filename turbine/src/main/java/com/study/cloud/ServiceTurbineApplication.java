package com.study.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hystrix Turbine将每个服务Hystrix Dashboard数据进行了整合。
 *
 * @author KelvinZ
 * @date 2018-11-13 22:03
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableTurbine
public class ServiceTurbineApplication {
    private static final Logger log = LoggerFactory.getLogger(ServiceTurbineApplication.class);

    public static void main(String[] args) {
        log.info("<<<<<<<<< Turbine booting >>>>>>>>>");
        SpringApplication.run(ServiceTurbineApplication.class, args);
        log.info("<<<<<<<<< Turbine booting finished >>>>>>>>>");
    }

}
