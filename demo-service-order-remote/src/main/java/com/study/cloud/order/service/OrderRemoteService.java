package com.study.cloud.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 订单服务
 *
 * @author KelvinZ
 * @date 2018-11-22 18:42
 */
@FeignClient(value = "DEMO-SERVICE-ORDER", fallback = OrderRemoteServiceHystrix.class)
public interface OrderRemoteService {

    /**
     * 创建订单
     *
     * @param customerName 客户名称
     * @param sku          单品
     * @param amount       数量
     * @return 创建结果
     */
    @RequestMapping("/api/order/add")
    String add(@RequestParam("customerName") String customerName, @RequestParam("sku") String sku, @RequestParam("amount") int amount);

}
