package com.example.entity.demodb;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("app_user")
public class AppUser implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String name;
    private Integer gender;
    private Date birthday;
    private String registrationTime;
    private String lastLoginTime;
    private Integer status;
}
