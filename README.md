## 项目介绍（Introduce）
本项目演示SpringCloud最小必须配置、代码；用于学习研究用途。

## 依赖介绍（Dependency）
项目统一使用spring-boot-starter-log4j2作为日志框架。

## 使用说明（Usage）
略

## 目录结构（Structure）
- study-cloud-parent 父项目，定义公共的配置
- eureka-server 注册中心，规划端口：8761~8769
- demo-service-inventory 库存模块的模拟服务，规划端口8100~8109
- demo-service-inventory-remote 库存模块的服务接口包
- demo-service-order 订单模块的模拟服务，规划端口8110~8119
- demo-service-order-remote 订单模块服务接口包
- service-zuul 路由网关演示项目，规划端口8220~8229
- service-turbine Turbine监控项目，规划端口8300~8309
- config-server 配置中心演示项目，规划端口9000~9009
- config-client 配置消费者演示项目，规划端口9100~9109

## 常见问题(FAQ)
- @EnableDiscoveryClient vs @EnableEurekaClient
    @EnableDiscoveryClient基于spring-cloud-commons, @EnableEurekaClient基于spring-cloud-netflix。
    如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。

- 依赖其他服务的FeignClient接口包时，报Autowired找不到Bean的问题
    当服务消费端需要调用外部服务时，通常的做法是该服务提供一个相应的定义了FeignClient包，其他服务依赖这个包即可。
    但是由于包扫描会默认从注解的位置开始扫描。一般@EnableFeignClients的注解是加在*****Application启动类上面的，
    如果FeignClient包和Application不在一个包路径下，会出现Bean加载不到的情况，解决方法有两种：
    * 添加 @EnableFeignClients(basePackages = "com") 和 @ComponentScan(basePackages = {"com"})，进行显式声明；
    * 把*****Application的类移动到公共路径下，减少注解复杂度；

- 在properties或者yaml的值表达式里面，出现形如${REGISTRY_SERVER_PASSWORD:abcd1234}的写法时，表示尝试去读取冒号前的变量值，如果读取不到则用冒号后面的作为默认值。

- 如何从配置中心刷新配置：访问任何一个配置客户端的 http://host:port/actuator/bus-refresh

- 在配置中心配置encrypt.key可以对配置进行加解密，加解密可以在敏感值前面加上{cipher}，.yml配置文件需要使用单引号括起来要解密的内容，.properties文件中的加密值不得用引号括起来。否则，该值不会被解密。

## 版本历史(History)
+ 1.0.0 初始版本