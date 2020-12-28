# JVM 核心技术-基础知识

## 什么是字节码

**Java bytecode** 由单字节（byte）的指令组成，理论上最多支持 256 个操作吗，实际上 Java 只使用了 200 左右的操作码，一些操作吗保留给调试操作

根据指令性质，分为4个大类

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







