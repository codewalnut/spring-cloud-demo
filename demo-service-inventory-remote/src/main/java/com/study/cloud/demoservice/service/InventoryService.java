package com.study.cloud.demoservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 库存服务
 *
 * @author Weway-RG001
 * @date 2018-11-20 20:34
 */
@FeignClient(value = "DEMO-SERVICE-INVENTORY", fallback = InventoryServiceHystrix.class)
public interface InventoryService {

    @RequestMapping("/api/inventory/add")
    boolean addInventory(@RequestParam("name") String name, @RequestParam("amount") int amount);

    @RequestMapping("/api/inventory/reduce")
    boolean reduceInventory(@RequestParam("name") String name, @RequestParam("amount") int amount);

}
