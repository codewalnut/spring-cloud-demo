package com.study.cloud.demoservice.service;

import com.google.common.base.MoreObjects;
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
 * @author Kelvin
 * @date 2018-11-21 15:26
 */
@Service
public class OrderServiceImpl implements OrderService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InventoryService inventoryService;

    private static Map<String, Order> orders = new HashMap<>();

    @Override
    public String create(String customerName, String sku, int amount) {
        boolean inventorySuccess = inventoryService.reduce(sku, amount);
        if (inventorySuccess) {
            String orderNo = UUID.randomUUID().toString();
            Order order = new Order(orderNo, customerName, sku, amount);
            orders.put(order.orderNo, order);
            log.info("Order: {} created!", order);
            return String.format("Order: %s created!", order);
        } else {
            log.warn("Order failed to create because lack of stock");
            return "Order failed to create because lack of stock";
        }
    }

    class Order {
        String orderNo;
        String customerName;
        String sku;
        int amount;

        public Order(String orderNo, String customerName, String sku, int amount) {
            this.orderNo = orderNo;
            this.customerName = customerName;
            this.sku = sku;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("orderNo", orderNo)
                    .add("customerName", customerName)
                    .add("sku", sku)
                    .add("amount", amount)
                    .toString();
        }
    }

}
