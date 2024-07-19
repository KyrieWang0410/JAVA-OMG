package com.example.service.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * UsetDTO
 *
 * @author Kyrie.Wang
 */
@Data
public class UsetDTO implements Serializable {

    @NotBlank(message = "名字不能为空")
    private String name;

    @Min(1L)
    @Max(100L)
    private Long age;
}
