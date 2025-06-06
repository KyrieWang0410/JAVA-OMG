package com.demo.common.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 统一响应体封装
 *
 * @param <T> 响应数据类型
 */
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

    // 时间戳（自动生成）
    private final long timestamp = System.currentTimeMillis();
    // 响应状态码（业务状态码）
    private int code;
    // 响应描述信息
    private String msg;
    // 响应业务数据
    private T data;

    /**
     * 成功响应（无数据）
     */
    public static <T> Result<T> ok() {
        return new Result<T>()
                .setCode(ResultCode.SUCCESS.getCode())
                .setMsg(ResultCode.SUCCESS.getMsg());
    }

    /**
     * 成功响应（有数据）
     *
     * @param data 响应数据
     */
    public static <T> Result<T> ok(T data) {
        return Result.<T>ok()
                .setData(data);
    }

    /**
     * 业务失败响应
     *
     * @param errorCode 错误代码
     */
    public static <T> Result<T> fail(ResultCode errorCode) {
        return new Result<T>()
                .setCode(errorCode.getCode())
                .setMsg(errorCode.getMsg());
    }

    /**
     * 业务失败响应（自定义消息）
     *
     * @param errorCode 错误代码
     * @param customMsg 自定义错误消息
     */
    public static <T> Result<T> fail(ResultCode errorCode, String customMsg) {
        return new Result<T>()
                .setCode(errorCode.getCode())
                .setMsg(customMsg);
    }

    /**
     * 业务失败响应（完整控制）
     *
     * @param code 自定义状态码
     * @param msg  自定义错误消息
     */
    public static <T> Result<T> fail(int code, String msg) {
        return new Result<T>()
                .setCode(code)
                .setMsg(msg);
    }
}
