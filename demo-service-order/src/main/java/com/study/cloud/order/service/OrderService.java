package com.study.cloud.order.service;

import com.study.cloud.order.domain.Order;

import java.util.Map;

/**
 * 订单服务
 *
 * @author KelvinZ
 * @date 2018-11-21 15:16
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param customerName 客户名称
     * @param sku          单品
     * @param amount       数量
     * @return 生成结果
     */
    String create(String customerName, String sku, int amount);

    /**
     * 获取所有订单
     *
     * @return
     */
    Map<String, Order> getAll();

}
