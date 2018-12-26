package com.study.cloud.inventory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 使用了SpringSecurity后，服务注册时会遇到问题，需要关闭csrf才能正常注册上
 *
 * @author KelvinZ
 * @date 2018-12-06 14:49
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private String contextPath;

    @Autowired
    Environment env;

    /**
     * 仅对监控接口进行访问安全校验限制
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if (contextPath == null) {
            contextPath = env.getProperty("management.server.servlet.context-path");
        }

        if (contextPath == null) {
            contextPath = "";
        }

        http.csrf().ignoringAntMatchers(contextPath + "/actuator/**");
        http.authorizeRequests()
                .antMatchers(contextPath + "/actuator/**").authenticated()
                .anyRequest().permitAll()
                .and().httpBasic();
    }

}
