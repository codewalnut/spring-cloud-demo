## 项目介绍
本项目演示SpringCloud最小必须配置、代码；用于学习研究用途。

## 依赖介绍
略

## 使用说明
略

## 目录结构
- study-cloud-parent 父项目，定义公共的配置
- eureka-server 注册中心，使用端口876*
- demo-service-inventory 库存模块的模拟服务，使用端口810*
- demo-service-inventory-remote 库存模块的服务接口包
- demo-service-order 订单模块的模拟服务，使用端口811*
- demo-service-order-remote 订单模块服务接口包
- service-ribbon (rest+ribbon)服务调用演示项目，使用端口820*
- service-feign (Feign)服务调用演示项目，使用端口821*
- service-zuul 路由网关演示项目，使用端口822*
- service-turbine Turbine监控项目，使用端口830*
- config-server 配置中心演示项目，使用端口900*
- config-client 配置消费者演示项目，使用端口910*

## 常见问题
- @EnableDiscoveryClient vs @EnableEurekaClient
    @EnableDiscoveryClient基于spring-cloud-commons, @EnableEurekaClient基于spring-cloud-netflix。
    如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。

- 依赖其他服务的FeignClient接口包时，报Autowired找不到Bean的问题
    当服务消费端需要调用外部服务时，通常的做法是该服务提供一个相应的定义了FeignClient包，其他服务依赖这个包即可。
    但是由于包扫描会默认从注解的位置开始扫描。一般@EnableFeignClients的注解是加在*****Application启动类上面的，
    如果FeignClient包和Application不在一个包路径下，会出现Bean加载不到的情况，解决方法有两种：
    * 添加 @EnableFeignClients(basePackages = "com") 和 @ComponentScan(basePackages = {"com"})，进行显式声明；
    * 把*****Application的类移动到公共路径下，减少注解复杂度；


## 版本历史
+ 1.0.0 初始版本