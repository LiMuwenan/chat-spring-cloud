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

# 3 openFeign调用服务失败，报各种FeignExceptionNotFound错误
> 现象描述：配置都正确，接口正确，但是报错
> 
问题解决：GET接口，path定义接口比正式传递的参数多

# 4 java.sql.SQLIntegrityConstraintViolationException，Duplicate entry 'ligen2' for key 'auth.auth_uname'
> 现象描述：新建用户时生成密码，向auth表中插入一条认证信息，但是uname字段并不是主键，却报重复键的错误
> 
问题解决：auth表的索引中有一个以uname建立的索引导致重复uname无法插入报错

# 5 启动nacos各种报错。db.num is null & unable web sever start
> 现象描述：windows启动nacos报错
> 
问题解决：第一步：将startup.cmd的MODE从cluster修改为standalone；第二步：本地新建nacos数据库，从properites中配置数据库地址

# 6 nacos server启动正常，但是项目服务启动不能连接到server
> 现象描述：关闭了本地虚拟机网卡设置，nacos server项目启动显示在本地ip地址监听
> 然后启动项目服务，但是会报Server check fail, please check server localhost ,port 9848 is available , error ={}错误
> 以及Waited 3000 milliseconds (plus 13 milliseconds, 87300 nanoseconds delay)等错误
> 
问题解决：最终使用了nacos server 2.0.4，alibaba版本2021.0.4.0，discovery 2.0.4，吐了真的

# 7 eureka包中包含了loadbalancer，更换nacos后要单独引入loadbalancer
> 现象描述：单独引入loadbalancer后，服务调用不到，没有具体报错信息
> 
问题解决：google了一下，发现nacos包中包含了ribbon，没有报冲突，但是导致了服务调用出错。排除了ribbon就没问题了