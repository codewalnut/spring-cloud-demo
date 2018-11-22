package com.study.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 订单服务
 *
 * @author KelvinZ
 * @date 2018-10-31 16:49
 */
@FeignClient(value = "DEMO-SERVICE-ORDER", fallback = OrderApiServiceHystrix.class)
public interface OrderApiService {

    /**
     * 添加订单服务
     *
     * @param name
     * @param amount
     * @return
     */
    @RequestMapping("/api/order/add")
    String addOrder(@RequestParam String name, @RequestParam int amount);

}
