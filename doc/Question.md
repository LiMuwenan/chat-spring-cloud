# 1 Eureka调用服务失败
> 现象描述：Eureka配置之后，在Eureka所在地址访问可以看到其它服务已经注册成功，但是使用服务名称无法调用，报错
> nested exception is java.net.UnknownHostException
>
问题解决：在RestTemplate配置上没有添加@LoadBanlanced注解，服务无法负载均衡。

# 2 openFeign调用服务不完美，但是报FeignExceptionNotFound
> 现象描述：配置了openFeign的client，和目标服务controller一致，目标服务的controller上使用@RequestMapping
> 目标服务A接口只使用了@RequestMapping，接口A转发请求到接口B，接口B使用了@ResponseBody
> 目标服务A能够被调用，但是主服务报了错
> 
问题解决：转发出去的服务不能是@ResponseBody