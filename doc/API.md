# 1 Eureka调用服务失败
> 现象描述：Eureka配置之后，在Eureka所在地址访问可以看到其它服务已经注册成功，但是使用服务名称无法调用，报错
> nested exception is java.net.UnknownHostException
> 
问题解决：在RestTemplate配置上没有添加@LoadBanlanced注解，服务无法负载均衡。