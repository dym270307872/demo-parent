此子项目主要用于演示cn:dyaoming.common:common-cache包的缓存部分使用。


具体操作流程可以参考csdn相关文章：https://blog.csdn.net/dym383140314/article/details/90230230


本项目以普通springmvc项目为基础框架，由于偏重是cache使用，所有基础框架为涉及数据库操作，以同等效果的随机数代替查询逻辑，查询条件一致的情况下，多次查询返还结果一致视为获取缓存。


在基础框架基础上，追加了spring-cache配置，重点是cacheDao的定义。所有实现CacheInterface接口的类都可以使用，不局限于redis。可以使用其他方式存储缓存内容。


另外，cache包中追加了加密逻辑，可以修改配置文件的secret变量控制是否加密，相关缓存命名空间可以无限扩展。并且支持临时缓存命名空间，只需要在方法上注解命名空间名称，系统会自动生成命名空间，并且按照默认缓存配置定义缓存事件及加密方式。


如果有疑问可以在项目上或csdn上留言咨询，也可以发邮件到：270307872@qq.com。
