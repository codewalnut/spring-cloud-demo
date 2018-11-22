package com.study.cloud.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单服务熔断
 *
 * @author KelvinZ
 * @date 2018-11-22 18:42
 */
public class OrderRemoteServiceHystrix implements OrderRemoteService {
    private static final Logger log = LoggerFactory.getLogger(OrderRemoteServiceHystrix.class);

    @Override
    public String add(String customerName, String sku, int amount) {
        log.error("get fallback {}", sku);
        return "FALLBACK";
    }

}
