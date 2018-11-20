package com.study.cloud.demoservice.web;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存服务接口
 *
 * @author KelvinZ
 * @date 2018-10-25
 */
@RestController
@RequestMapping("/api")
@Api(tags = {"库存服务接口"})
public class ServiceApiController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 模拟库存
     */
    private static int inventory = 10;

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String appName;

    /**
     * 显示库存
     *
     * @return
     */
    @RequestMapping("/inventory/show")
    public int show(String name) {
        String reply = String.format("%s:%s | %s show inventory: %s", appName, port, name, inventory);
        log.info(reply);
        return inventory;
    }

    /**
     * 增加库存
     *
     * @param name   用户名
     * @param amount 数量
     * @return
     */
    @RequestMapping("/inventory/add")
    public boolean add(String name, int amount) {
        boolean retVal;
        int b4Inventory = inventory;
        if (amount > 0) {
            inventory = inventory + amount;
            retVal = true;
        } else {
            retVal = false;
        }

        String reply = String.format("%s:%s | %s add inventory from %s to %s", appName, port, name, b4Inventory, inventory);
        log.info(reply);
        return retVal;
    }

    /**
     * 减少库存
     *
     * @param name   用户名
     * @param amount 数量
     * @return
     */
    @RequestMapping("/inventory/reduce")
    public boolean reduce(String name, int amount) {
        boolean retVal;
        int b4Inventory = inventory;

        if (inventory - amount > 0) {
            inventory = inventory - amount;
            retVal = true;
        } else {
            retVal = false;
        }
        String reply = String.format("%s:%s | %s reduce inventory from %s to %s", appName, port, name, b4Inventory, inventory);
        log.info(reply);
        return retVal;
    }

}
