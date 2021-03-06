# 瀑布模式

**瀑布模式的定义**：研发的整个工作流程都是按顺序进行的。为了应对变化，就增加了一系列流程，例如变更流程管理、文档审批等应对和限制变更

瀑布模式饱受诟病的三点：

1.  研发周期过长，研发跟不上业务发展的节奏
2.  研发不能很好的响应需求，导致客户满意度低
3.  不能很好的管控风险

*瀑布模式更适合确定性高的工作*

VUCA 时代

	- 易变（volatility）
	- 不确定（uncertainty）
	- 复杂（complexity）
	- 模糊（ambiguity）

# 敏捷模式

敏捷 = 价值观 + 原则 + 一系列符合价值观和原则的方法。

1.  单纯说敏捷是一种方法，肯定是片面的；
2.  但只强调价值观和原则，而不重视方法也是不对的，因为那样敏捷就飘在空中，不能落地

敏捷术语：

-   史诗
    -   一个非常大的用户故事，可能需要数月才能完成
    -   在适当的时候，可以被拆分为很多小的用户故事
    -   理解史诗的两个关键点
        1.  非常大
        2.  还没想清楚里面的细节
-   特性
    -   规模介于史诗和用户故事之间
    -   是一组用户故事的集合，这些用户故事组成了一个完整的功能，通过特性将相关的用户故事连接起来
    -   产品对外发布的时候，往往更关注特性的完成情况
    -   理解特性的两个关键点
        1.  比较大
        2.  已经想清楚里面的细节
-   故事
    -   核心在于从渴望新功能的人的角度对功能进行简短的描述
    -   足够小，小到一个迭代周期内能够完成（0～3天）
    -   关注的是交付给客户的最终价值
    -   遵循模版：作为<用户类型>，我想要<一些目标>，以便<一些原因>
-   任务
    -   通常是故事的具体拆分
    -   完成用户需求的过程性的工作
    -   表示用户故事开发任务的完成
    -   关注于实现和交付由用户故事所体现出的客户价值的技术和底层细节
-   缺陷
    -   主要针对测试中的缺陷或者已发布版本的缺陷

## 理解敏捷

### 敏捷的价值观：正确理解敏捷的初心

**5 条价值观：**

1.  个体和交互**胜过**过程和工具

2.  可以工作的软件**胜过**面面俱到的文档

    *敏捷重视可工作的、有价值的软件，减少一切不必要的文档。不是所有文档*

3.  客户合作胜过合同谈判

4.  响应变化**胜过**遵循计划

5.  虽然右项有价值，但更重视左项

    *左面是敏捷更重视的，但不是停止做右面的内容*

敏捷通过一系列方法来让研发工作更加灵活、有序和高效，所以它的价值观重视人的能动性，强调人与人之间的协作，也更重视对变化的应对，这些都是为了能够更好、更灵活地组织和管理研发工作

### 敏捷的原则：正确理解敏捷的基石

**12 条原则**

1.  我们最优先要做的是通过尽早的、持续的交付有价值的软件来使客户满意
2.  即使到了开发的后期，也欢迎改变需求。敏捷过程利用变化来为客户创造竞争优势
3.  经常性地交付可以工作的软件，交付的间隔可以从几个星期到几个月，交付的时间间隔越短越好
4.  在整个项目开发期间，业务人员和开发人员必须天天都在一起工作
5.  围绕被激励起来的个体来构建项目。给他们提供所需的环境和支持，并且信任他们能够完成工作
6.  在团队内部，最具有效果并且富有效率的传递信息的方法，就是面对面的交谈
7.  工作的软件是首要的进度度量标准
8.  敏捷过程提倡可持续的开发速度。人、开发者和用户应该能够保持一个长期的、恒定的开发速度
9.  不断地关注优秀的技能和好的设计会增强敏捷能力
10.  简单——使未完成的工作最大化的艺术——是根本的
11.  最好的构架、需求和设计出自于自组织的团队
12.  每隔一定时间，团队会在如何才能更有效地工作方面进行反省，然后相应地对自己的行为进行调整

**敏捷中的“快”其实指的是反馈更快，反馈更及时**

如何才能保持“可持续的开发速度”？

	1. 在迭代开始的时候，不会过度承诺，也就是能完成多少工作，就承诺多少工作
 	2. 严格遵守纪律。在迭代开始以后，原则上不会再增加需求，如果一定要往他们的迭代待办事项列表里增加其它需求，就要同时从中拿走等量的需求

### 敏捷的方法：正确落地敏捷的基础

一些敏捷方法：极限编程、Scrum、特征驱动开发、动态系统开发方法、自适应软件开发，以及水晶方法等

Scrum 在新软件开发中更好用，而看板在维护类的软件开发中更胜一筹

使用敏捷的不同方法前，自问 3 个问题：

1.  这个方法能解决什么样的问题？
2.  有没有使用前提？
3.  有没有相应的使用规则？

#### Scrum 框架的组成

 - 3 个角色
    1.  产品负责人
    2.  团队
    3.  ScrumMaster
 - 3 个工件
    1.  产品待办事项列表
    2.  迭代待办事项列表
    3.  产品增量
 - 5 个会议
    1.  迭代计划会议
    2.  每日站会
    3.  迭代回顾会议
    4.  迭代评审会议
    5.  产品 Backlog 梳理会议
 - 5 个价值
     1.  承诺
     2.  专注
     3.  开放
     4.  尊重
     5.  勇气

Scrum 的约束条件（最重要的两条）：

	1. 在迭代计划会议开始前，产品负责人需要准备好需求条目，使需求达到准入标准
 	2. Scrum 讲究时间盒，包括迭代的周期、各个会议，这些都要遵守时间盒的约定

## 推进敏捷

敏捷推进的三个阶段

1.  做敏捷（doing agile）
2.  思考敏捷（thinking agile）
3.  思想敏捷（being agile）

从全局考虑推进：

1.  在前期，要做好诊断和规划，在解决痛点的基础上导入适合的敏捷方法
2.  推进过程可以分步进行，但要及时排查每一步中可能出现的新的障碍
3.  要加强协作，打通研发管理的全链条，必要时要成立高层参与的督导团队，请高层领导帮忙推动
4.  在整个实践过程中，都需要有能力的敏捷教练陪伴，并培养出适合团队的 Scrum Master

### 评估诊断

目的是在转型之前，让企业或者团队了解自己的现状、存在的问题和痛点

评估诊断的方法步骤：

1.  挑选代表性项目

2.  访谈评估

    对项目团队成员进行访谈，从流程、组织、人员技能、度量和技术等维度，对项目进行深度评估

3.  制定转型计划

    根据访谈评估中发现的具体问题和痛点，有针对性地做推进敏捷的计划，形成后面转型工作的蓝图

4.  沟通

    实践前与相关干系人员，沟通评估结果和相应计划，以便整个团队达成一致意见

### 团队敏捷试点

#### 试点前准备（迭代 0）

调整好结构、组织好人员、划定好需求、搭建好架构、选择好方法和工具、布置好办公环境

1.  如何做好试点前的准备
    1.  选择试点团队
    2.  采纳敏捷的意愿相对强烈
    3.  业务价值高或采纳敏捷会在短期内给团队带来很大收益

2.  前期准备工作细则

    -   组织和人员

        -   人员：直接关乎了敏捷试点乃至整个敏捷推进工作能否成功

        -   组织：高内聚，低耦合
             -   高内聚指的是日常工作中，全功能小团队内、小团队内部成员之间的沟通合作更紧密
             -   低耦合则指的是，团队之间的沟通协作要远比团队内部的少

    -   管控治理规则

        架构和设计的治理规则，质量管理策略规则等

    -   需求范围

        -   项目的高阶需求范围、高阶发布计划
        -   高阶的史诗级故事
        -   近期 2 个迭代要开发的用户故事，要有优先级排序

    -   架构

        根据初始需求做架构建模

    -   敏捷方法和工具

        工作过程管理工具，主要指研发作业流程管理工具，比如 Jira 和 Trello 等，Jenkins 做持续集成，SonaQube 做代码扫描

    -   办公环境设施

        开放工位、物理看板

#### 推进敏捷试点

核心关键点：打造一支活力与战斗力并存的敏捷团队

**一起制定“社会契约（Social Contract）”**，保证团队工作的有序和高效

指的就是团队里的行为公约，就是为了让团队中每个成员都能加强协作、发挥价值，一起来约定的一些基本准则

**回顾会议，引导团队的自主性**，导团队成员自发思考，激发大家的自主性，使工作变得更顺畅

如何开展回顾会议：会议开始后，说明会议的目的，讨论三个条目

	1. 团队工作中做得好的地方是什么
 	2. 做得不好的地方又是什么
 	3. 除此之外，有没有什么其它疑问

一起头脑风暴决定怎么去改善，并做一些行动计划

**成绩墙与错题集，记录团队敏捷的成长**，记录团队的成长，总结敏捷实践中的经验

在推进敏捷的过程中记录自己的心情曲线，以及取得的成绩和犯下的错误，也记录着团队的成长

### 大规模推广

规模化推广≠直接复制试点经验

规模化推广的正确方法

1.  SaFe （Scaled Agile Framework）
2.  LeSS（Large Scale Scrum）

从企业或团队的痛点切入：

	- 选择合适的规模化推广策略
	- 做好敏捷文化铺垫，培养好敏捷的中坚力量
	- 搭建适合敏捷的工作环境，做好必要的工具和自动化准备
	- 组织级别的敏捷度量以及持续改进
	- 重视大型团队的敏捷导入与推广

只有业务敏捷，才能短时间内快速交付业务价值

大型团队敏捷的导入和推广，首先要打造端到端的、从需求到开发到测试到运维到运营的敏捷全生命周期，向业务敏捷靠拢

## 什么是真正的敏捷

**真正的敏捷：**团队尽可能有效拆分需求，先完成最有价值、优先级最高的需求。进入到迭代的需求是多个独立的小需求。每个小需求都可以在很短的时间内完成，比如 2 ～ 3 天内，完成开发和测试，最多不超出一个迭代周期（两周）。开发人员写代码的时候，测试人员在同步写测试案例。在测试的同时，开发人员在开发下一个需求，形成良好循环

做需求拆分的目的，都是把大需求拆成一个个能够独立开发测试的小需求

**团队只是套用敏捷流程，或是没有做好需求拆分，敏捷很容易变成“小瀑布”**

**敏捷工作的结束点不应该是把之前所有计划的工作做完，而是把客户需要的工作做完**

如何**拆分用户故事**是敏捷开发一个很关键的部分，而评估是否是一个好的用户故事标准就是**能否独立进行上线**，如果做不到独立上线，那这个还不叫用户故事，测试也没办法并行进行，也不是真正的敏捷开发

敏捷开发跟现在的微服务架构是相辅相成，敏捷开发非常适合微服务这种开发模式，微服务能够提高敏捷开发的效率

**敏捷开发的精髓是团队至上，小步快跑，快速迭代，拥抱变化**

## 内部敏捷教练为什么重要

敏捷教练：帮助组织或团队推进敏捷实践的人，需要具备4项能力。可归纳为**懂敏捷、能“教练”**

1.  教授（Teaching）
2.  引导（Facilitation）
3.  辅导（Mentoring）
4.  教练（Coaching）

懂敏捷指的是一名合格的敏捷教练，首先要有扎实、完备的敏捷知识，要有推进敏捷实践的经验和技术，这是能“教练”的基础

能“教练”指的是敏捷教练既要能教授团队什么是敏捷，给团队讲授基础的敏捷知识和这背后的意义；又要能给团队示范和辅导具体的实践怎么做，通过引导团队会议来引导团队推进敏捷；同时，还能用一定的技巧来引导和启发团队去主动思考，主动改良自己的工作

很多企业或团队在引进和推进敏捷时，由于内部很少有真正懂的人，一旦外部教练退场，再遇到问题，往往就失去了领头羊，导致在推进过程中缺少必要的持续性引导和辅助，最终只能走向失败

**如何培养内部敏捷教练**

**基础培训**

目的是通过一系列培训课程（基础培训、设计思维培训和产品负责人培训）了解足够多的敏捷知识

在培训里，会建立起敏捷的基本概念，了解敏捷和设计思维是什么以及应该怎么做；学习关于产品管理的一系列基础知识，以便能更好地与产品负责人沟通，帮助他们一起做敏捷。在培训之后，初级教练会自己去实践，有问题可以向同行或者高级教练请教

**安排实战工作坊**

实战工作坊只是个开始和模拟演练，初级教练会在后面的工作中，开展具体的实践，进一步掌握敏捷教练所需要的各种技能

**线上活动加力**

对于没有时间参加几整天实战工作坊的初级教练来说，是一个非常不错的补充

**一对一的教练服务**

一对一的专属教练服务会让初级教练更快地成长，也是他们成长为中高级教练更为专业的进阶方式

辅导过程可以设计成 4 步：

1.  签署教练协议
2.  进行评估
3.  一对一的教练服务
4.  成果展示

## 服务型领导

服务型领导的管理理念：理解员工并为员工服务，与员工精诚合作

	1. 首先要是一个服务者，要为整个团队服务，拉近自己与员工的心理距离，这样才会取得团队的信任
 	2. 从管理目标上来说，目标是和团队成员共同成长，所以做任何事的首要动机都是为团队中大多数人谋取利益，因此团队成员才更愿意努力工作并更好的完成工作

### 怎样成为服务型领导

**给员工建立心理安全机制**

-   信任是必不可少的。要支持员工和他们的决定，在工作和工作之外都照顾好团队成员

-   培养健康的分歧环境。允许分歧存在，在有分歧时虚心听取不同的意见

-   建立正确的失败文化。失败是可以接受的，只要从失败中吸取教训，能够改进就好

**掌握情境领导能力**

领导者能在不同的情境下运用不同的领导力来指导和支持团队成员完成目标或任务

领导者通常会面对 4 种不同的情境，或者说面对特定的任务，团队成员会有4 种状态

-   情境 1：热情的初学者
-   情境 2：幻灭的学习者
-   情境 3：有能力但谨慎的贡献者
-   情境 4：自力更生的成功者

每种情景中，团队成员有各自的特点

-   情境 1：能力低、承诺高
    -   对自己的任务很陌生，缺乏经验，甚至不了解自己的知识和工作盲区
    -   但有很强的学习意愿，有好奇心并且愿意接受指导，也很自信自己能够学会怎么做
-   情境 2：能力不是很高，承诺很低
    -   有一定的知识和技能，但还有所欠缺
    -   学习意愿很差，随时都有气馁和沮丧的情绪，随时可能准备放弃
-   情境 3：能力处于中上等、承诺很低
    -   对于某个特定的任务来说是有能力也有经验的
    -   不是很自信，偶尔会犹豫不定，觉得自己的任务很无聊，甚至对能否完成任务漠不关心
-   情境 4：能力高、承诺高
    -   有足够的能力，能够胜任工作任务
    -   也非常自信，能鼓舞别人

作为管理者，需要能够识别出 4 种不同的情境，识别出来之后，再匹配不同的领导风格

领导风格在工作中是用领导行为来体现的：

-   指导性行为：告诉其他人应该做什么，何时做，如何做，并经常提供结果反馈
-   支持性行为：鼓励、表扬他人自力更生解决问题，倾听意见，并让他人参与决策

针对每一种情境下的团队成员，应该使用的领导风格：

-   风格 1：指导。高指导行为和低支持行为
    -   通过讲述和展示，具体指导员工如何达成目标，并密切跟踪员工的表现，频繁地进行反馈和指导，让员工能够顺利地完成目标
    -   目的是帮助情境 1 的员工建立起必备的工作技能

-   风格 2：教练。高指导行为和高支持行为
    -   给员工解释工作任务，征求他们的意见，鼓励、引导并持续指导完成目标
    -   目的是重新激发情境 2 的员工的工作热情，提高他们的工作能力
-   风格 3：支持。低指导行为和高支持行为
    -   提出开放式问题来促进问题的解决，通常只是询问员工的做法，不多加干涉，倾听和鼓励员工的工作，引导员工一起参与做决定
    -   目的是激发情境 3 员工的信心
-   风格 4：授权。低指导行为和低支持行为
    -   认可员工的专业知识，鼓励员工的自主性，并邀请员工持续学习和不断创新
    -   目的是珍视员工的贡献，最大限度地发挥员工的潜能

可以通过 3 点用好情境领导力：

1.  设定目标。要运用好目标管理，设立正确的目标，目标的设定要与需要做的事情保持一致
2.  协同诊断。要会评估员工在特定任务上的能力和承诺，判断他们在这个任务上属于哪一种情境
3.  学会匹配。根据员工所处的情境，匹配自己所需要运用的领导风格，帮助他们完成工作任务，也为他们个人提供需要的帮助





