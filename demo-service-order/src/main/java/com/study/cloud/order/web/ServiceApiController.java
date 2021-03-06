package com.study.cloud.order.web;

import com.study.cloud.order.config.ServiceConfiguration;
import com.study.cloud.order.domain.Order;
import com.study.cloud.order.service.OrderService;
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
@RequestMapping("/api")
@Api(tags = {"订单服务接口"})
public class ServiceApiController {
    private static final Logger log = LoggerFactory.getLogger(ServiceApiController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private ServiceConfiguration serviceConfiguration;

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/version")
    public String getVersion() {
        return serviceConfiguration.toString();
    }

    @RequestMapping("/add")
    public String add(String customerName, String sku, int amount) {
        String reply = String.format("%s:%s | %s make an order of %s(%s)", appName, port, customerName, sku, amount);
        log.info(reply);
        String ret = orderService.create(customerName, sku, amount);
        return ret;
    }

    @RequestMapping("/getAll")
    public Map<String, Order> getAll() {
        String reply = String.format("%s:%s | get order lists", appName, port);
        log.info(reply);
        return orderService.getAll();
    }

}
