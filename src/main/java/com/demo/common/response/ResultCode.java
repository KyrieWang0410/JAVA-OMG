package com.demo.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 统一状态码枚举定义
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    /**
     * 操作成功
     */
    SUCCESS(2000, "操作成功"),

    /**
     * 请求参数错误
     */
    PARAM_ERROR(4000, "请求参数错误"),

    /**
     * 认证失败或未登录
     */
    UNAUTHORIZED(4001, "认证失败或未登录"),

    /**
     * 权限不足
     */
    PERMISSION_DENIED(4003, "权限不足"),

    /**
     * 资源不存在
     */
    RESOURCE_NOT_FOUND(4004, "资源不存在"),

    /**
     * 方法不允许
     */
    METHOD_NOT_ALLOWED(4005, "方法不允许"),

    /**
     * 请求超时
     */
    REQUEST_TIMEOUT(4008, "请求超时"),

    /**
     * 系统内部错误
     */
    INTERNAL_SERVER_ERROR(5000, "系统内部错误"),

    /**
     * 服务不可用
     */
    SERVICE_UNAVAILABLE(5003, "服务不可用");

    // 状态码
    private final int code;

    // 默认消息
    private final String msg;

    /**
     * 根据状态码查找对应的枚举
     *
     * @param code 状态码
     * @return 匹配的ResultCode枚举，未找到则返回null
     */
    public static ResultCode fromCode(int code) {
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.getCode() == code) {
                return resultCode;
            }
        }
        return null;
    }
}
