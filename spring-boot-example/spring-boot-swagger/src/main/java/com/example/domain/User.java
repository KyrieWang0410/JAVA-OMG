package com.example.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Kyrie.Wang
 */
@Data
@AllArgsConstructor
public class User {
    @ApiModelProperty(value = "id",hidden = true)
    Long id;
    @ApiModelProperty(value = "姓名")
    String name;
    @ApiModelProperty(value = "年龄")
    Integer age;
}
