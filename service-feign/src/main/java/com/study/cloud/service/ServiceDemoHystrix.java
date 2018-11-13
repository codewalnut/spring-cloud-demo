package com.study.cloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 熔断服务类
 *
 * @author KelvinZ
 * @date 2018-10-31 19:30
 */
@Component
public class ServiceDemoHystrix implements ServiceDemo {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String serviceA(String name) {
        log.error("ServiceA falback for {}", name);
        return "ServiceA fallback for " + name;
    }

    @Override
    public String serviceB(String name) {
        log.error("ServiceB falback for {}", name);
        return "ServiceB fallback for " + name;
    }
}
