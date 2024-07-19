package com.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性别枚举
 *
 * @author Kyrie.Wang
 */
@AllArgsConstructor
@Getter
public enum Gender {

    /** 男 */
    M("M", "男"),

    /** 女 */
    F("F", "女");

    private final String key;
    private final String description;


}
