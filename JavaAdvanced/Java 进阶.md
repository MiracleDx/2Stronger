# JVM 核心技术-基础知识

## 什么是字节码

**Java bytecode** 由单字节（byte）的指令组成，理论上最多支持 256 个操作吗，实际上 Java 只使用了 200 左右的操作码，一些操作码保留给调试操作

根据指令性质，分为 4 个大类

1.  栈操作指令，包括与局部变量交互的指令
2.  程序流程控制指令
3.  对象操作指令，包括方法调用指令
4.  算数运算及类型转换指令

编译：`javac xxx.java`

查看字节码：`javap -c xxx`

进一步查看字节码（可以看到版本号等信息）：`javap -c -verbose xxx`

特别注意：

-   aload、astore（a表示引用）表示从本地变量表加载到栈中，和运行后把栈中的值写回到本地变量表中

-   iload、istore 表示把本地变量表中 int 类型的值家在到栈中，和把栈中int类型的值写回到本地变量表中
-   iconst 表示 int 类型的常量
-   dstore 表示把 double 类型的变量写回到本地变量表中
-   i2d 表示把 int 类型转换为 double 类型
-   if_icmpge 表示条件语句判断 int 大于 for 的范围（cmp 比较、ge 大于）
-   iinc 表示一个 int 类型的自增 +1
-   goto 表示跳转

一个 int 32 位 = 4 个 byte

一个 long 64 位

一个 float 32 位

一个 double 64 位

*64 位机器处理 int 和 long 类型均为原子操作*

**算数操作**

|        | add + | Sub - | mult * | divide / | remainder % | negate -() |
| ------ | :---: | :---: | :----: | :------: | :---------: | :--------: |
| int    | iadd  |  sub  |  imul  |   idiv   |    irem     |    ineg    |
| long   | ladd  |  sub  |  lmul  |   ldiv   |    lrem     |    lneg    |
| float  | fadd  | fsub  |   f    |   fdiv   |    frem     |    fneg    |
| double | dadd  | dsub  |   d    |   ddiv   |    drem     |    dneg    |

**类型转换 （row 代表 to、col 代表 from）**

|        | int  | long | float | double | byte | char | short |
| ------ | :--: | :--: | :---: | :----: | :--: | :--: | :---: |
| int    |  -   | i2l  |  i2f  |  i2d   | i2b  | i2c  |  i2s  |
| long   | l2i  |  -   |  l2f  |  l2d   |  -   |  -   |   -   |
| float  | f2i  | f2l  |   -   |  f2d   |  -   |  -   |   -   |
| double | d2i  | d2l  |  d2f  |   -    |  -   |  -   |   -   |

## 字节码的运行时结构

JVM 是一台基于栈的计算机器

每个线程都有一个独属于自己的线程栈（JVM Stack），用于存储栈帧（Frame）

每次方法调用，JVM 都会自动创建一个栈帧

栈帧由操作数栈、局部变量数组以及一个 Class 引用组成

Class 引用指向当前方法在运行时常量池中对应的 Class

## 方法调用的指令

-   invokestatic，用于调用某个类的静态方法，是方法滴哦啊用指令中最快的一个
-   invokespecial，用于调用构造函数，也可以用于调用同一个类中的 private 方法 以及可见的超类方法
-   invokevirtual，如果是具体类型的目标对象，invokevirtual 用于调用公共，受保护和package级的私有方法
-   invokeinterface，当通过接口引用调用方法时，将会编译为 invokeinterface 指令
-   invokeddynamic，JDK7 新增指令，是实现“动态类型语言”（Dynamically Typed Language）支持而进行的升级改造，同时也是 JDK8 支持 lambda 表达式的实现基础

## 类的生命周期

1.  加载（Loading）：找 class 文件
2.  验证（Verification）：验证格式、依赖
3.  准备（Preparation）：静态字段、方法表
4.  解析（Resolution）：符号解析为引用
5.  初始化（Initialization）：构造器、静态变量赋值、静态代码块
6.  使用（Using）
7.  卸载（Unloading）

*验证、准备、解析*可归为链接（Linking）

## 类的加载时机

1.  虚拟机启动时，初始化用户指定的主类（main 方法所在的类）
2.  遇到新建目标类实例的 new 指令时，初始化 new 指令的目标类（new 一个类的时候需要初始化）
3.  遇到调用静态方式的指令时，初始化该静态方法所在的类
4.  遇到访问静态字段的指令时，初始化该静态字段所在的类
5.  子类的初始化会触发父类的初始化
6.  如果一个接口定义了 default 方法，那么直接实现或者间接实现该接口类的初始化，会触发该接口的初始化
7.  使用反射 API 对某个类进行反射调用时，初始化这个类（反射调用要么是已经有实例，要么是静态方法，都需要初始化）
8.  初次调用 MethodHandle 实例时，初始化该 MethodHandle 指向的方法所在的类

### 不会初始化的情况（可能会加载，但不会初始化）

1.  通过子类引用父类的静态字段，只会触发父类的初始化，而不会触发子类的初始化
2.  定义对象数组，不会触发该类的初始化
3.  常量在编译器间会存入调用类的常量池中，本质上并没有直接引用定义常量的类，不会触发定义常量所在的类
4.  通过类名获取 Class 对象，不会触发类的初始化，Hello.class 不会让 Hello 类初始化
5.  通过 Class.forName 加载指定类时，如果指定参数 initialize 为 false 时，也不会触发类初始化（该参数是告诉虚拟机，是否要对类进行初始化）。Class.forNzame("jvm.Hello") 默认会加载 Hello 类
6.  通过 ClassLoader 默认的 loadClass 方法，也不会触发初始化动作（加载但不初始化）

### 三类加载器

1.  启动类加载器（BootstrapCLassLoader）
    -   由 C++ 实现（针对 HotSpot），负责加载 <JAVA_HOME>/lib 目录或 -Xbootclasspath 参数指定的路径中的类库
2.  扩展类加载器（ExtClassLoader）
    -   负责加载  <JAVA_HOME>/lib/ext 或 java.ext.dirs 系统变量指定的路径中的所有类库
3.  应用类加载器（AppClassLoader）
    -   负责加载用户类路径 classpath 上的指定类库，如果没有自定义类加载器，默认使用这个加载器

加载器特点：

1.  双亲委派
    -   如果一个类加载器收到类加载的请求，首先不会自己去尝试加载该类，而是把这个请求委派给父类加载器完成。每个类加载都是如此，只有当父加载器在自己的搜索范围内找不到指定类时，子加载器才会尝试自己加载。
2.  负责依赖
3.  缓存加载

自定义类加载的应用场景：

1. 加解密 Class 文件
2. 资源隔离应用
3. 动态创建定制化构建类

### 添加引用类的几种方式

1.  放到 JDK 的 lib/ext 下，或者 -Djava.ext.dirs
2.  java -cp/classpath 或者让 class 文件放到当前路径
3.  自定义 ClassLoader 加载
4.  拿到当前执行类的 ClassLoader，反射调用 addUrl 方法添加 Jar 或路径（JDK9 无效）

## JVM 内存模型

### JVM 内存结构

-   每个线程都只能访问自己的线程栈
-   每个线程都不能访问（看不见）其他线程的局部变量
-   所有原生类型的局部变量都存储在线程栈中，因此对其他线程是不可见的
-   线程可以将一个原生变量值的副本传给另一个线程，但不能共享局部变量本身
-   堆内存中包含了 Java 代码中创建的所有对象，不管是哪个线程创建的。其中也涵盖了包装类型（例如 Byte， Integer， Long）等
-   不管是创建一个对象并将其复制给局部变量，还是赋值给另一个对象的成员变量，创建的对象都会被保存到堆内存中
-   如果是原生数据类型的局部变量，那么它的内容就全部保留在线程栈上
-   如果是对象引用，则栈中的局部变量槽位中保存着对象的引用地址，而实际的对象内容保存在堆中
-   对象的成员变量与对象本身一起存储在堆上，不管成员变量的类型是原生数值，还是对象引用
-   类的静态变量则和类定义一样都保存在堆中

**总结：**

1.  方法中使用的原生数据类型和对象引用地址在栈上存储；对象、对象成员与类定义、静态变量在堆上
2.  堆内存被多个线程共享，堆中的所有对象，可以被所有线程访问，只要该线程能拿到对象的引用地址
3.  如果一个线程可以访问某个对象时，也可以访问该对象的成员变量
4.  如果两个线程同时调用某个对象的同一方法，则他们都可以访问到这个对象的成员变量，但每个线程的局部变量副本是独立的

### JVM 内存整体结构

-   每启动一个线程， JVM 就会在栈空间栈分配对应的线程栈，比如 1MB 的空间（-Xss1m）
-   线程栈也叫做 Java 方法栈，如果使用了 JNI 方法，则会分配一个单独的本地方法栈（Native Stack）
-   线程执行过程中，一般会有多个方法组成调用栈（Stack Trace），比如 A 调用 B， B 调用 C 等，每执行到一个方法，就会创建对应的栈帧（Frame）
-   栈帧是一个逻辑上的概念，具体的大小在一个方法编写完成后能基本确定

**-Xmx4g 的 Java 进程实际使用可能会达到 5.x 到 6g 内存（栈、堆、非堆、JVM自身） ** ？？？？？ 

理论上：堆外可以用到和堆一样大的内存，但一般不用了这么多

一般 Xmx 不超过系统内存的 70%

### JVM 堆内存结构

-   堆内存是所有线程共用的内存空间，JVM 将 Heap 内存分为年轻代（Young generation）和老年代（Old generation，也叫 Tenured）两部分
-   年轻代划分为 3 个内存池，新生代（Eden Space）和存活区（Servivor Space），在大部分 GC 算法中有 2 个存活区（S0，S1），在可以观察到的任何时刻，S0 和 S1 总有一个是空的，但一般较小，不浪费空间
    -   年轻代、老年代的 GC 处理 一般是不同的（分代处理）
-   Non-Heap 本质上还是 Heap，只是一般不归分为 GC 管理，里面划分为 3 个内存池
-   Metaspace  元数据区（持久代、永久代 Permanent generation）
    -   常量池
     -   方法区

-   CCS（Compressed Class Space）存放 Class 信息，和 Metaspace 有交叉
-   Code Cache 存放 JIT 编译器编译后的本地机器代码

###  CPU 与内存行为

-   CPU 乱序执行
-   volatile 关键字
-   原子性操作
-   内存屏障

## 什么是 JMM

-   JMM 规范对应的是 JSR-133.Java Memory Model and Thread Specifiaction
-   JMM 规范明确定义不同的线程之间，通过哪些方式，在什么时候可以看见其他线程保存到共享变量中的值，以及在必要时，如何对共享变量的访问进行同步。这样的好处是屏蔽各种硬件平台的内存访问差异，实现 Java 并发程序真正的跨平台
-   JMM 规范的是线程间的交互操作，而不管线程内部对局部变量进行的操作
-   所有的对象（包括内部的实例成员变量），static 变量以及数组，都必须放到堆内存中
-   局部变量，方法的形参/入参，异常处理语句的入参不允许在线程之间共享，所以不受内存模型的影响
-   多个线程同时对一个变量访问时（读取/写入），只要有某个线程执行的是写操作，那么这种线程就称为“冲突”
-   可以被其他线程影响或感知的操作，称为线程间的交互行为，分为：读取、写入、同步操作、外部操作等。
    -   同步操作包括：对 volatile 变量的读写，对管程（monitor）的锁定与解锁，线程的起始操作与结尾操作，线程启动和结束等
    -   外部操作是指对线程执行环境之外的操作，比如停止其他线程等

## JVM 启动参数

-   以 - 开头为标准参数，所有的 JVM 都要实现这些参数，并且向后兼容
-   -D 设置系统属性
-   以 -X 开头为非标准实现参数，基本都是传递给 JVM 的，默认 JVM 实现这些参数的功能，但是不保证所有 JVM 实现都满足，且不保证向后兼容。可以使用 java -X 命令查看当前 JVM 支持的非标准参数
-   以 -XX: 开头为非稳定参数，专门用于控制 JVM 的行为，跟具体的 JVM 实现有关，随时可能会在下个版本取消
    -   -XX: +-Flags 形式，+-是对布尔值进行开关
    -   -XX: key=value 形式，指定某个选项的值

### JVM 启动参数的作用

1.  系统属性参数

    -   -Dfile.encoding=UTF-8
    -   -Duser.timezone=GMT+08
    -   -Dmaven.test.skip=true
    -   -Dio.nett.eventLoopThreads=8
    -   System.setProperty("a", "100")  String a = System.getProperty("a")
        -   Linux 上可以通过 a=100 java options 获取

2.  运行模式参数

    -   -server，设置 JVM 使用 server 模式，特点是启动速度比较慢，运行时性能和内存管理效率很高，适用于生产环境。在 64 位 JDK 环境下默认启用该模式，忽略 -client 参数
    -   -client，JDK1.7 之前在 x86 机器上的默认值。设置 JVM 使用 client 模式，特点是启动速度较快，但运行时性能和内存管理效率不高，通常用于客户端应用程序或者 PC 应用开发和调试
    -   -Xint，在解释模式（interpreted mode）下运行，-Xint 标记会强制 JVM 解释执行所有的字节码，会降低运行速度，通常低 10 倍或更多
    -   -Xcomp，-Xcomp 参数与 -Xint 正好相反，JVM 在第一次使用时会把所有的字节码编译成本地代码，从而带来最大程度的优化（注意预热）
    -   -Xmixed，-Xmixed 是混合模式，将解释模式和编译模式进行混合使用，由 JVM 自己决定。是 JVM 的默认模式，也是推荐模式。通过 java -version 可以看到 mixed mode 等信息

3.  堆内存设置参数

    -   -Xmx，指定最大堆内存。只是限制了 Heap 部分的最大值，该内存不包括栈内存，也不包括堆外使用内存
    -   -Xms，指定堆内存空间的初始大小。指定的内存大小，并不是操作系统实际分配的初始值，而是 GC 先规划好，用到才分配。专用服务器上需要保持 -Xms 和 -Xmx 保持一致，否则当应用刚启动可能会有几个 FullGC，当两者配置不一致时，堆内存扩容可能会导致性能抖动
    -   -Xmn，等价于 -XX:NewSize，使用 G1 垃圾收集器不应该设置该选项，在其他的某些业务场景下可以设置，官方建议设置为 -Xmx 的 1/2 ~ 1/4
    -   -XX:MaxPermSize=size，JDK1.7 之前使用。Java8 默认运行 Meta 空间无限大，此参数无效
    -   -XX:MaxMetaspaceSize=size，Java8 默认不限制 Meta空间，一般不允许设置该选项
    -   -XX:MaxDirectMemorySize，系统可以使用的最大堆内存，该参数与 -Dsun.nio.MaxDirectMemorySize 效果相同
    -   -Xss，设置每个线程栈的字节数，该参数与 -XX:ThreadStackSize 效果相同

4.  GC 设置参数

    -   JVM 启动参数 -- GC 相关

    -   -XX:+UseG1GC，使用 G1 垃圾回收器
    -   -XX:+UseConcMarkSweepGC，使用 CMS 垃圾回收器
    -   -XX:+UseSerialGC，使用串行垃圾回收器
    -   -XX:+UseParallelGC，使用并行垃圾回收器
    -   -XX:+UnlockExperimentalVMOptions -XX:+UseZGC，// Java 11+
    -   -XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC // Java 12+

5.  分析诊断参数

    -   -XX: +-HeapDumpOnOutOfMemoryError 选项，当 OutOfMemoryError 产生，即内存溢出（堆内存或持久代）时，自动 Dump 堆内存
    -   -XX: HeapDumpPath 选项，与 HeapDumpOnOutOfMemoryError 搭配使用，指定内存溢出时 Dump 文件的目录（如果没有指定则默认为启动 Java 程序的工作目录）
    -   自动Dump的 hprof 文件会存储到 /usr/local/ 目录下
    -   -XX:OnError 选项，发生致命错误时（fatal error）执行的脚本
    -   例如：通过脚本记录出错时间，执行一些命令或者 curl 某个在线报警的 url
    -   -XX: OnOutOfMemoryError 选项，抛出 OutOfMemoryError 错误时执行的脚本
    -   -XX: ErrorFile=filename 选项，致命错误的日志文件名，绝对路径或者相对路径
    -   -XDebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=1506 选成调试

6.  JavaAgent 参数

    Agent 是 JVM 中的黑科技，可以通过无侵入方式做很多事情，比如注入 AOP 代码，执行统计等，权限非常大。

    设置 Agent 的语法：

    -   -agentlib:libname[=options] 启用 native 方式的 agent，参考 LD_LIBRARY_PATH 路径
    -   agentpath:pathname[=options] 启动 native 方式的 agent
    -   -javaagent:jarpath[=options] 启用外部的 agent 库
    -   -Xnoagent 禁用所有 agent

