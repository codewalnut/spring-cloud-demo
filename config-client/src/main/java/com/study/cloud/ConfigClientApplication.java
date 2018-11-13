package com.study.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Config Client 项目
 *
 * @author KelvinZ
 * @date 2018-11-13 22:03
 */
@SpringBootApplication
@RestController
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${test}")
    private String test;

    @RequestMapping(value = "/test")
    public String test() {
        return test;
    }

}
