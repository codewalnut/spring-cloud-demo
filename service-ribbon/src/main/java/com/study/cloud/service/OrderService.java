package com.study.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 正常服务方法加上熔断注解，声明了在方法失败的情况下，调用什么方法去做善后处理，避免产生“雪崩”效应
 *
 * @author KelvinZ
 * @date 2018-10-30 19:13
 */
@Service
public class OrderService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackAddOrder")
    public String addOrder(String name, int amount) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("name", name);
        params.put("amount", amount);
        return restTemplate.getForObject("http://DEMO-SERVICE-INVENTORY/api/order/add", String.class, params);
    }

    public String fallbackAddOrder(String name, int amount) {
        String reply = String.format("addOrder fallback for %s, %s", name, amount);
        log.error(reply);
        return reply;
    }

}
