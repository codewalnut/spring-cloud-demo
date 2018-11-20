package com.study.cloud.demoservice.web;

import com.study.cloud.demoservice.service.InventoryService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 库存服务接口
 *
 * @author KelvinZ
 * @date 2018-10-25
 */
@RestController
@RequestMapping("/api")
@Api(tags = {"订单服务接口"})
public class ServiceApiController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InventoryService inventoryService;

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/order/add")
    public String add(String name, int amount) {
        String reply = String.format("%s:%s | %s make an order of %s", appName, port, name, amount);
        log.info(reply);
        if (inventoryService.reduceInventory(name, amount)) {
            String orderNo = UUID.randomUUID().toString();
            log.info("Order: {} created!", orderNo);
        } else {
            log.warn("Order failed to create because inventory is not enough");
        }
        return reply;
    }

}
