package com.study.cloud.demoservice.service;

/**
 * 类描述：
 *
 * @author Weway-RG001
 * @date 2018-11-21 15:16
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param customerName 客户名称
     * @param sku          单品
     * @param amount       数量
     * @return
     */
    String create(String customerName, String sku, int amount);

}
