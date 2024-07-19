<h1 align="center">JAVA OMG</h1>
<p align="center">
<a href='https://gitee.com/JhinShow/JavaOmg/stargazers'><img src='https://gitee.com/JhinShow/JavaOmg/badge/star.svg?theme=dark' alt='star'></img></a>
<a href='https://gitee.com/JhinShow/JavaOmg/members'><img src='https://gitee.com/JhinShow/JavaOmg/badge/fork.svg?theme=dark' alt='fork'></img></a>
</p>

#### 介绍

JAVA OMG 是一个基于 SpringBoot 连载、适用于个人学习研究、测试JAVA生态的项目

#### 项目结构

|           目录            |              模块               |           说明            | 备注                                     |
|:-----------------------:|:-----------------------------:|:-----------------------:|----------------------------------------|
|  **core-base-example**  |                               |                         | JAVA基础                                 |
|                         |       core-base-Lambda        | Lambda 表达式以及 Steam 流的使用 |                                        |
|                         |   core-base-design-pattern    |          设计模式           |                                        |
| **spring-boot-example** |                               |                         | Springboot 知识                          |
|                         |            common             |          公共模块           | 其它模块引用到，如工具类等                          |
|                         |       spring-boot-admin       |       admin 监控平台        | springboot生态的监控平台                      |
|                         |        spring-boot-jpa        |         JPA 的使用         | JPA 整合 SpringBoot                      |
|                         |      spring-boot-mybatis      |       mybatis的使用        | Mybatis 整合 SpringBoot                  |
|                         |   spring-boot-mybatis-plus    |     Mybatis-plus的使用     | Mybatis-plus 整合 SpringBoot             |
|                         |      spring-boot-quartz       |      quartz 任务调度框架      | 定时调度框架                                 |
|                         |       spring-boot-redis       |      redis缓存中间件的使用      | redis 整合 SpringBoot                    |
|                         |  spring-boot-spring-security  |   SpringSecurity 权限框架   |                                        |
|                         | spring-boot-spring_data_redis |      redis缓存中间件的使用      | spring-boot-starter-data-redis 操作Redis |
|                         |      spring-boot-swagger      |         API 文档          | 接口文档                                   |
|                         |        spring-boot-web        |    SpringMVC、常用web功能    | SpringMVC整合                            |

#### 安装与使用

- 执行目录`\sql`下的脚本(基于MySQL 8.0.20)
- IDEA 打开 并加载模块，安装依赖（Maven设置为阿里源）

```xml

<mirrors>
    <mirror>
        <id>aliyunmaven</id>
        <mirrorOf>*</mirrorOf>
        <name>阿里云公共仓库</name>
        <url>https://maven.aliyun.com/repository/public</url>
    </mirror>
</mirrors>
```

- 每个模块单独配置，需使用则修改对应模块下的 `application.yml` 文件
- 在对应模块单元测试中，执行@Test

#### 注意

`common`模块为各个模块公用，剔除该依赖会导致无法运行

