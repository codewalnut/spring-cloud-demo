package com.study.cloud.demoservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 熔断服务类
 *
 * @author KelvinZ
 * @date 2018-11-20 20:37
 */
@Component
class InventoryServiceHystrix implements InventoryService {
    private static final Logger log = LoggerFactory.getLogger(InventoryServiceHystrix.class);

    @Override
    public boolean get(String sku) {
        log.error("get fallback {}", sku);
        return false;
    }

    @Override
    public Map<String, Integer> getAll() {
        log.error("getAll fallback");
        return null;
    }

    @Override
    public boolean add(String sku, int amount) {
        log.error("add fallback {}, {}", sku, amount);
        return false;
    }

    @Override
    public boolean reduce(String sku, int amount) {
        log.error("reduce fallback {}, {}", sku, amount);
        return false;
    }
}
