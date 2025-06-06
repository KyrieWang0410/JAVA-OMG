package com.demo.common.exception;

import com.demo.common.response.ResultCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 业务异常（可预见的应用程序异常）
 */
@Getter
@RequiredArgsConstructor
public class BusinessException extends RuntimeException {

    // 业务错误码
    private final int code;

    /**
     * 使用错误枚举创建异常
     */
    public BusinessException(ResultCode resultCode) {
        this(resultCode.getCode(), resultCode.getMsg());
    }

    /**
     * 创建异常（自定义消息）
     */
    public BusinessException(ResultCode resultCode, String message) {
        this(resultCode.getCode(), message);
    }

    /**
     * 完整构造方法（由 Lombok @RequiredArgsConstructor 生成）
     * 但这里我们显式写出来，使逻辑更清晰
     */
    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

}
