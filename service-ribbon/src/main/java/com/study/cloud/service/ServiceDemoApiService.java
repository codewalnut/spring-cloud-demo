package com.study.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 正常服务方法加上熔断注解，声明了在方法失败的情况下，调用什么方法去做善后处理，避免产生“雪崩”效应
 *
 * @author KelvinZ
 * @date 2018-10-30 19:13
 */
@Service
public class ServiceDemoApiService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "serviceAError")
    public String serviceA(String name) {
        return restTemplate.getForObject("http://SERVICE-DEMO/api/serviceA?name=" + name, String.class);
    }

    public String serviceAError(String name) {
        log.error("ServiceA falback for {}", name);
        return "ServiceA fallback for " + name;
    }

    @HystrixCommand(fallbackMethod = "serviceBError")
    public String serviceB(String name) {
        return restTemplate.getForObject("http://SERVICE-DEMO/api/serviceB?name=" + name, String.class);
    }

    public String serviceBError(String name) {
        log.error("ServiceB falback for {}", name);
        return "ServiceB fallback for " + name;
    }

}
