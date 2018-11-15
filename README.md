## 项目介绍
本项目演示SpringCloud最小必须配置、代码；用于学习研究用途。

## 依赖介绍
略

## 使用说明
略

## 目录结构
- study-cloud-parent 父项目，定义公共的配置
- eureka-server 注册中心
- demo-service 服务提供演示项目，向注册中心注册成为具体服务
- service-ribbon (rest+ribbon)服务调用演示项目
- service-feign (Feign)服务调用演示项目
- service-zuul 路由网关演示项目
- config-server 配置中心演示项目
- config-client 配置消费者演示项目

## 常见问题
- @EnableDiscoveryClient vs @EnableEurekaClient
    @EnableDiscoveryClient基于spring-cloud-commons, @EnableEurekaClient基于spring-cloud-netflix。
    如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。


## 版本历史
+ 1.0.0 初始版本