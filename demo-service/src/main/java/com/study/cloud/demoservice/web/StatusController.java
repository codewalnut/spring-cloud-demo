package com.study.cloud.demoservice.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 状态监控控制器
 *
 * @author KelvinZ
 * @date 2018-10-25
 */
@RestController
@RequestMapping("/api")
@Api(tags = {"状态监控接口"})
public class StatusController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String appName;

    @ApiOperation(value = "服务在线检测", notes = "服务正常运行时会返回当前时间")
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String ping() {
        return new Date() + "@" + port;
    }


    @RequestMapping("/serviceA")
    public String serviceA(String name) {
        String reply = String.format("%s:%s | Service A was invoked!", appName, port, name);
        log.info(reply);
        return reply;
    }

    @RequestMapping("/serviceB")
    public String serviceB(String name) {
        String reply = String.format("%s:%s | Service B was invoked!", appName, port, name);
        log.info(reply);
        return reply;
    }

}
