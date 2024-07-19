package com.example.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 结果信息枚举
 *
 * @author Kyrie.Wang
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {
    /** 成功 **/
    SUCCESS(true, 20000, "请求成功"),
    /** 接口调用失败 **/
    UNKNOWN_ERROR(false, 30001, "接口调用失败"),
    /** 参数错误 **/
    PARAM_ERROR(false, 30002, "参数错误"),
    /** 空指针异常 **/
    NULL_POINTER(false, 30003, "空指针异常"),

    /** 未登录或token已经过期 **/
    UNAUTHORIZED(false, 41003, "未登录或token已经过期"),
    /** 非法token **/
    ILLEGAL_TOKEN(false, 41004, "非法token"),
    /** token认证失败 **/
    TOKEN_AUTH_FAIL(false, 41005, "token认证失败"),
    /** 禁止访问 **/
    AUTH_FORBIDDEN(false, 41006, "禁止访问"),

    /** 系统内部执行异常 **/
    SYSTEM_EXCEPTION(false, 50000, "系统内部执行异常"),
    /** sql执行异常 **/
    SQL_EXCEPTION(false, 50001, "sql执行异常"),

    ;

    /**
     * 响应是否成功
     */
    private final boolean success;
    /**
     * 响应状态码
     */
    private final int code;
    /**
     * 响应信息
     */
    private final String message;
}
