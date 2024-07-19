package com.example.common;

import lombok.Data;

/**
 * @author Kyrie.Wang
 */
@Data
public class Result {
    private int code;
    private String msg;
    private Object retData;
}
