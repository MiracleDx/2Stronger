1. 什么是 Spring Framework
    《Spring 核心编程思想》第 12 讲

2. Spring Framework 有哪些核心模块

    - spring-core: Spring 基础 API 模块，如资源查找，泛型处理
    - spring-beans: Spring Bean 相关，如依赖查找，依赖注入
    - spring-aop: Spring AOP 处理，如动态代理，AOP 字节码提升
    - spring-context: 事件驱动、注解驱动，模块驱动等
    - spring-expression: Spring 表达式语言模块

3. Spring Framework 的优势和不足是什么
    《Spring 核心编程思想》全篇贯穿

4. IoC 编程思路有哪些实现方式

    - 依赖查找（有侵入性，性能低）
    - 依赖注入（侵入性小，性能高）
        - 构造器注入
        - 参数注入
        - Getter、Setter 注入
        - interface 注入
    - 上下文依赖查询
    - 模版方法设计模式（传统方式需要自己调用）
    - 策略模式

5. IoC 容器都有哪些职责

    ###### 通用职责

    - 依赖处理
        - 依赖查找
        - 依赖注入
    - 生命周期管理
        - 容器（容器自身的启动、停止等）
        - 托管的资源（Java Beans 或其它资源 -- 例：Spring 中的事件监听器、XML、properties等）
    - 配置
        - 容器（例：定时任务 -- 容器通知什么时候执行）
        - 外部化配置（属性配置 -- 例：XML）
        - 托管的资源（同上）
            -  Spring Boot 通过嵌入式的方式由 Spring 上下文影响到容器
            -  Spring MVC 是容器影响到 Spring MVC

6. IoC 容器有哪些实现

    ###### 主要实现

    -   Java SE
        -   Java Beans
        -   Java ServiceLoader SPI
        -   JNDI（Java Naming and Directory Interface）
    -   Java EE
        -   EJB（Enterpise Java Beans）
        -   Servlet
    -   开源
        -   Apache Avalon
        -   PicoContainer
        -   Google Guice
        -   Spring Framework

7. Spring 中的容器应该怎么理解，有哪些类型的容器

    容器指运行时启动的基础设施，比如传统 Spring MVC 在 Tomcat 容器或者 EJB 容器

8. 传统 IoC 容器的实现

    ###### Java Beans 作为IoC容器

    -   特性
        -   依赖查找
        -   生命周期管理
        -   配置元信息
        -   事件
        -   自定义
        -   资源管理
        -   持久化
    -   规范
        -   JavaBeans
        -   BeanContext
    
9. 什么是 IoC
   简单的说，IoC 是反转控制，类似于好莱坞原则，主要有依赖查找和依赖注入实现
   
10. 依赖查找和依赖注入的区别

   依赖查找是主动或手动的依赖查找方式，通常需要依赖容器或标准 API 实现

   依赖注入是手动或自动依赖绑定的方式，无需依赖特定的容器和 API 实现

11.  Spring 作为 IoC 容器有什么优势

     Spring 作为典型的 IoC 容器，具有依赖查找和依赖注入的功能。它还具有 AOP 抽象、事务抽象、事件机制、SPI 扩展、强大的第三方整合、易测试性、更好的面向对象

12.  Spring IoC 依赖查找都有哪些方式
     -   根据 Bean 名称查找
         -   实时查找
         -   延时查找
     -   根据 Bean 类型查找
         -   单个 Bean 对象
         -   集合 Bean 对象
     -   根据 Bean 名称 + 类型查找
     -   根据 Java 注解查找
         -   单个 Bean 对象
         -   集合 Bean 对象
     
13.  Spring Ioc 依赖注入
     -   根据 Bean 名称注入
     -   根据 Bean 类型注入
         -   单个 Bean 对象
         -   集合 Bean 对象
     -   注入容器内建 Bean 对象
     -   注入非容器内建 Bean 对象
     -   注入类型
         -   实时注入
         -   延迟注入
     
14.  Spring 容器依赖的三个来源

     -   自定义 Bean，可以通过 getBean 方法获取
     -   容器内建依赖的 Bean，如课程中的 useRepository 中的 BeanFactory，无法通过 getBean 方法获取，是通过 AutowireCapableFactory中的 resolveDependency 方法注册
         -   依赖，被组合的对象
     -   容器内建 Bean，如 Envrionment、BeanDefinitions 和 Singleton Objects 可以通过 getBean 获取
         -   内建（Built-in），是由 Spring IoC 容器内部生成的 Bean 或组件
     
15.  Spring IoC 配置元信息

     -   Bean 定义配置
         -   基于 XML 文件
         -   基于 Properties 文件
         -   基于 Java 注解
         -   基于 Java API
         -   基于 Groovy
     -   IoC 容器配置
         -   基于 XML 文件
         -   基于 Java 注解
         -   基于 Java API
     -   外部化属性配置
         -   基于 Java 注解

16.  BeanFactory 和 ApplicationContext 有什么区别

     -   ApplicationContext 是 BeanFactory的子接口
     -   BeanFactory 是一个底层的 IoC 容器，提供了 IoC 容器的基本实现。而 ApplicationContext 是 BeanFactory 的超集，提供了丰富的企业级特性
     -   ApplicationContext 委托 DefaultListableBeanFacory 实现 Bean 的依赖查找和依赖注入

17.  AbstractApplicationContext#prepareBeanFactory 中指明 beanFactory.registerResolvableDependency(BeanFactory.class, beanFactory)，说明当 byType 是 BeanFactory.class的时候，获取到的是 ApplicationContext 中的 DefaultListableBeanFactory 对象

18.  Spring 应用下文（ApplicationContext）除了 IoC 容器角色，还提供：

     -   面向切面（AOP）
     -   配置元信息（Configuration Metadata）
     -   资源管理（Resources）
     -   事件（Events）
     -   国际化（i18n）
     -   注解（Annotations）
     -   Environment 抽象（Environment Abstraction）