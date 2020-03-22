# swagger-notes-annotation
#springboot swagger2 post请求map/json参数 和 map/json返回 自定义map注解实现
#参考路径：https://blog.csdn.net/a704397849/article/details/100123686
#注意：
#下面介绍的方法，我在本地idea运行没有问题，打包也能成功，但是上线到云服务器运行会启动失败报错：
#org.springframework.context.ApplicationContextException: Failed to start bean 'documentationPluginsBootstrapper'; nested exception is com.google.common.util.concurrent.ExecutionError: com.google.common.util.concurrent.ExecutionError: java.lang.NoClassDefFoundError: Lcom/example/swagger2_demo/bean/User;
#暂时未解决这个问题，如要使用请自行打包运行验证考虑是否使用！

#参考文章

#https://blog.csdn.net/q873297050/article/details/87895145

#springboot swagger2 post请求map/json参数 和 map/json返回 自定义map注解实现
