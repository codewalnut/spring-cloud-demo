package com.study.cloud.controller;

import com.study.cloud.service.ServiceDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述：
 *
 * @author KelvinZ
 * @date 2018-10-31 16:52
 */
@RestController
public class ServiceController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ServiceDemo serviceDemo;

    @GetMapping("/serviceA")
    public String serviceA(String name) {
        log.info("ServiceA invoked: {}", name);
        return serviceDemo.serviceA(name);
    }

    @GetMapping("/serviceB")
    public String serviceB(String name) {
        log.info("ServiceB invoked: {}", name);
        return serviceDemo.serviceA(name);
    }

}
