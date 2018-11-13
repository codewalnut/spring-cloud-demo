package com.study.cloud.controller;

import com.study.cloud.service.ServiceDemoApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author KelvinZ
 * @date 2018-10-30 19:26
 */
@RestController
public class ServiceController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ServiceDemoApiService serviceDemoApiService;

    @GetMapping("/serviceA")
    public String serviceA(@RequestParam String name) {
        log.info("ServiceA invoked: {}", name);
        return serviceDemoApiService.serviceA(name);
    }

    @GetMapping("/serviceB")
    public String serviceB(@RequestParam String name) {
        log.info("ServiceB invoked: {}", name);
        return serviceDemoApiService.serviceB(name);
    }

}
