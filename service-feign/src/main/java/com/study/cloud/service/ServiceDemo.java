package com.study.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 服务抽象
 *
 * @author KelvinZ
 * @date 2018-10-31 16:49
 */
@FeignClient(value = "SERVICE-DEMO", fallback = ServiceDemoHystrix.class)
public interface ServiceDemo {

    /**
     * 服务A
     *
     * @param name
     * @return
     */
    @RequestMapping("/api/serviceA")
    String serviceA(@RequestParam("name") String name);

    /**
     * 服务B
     *
     * @param name
     * @return
     */
    @RequestMapping("/api/serviceB")
    String serviceB(@RequestParam("name") String name);

}
