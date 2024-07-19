package com.example.exception;


import com.example.base.ResultCodeEnum;
import lombok.Getter;

/**
 * 自定义异常
 *
 * @author Kyrie.Wang
 */
@Getter
public class SystemException extends RuntimeException {

    private final Integer code;

    public SystemException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

}
