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
