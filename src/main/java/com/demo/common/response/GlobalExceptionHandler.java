package com.demo.common.response;

import com.demo.common.exception.BusinessException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Result<?>> handleBusinessException(BusinessException e) {
        log.warn("业务异常: code={}, msg={}", e.getCode(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Result.fail(e.getCode(), e.getMessage()));
    }

    /**
     * 处理参数校验异常（@Validated @RequestBody）
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Result<?>> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        return handleBindingResult(e.getBindingResult());
    }

    /**
     * 处理表单参数绑定异常
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<Result<?>> handleBindException(BindException e) {
        return handleBindingResult(e.getBindingResult());
    }

    /**
     * 统一处理绑定结果错误
     */
    private ResponseEntity<Result<?>> handleBindingResult(BindingResult bindingResult) {
        String message = Optional.of(bindingResult.getFieldErrors())
                .orElse(Collections.emptyList())
                .stream()
                .map(this::formatFieldError)
                .collect(Collectors.joining("; "));

        log.warn("参数校验失败: {}", message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Result.fail(ResultCode.PARAM_ERROR, message));
    }

    /**
     * 格式化字段错误信息
     */
    private String formatFieldError(FieldError error) {
        return String.format("%s: %s", error.getField(),
                Optional.ofNullable(error.getDefaultMessage()).orElse("参数无效"));
    }

    /**
     * 处理参数约束异常（@Validated @RequestParam/PathVariable）
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Result<?>> handleConstraintViolationException(ConstraintViolationException e) {
        String message = Optional.ofNullable(e.getConstraintViolations())
                .orElse(Collections.emptySet())
                .stream()
                .map(this::formatConstraintViolation)
                .collect(Collectors.joining("; "));

        log.warn("参数约束异常: {}", message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Result.fail(ResultCode.PARAM_ERROR, message));
    }

    /**
     * 格式化约束违规信息
     */
    private String formatConstraintViolation(ConstraintViolation<?> violation) {
        String path = violation.getPropertyPath().toString();
        String field = path.contains(".") ? path.substring(path.lastIndexOf('.') + 1) : path;
        return String.format("%s: %s", field, violation.getMessage());
    }

    /**
     * 处理404异常
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Result<?>> handleNoHandlerFoundException(NoHandlerFoundException e) {
        log.warn("资源不存在: {} {}", e.getHttpMethod(), e.getRequestURL());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Result.fail(ResultCode.RESOURCE_NOT_FOUND));
    }

    /**
     * 处理方法不支持异常
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Result<?>> handleMethodNotSupported(HttpRequestMethodNotSupportedException e) {
        String message = null;
        if (e.getSupportedMethods() != null) {
            message = String.format("不支持 %s 方法，请使用 %s",
                    e.getMethod(),
                    String.join(", ", e.getSupportedMethods()));
        }

        log.warn("方法不支持: {}", message);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(Result.fail(ResultCode.METHOD_NOT_ALLOWED, message));
    }

    /**
     * 处理JSON解析异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Result<?>> handleMessageNotReadable(HttpMessageNotReadableException e) {
        String rootCause = e.getRootCause() != null ? e.getRootCause().getMessage() : "未知原因";
        String message = String.format("JSON解析失败: %s", rootCause);

        log.warn("请求体格式错误: {}", message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Result.fail(ResultCode.PARAM_ERROR, message));
    }

    /**
     * 处理参数类型不匹配异常
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Result<?>> handleTypeMismatch(MethodArgumentTypeMismatchException e) {
        String message = String.format("参数 '%s' 需要类型 %s",
                e.getName(),
                e.getRequiredType() != null ? e.getRequiredType().getSimpleName() : "未知");

        log.warn("参数类型错误: {}", message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Result.fail(ResultCode.PARAM_ERROR, message));
    }

    /**
     * 处理请求参数缺失异常
     */
    @ExceptionHandler({
            MissingServletRequestParameterException.class,
            MissingServletRequestPartException.class
    })
    public ResponseEntity<Result<?>> handleMissingParameter(Exception e) {
        String paramName = "";
        if (e instanceof MissingServletRequestParameterException) {
            paramName = ((MissingServletRequestParameterException) e).getParameterName();
        } else if (e instanceof MissingServletRequestPartException) {
            paramName = ((MissingServletRequestPartException) e).getRequestPartName();
        }

        String message = String.format("缺失必要参数: %s", paramName);
        log.warn("参数缺失: {}", message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Result.fail(ResultCode.PARAM_ERROR, message));
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Result<?>> handleDataAccessException(DataAccessException e) {
        log.error("数据库操作异常: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Result.fail(ResultCode.INTERNAL_SERVER_ERROR, "数据库服务异常"));
    }


    /**
     * 处理其他未捕获异常
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result<?>> handleException(Exception e) {
        String rootCause = e.getCause() != null ? e.getCause().getMessage() : e.getMessage();
        log.error("未处理的系统异常: {} - {}", e.getClass().getSimpleName(), rootCause, e);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Result.fail(ResultCode.INTERNAL_SERVER_ERROR));
    }
}
