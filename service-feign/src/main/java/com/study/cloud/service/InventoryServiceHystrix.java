package com.study.cloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 熔断服务类
 *
 * @author Weway-RG001
 * @date 2018-11-20 20:37
 */
@Component
public class InventoryServiceHystrix implements InventoryService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String addInventory(String name, int amount) {
        String reply = String.format("AddInventory fallback %s, %s", name, amount);
        log.error(reply);
        return reply;
    }

    @Override
    public String reduceInventory(String name, int amount) {
        String reply = String.format("ReduceInventory fallback %s, %s", name, amount);
        log.error(reply);
        return reply;
    }
}
