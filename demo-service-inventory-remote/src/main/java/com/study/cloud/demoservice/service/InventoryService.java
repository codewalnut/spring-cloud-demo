package com.study.cloud.demoservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 库存服务
 *
 * @author KelvinZ
 * @date 2018-11-20 20:34
 */
@FeignClient(value = "DEMO-SERVICE-INVENTORY", fallback = InventoryServiceHystrix.class)
public interface InventoryService {

    /**
     * 查询库存数量
     *
     * @param sku 单品
     * @return
     */
    @RequestMapping("/api/inventory/get")
    boolean get(@RequestParam("sku") String sku);

    /**
     * 获得库存清单
     *
     * @return
     */
    @RequestMapping("/api/inventory/get")
    Map<String, Integer> getAll();

    /**
     * 加库存
     *
     * @param sku    单品
     * @param amount 数量
     * @return
     */
    @RequestMapping("/api/inventory/add")
    boolean add(@RequestParam("sku") String sku, @RequestParam("amount") int amount);

    /**
     * 减库存
     *
     * @param sku    单品
     * @param amount 数量
     * @return
     */
    @RequestMapping("/api/inventory/reduce")
    boolean reduce(@RequestParam("sku") String sku, @RequestParam("amount") int amount);

}
