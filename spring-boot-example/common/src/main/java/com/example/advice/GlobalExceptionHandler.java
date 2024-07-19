package com.example.advice;


import cn.hutool.core.exceptions.ExceptionUtil;
import com.example.base.ResponseResult;
import com.example.base.ResultCodeEnum;
import com.example.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;


/**
 * 全局统一异常处理
 *
 * @author Kyrie.Wang
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    static final String EXCEPTION_DESCRIPTION_NAME = "desc";

    /**
     * 通用异常处理方法
     **/
    @ExceptionHandler(Throwable.class)
    public ResponseResult error(Exception e) {
        log.error(ExceptionUtil.stacktraceToString(e));
        return ResponseResult.error().data(EXCEPTION_DESCRIPTION_NAME, e.toString());
    }

    /**
     * 指定异常处理方法(空指针)
     **/
    @ExceptionHandler(NullPointerException.class)
    public ResponseResult error(NullPointerException e) {
        log.error(ExceptionUtil.stacktraceToString(e));
        return ResponseResult.setResult(ResultCodeEnum.NULL_POINTER).data(EXCEPTION_DESCRIPTION_NAME, e.toString());
    }

    /**
     * 参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult error(MethodArgumentNotValidException e) {
        List<ObjectError> allErrors = e
                .getBindingResult()
                .getAllErrors();
        String description = allErrors
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .reduce((x, y) -> x + "," + y)
                .orElseGet(ResultCodeEnum.PARAM_ERROR::getMessage);
        log.error(ExceptionUtil.stacktraceToString(e));
        return ResponseResult.setResult(ResultCodeEnum.PARAM_ERROR).data(EXCEPTION_DESCRIPTION_NAME, description);
    }

    /**
     * sql执行异常
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseResult error(SQLIntegrityConstraintViolationException e) {
        log.error(ExceptionUtil.stacktraceToString(e));
        return ResponseResult.setResult(ResultCodeEnum.SQL_EXCEPTION).data(EXCEPTION_DESCRIPTION_NAME, e.toString());
    }


    /**
     * 自定义定异常处理方法
     **/
    @ExceptionHandler(SystemException.class)
    public ResponseResult error(SystemException e) {
        log.error(ExceptionUtil.stacktraceToString(e));
        return ResponseResult.error().message(e.toString());
    }

}
