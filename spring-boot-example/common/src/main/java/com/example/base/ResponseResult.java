package com.example.base;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回结果类
 *
 * @author Kyrie.Wang
 */
@Accessors(chain = true)
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseResult {
    /**
     * 响应是否成功
     */
    private Boolean success;

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private Map<String, Object> data = new HashMap<>();

    /**
     * 通用成功
     */
    public static ResponseResult ok() {
        return new ResponseResult().setSuccess(ResultCodeEnum.SUCCESS.isSuccess())
                .setCode(ResultCodeEnum.SUCCESS.getCode())
                .setMessage(ResultCodeEnum.SUCCESS.getMessage());
    }

    /**
     * 通用失败
     */
    public static ResponseResult error() {
        return new ResponseResult().setSuccess(ResultCodeEnum.UNKNOWN_ERROR.isSuccess())
                .setCode(ResultCodeEnum.UNKNOWN_ERROR.getCode())
                .setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
    }

    /**
     * 自定义返回信息
     */
    public static ResponseResult setResult(ResultCodeEnum result) {
        return new ResponseResult().setSuccess(result.isSuccess()).setCode(result.getCode())
                .setMessage(result.getMessage());
    }

    /**
     * 自定义返回数据
     */
    public ResponseResult data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

    /**
     * 通用设置data
     */
    public ResponseResult data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    /**
     * 自定义状态信息
     */
    public ResponseResult message(String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * 自定义状态码
     */
    public ResponseResult code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 自定义返回结果
     */
    public ResponseResult success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

}
