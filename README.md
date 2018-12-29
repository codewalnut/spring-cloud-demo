## 项目介绍（Introduce）
本项目演示SpringCloud最小必须配置、代码；用于学习研究用途。

## 依赖介绍（Dependency）
项目统一使用spring-boot-starter-log4j2作为日志框架。

## 使用说明（Usage）
依次启动：
- eureka-server，访问 http://localhost:8761
- config-server，访问 http://localhost:9000/encrypt/status
- zipkin-server，访问 http://localhost:9411
启动
- demo-service-inventory，访问 http://localhost:8100/api/version 
- demo-service-order，访问 http://localhost:8110/api/version
启动
- service-zuul，访问 http://192.168.1.88:8220/demo-service-inventory/api/version?token=1
                     http://192.168.1.88:8220/demo-service-order/api/version?token=1 ,
                     http://192.168.1.88:8220/demo-service-order/api/add?customerName=Kelvin&sku=%E6%89%8B%E6%9C%BA&amount=1&token=kelvin（生成订单）,
- service-turbine，访问 http://localhost:8300/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8300%2Fturbine.stream


## 目录结构（Structure）
- study-cloud-parent 父项目，定义公共的配置
- eureka-server 注册中心，规划端口：8761~8769
- config-server 配置中心演示项目，规划端口9000~9009
- monitor-server 监控项目，规划端口8000~8009
- gateway 路由网官演示项目，规划端口8220~8229
- zuul 路由网关演示项目，规划端口8230~8239
- turbine Turbine监控项目，规划端口8300~8309
- demo-service-inventory 库存模块的模拟服务，规划端口8100~8109
- demo-service-inventory-remote 库存模块的服务接口包
- demo-service-order 订单模块的模拟服务，规划端口8110~8119
- demo-service-order-remote 订单模块服务接口包

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