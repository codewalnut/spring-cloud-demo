package com.study.cloud.demoservice.web;

import com.study.cloud.demoservice.exception.InventoryException;
import com.study.cloud.demoservice.service.InventoryService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 库存服务接口
 *
 * @author KelvinZ
 * @date 2018-10-25
 */
@RestController
@RequestMapping("/api/inventory")
@Api(tags = {"库存服务接口"})
public class ServiceApiController {
    private static final Logger log = LoggerFactory.getLogger(ServiceApiController.class);

    @Autowired
    private InventoryService inventoryService;

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String appName;

    /**
     * 显示库存
     *
     * @return
     */
    @RequestMapping("/get")
    public int get(String sku) {
        int stock = inventoryService.get(sku);
        log.info(String.format("%s:%s | get %s inventory: %s", appName, port, sku, stock));
        return stock;
    }

    @RequestMapping("/getAll")
    public Map<String, Integer> getAll() {
        Map inventory = inventoryService.getAll();
        log.info(String.format("%s:%s | get all inventory: %s", appName, port, inventory));
        return inventory;
    }

    /**
     * 增加库存
     *
     * @param sku    单品
     * @param amount 数量
     * @return
     */
    @RequestMapping("/add")
    public boolean add(String sku, int amount) {
        try {
            int stock = inventoryService.add(sku, amount);
            log.info(String.format("%s:%s | add %s inventory from to %s", appName, port, sku, stock));
            return true;
        } catch (InventoryException e) {
            log.info(e.getMessage());
            return false;
        }
    }

    /**
     * 减少库存
     *
     * @param sku    单品
     * @param amount 数量
     * @return
     */
    @RequestMapping("/reduce")
    public boolean reduce(String sku, int amount) {
        try {
            int stock = inventoryService.reduce(sku, amount);
            log.info(String.format("%s:%s | reduce %s inventory from to %s", appName, port, sku, stock));
            return true;
        } catch (InventoryException e) {
            log.info(e.getMessage());
            return false;
        }
    }

}
