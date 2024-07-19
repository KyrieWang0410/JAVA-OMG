# 图形化界面 SpringBoot Admin

## 基本使用

### ①创建SpringBoot Admin Server应用

```xml

<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-starter-server</artifactId>
</dependency>
```

### ②@EnableAdminServer注解开启

```java

@SpringBootApplication
@EnableAdminServer
public class AdminAppStarter {
    public static void main(String[] args) {
        SpringApplication.run(AdminAppStarter.class,args);
    }
}
```

### ③配置SpringBoot Admin client应用

```xml
<!--版本参考springboot github项目，SpringBoot并未对此依赖项做版本管理-->
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-starter-client</artifactId>
</dependency>
```

```yaml
spring:
  boot:
    admin:
      client:
        url: http://127.0.0.1:8085 #配置 Admin Server的地址
```

## 相关阅读

https://github.com/codecentric/spring-boot-admin
