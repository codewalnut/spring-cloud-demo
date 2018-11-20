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
public class OrderServiceHystrix implements OrderService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String addOrder(String name, int amount) {
        String reply = String.format("AddOrder fallback %s, %s", name, amount);
        log.error(reply);
        return reply;
    }

}
