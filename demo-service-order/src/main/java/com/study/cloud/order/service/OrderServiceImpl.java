package com.study.cloud.order.service;

import com.study.cloud.inventory.service.InventoryRemoteService;
import com.study.cloud.order.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 订单服务实现
 *
 * @author KelvinZ
 * @date 2018-11-21 15:26
 */
@Service
public class OrderServiceImpl implements OrderService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InventoryRemoteService inventoryRemoteService;

    private static Map<String, Order> orders = new HashMap<>();

    @Override
    public String create(String customerName, String sku, int amount) {
        boolean inventorySuccess = inventoryRemoteService.reduce(sku, amount);
        if (inventorySuccess) {
            String orderNo = UUID.randomUUID().toString();
            Order order = new Order(orderNo, customerName, sku, amount);
            orders.put(order.getOrderNo(), order);
            log.info("Order: {} created!", order);
            return String.format("Order: %s created!", order);
        } else {
            log.warn("Order failed to create because lack of stock");
            return "Order failed to create because lack of stock";
        }
    }

    @Override
    public Map<String, Order> getAll() {
        return orders;
    }

}
