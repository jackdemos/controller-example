package com.taocaicai.common;

import com.taocaicai.exception.BusinessException;
import com.taocaicai.exception.ForbiddenException;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一拦截异常
 *
 * @author Oakley
 * @project controller-example
 * @created 2023-05-16 14:26:14:26
 * @package com.taocaicai.common
 * @since 0.0.1
 */
@RestControllerAdvice(basePackages = "com.taocaicai")
public class ExceptionAdvice {

    /**
     * 处理 {@code BusinessException} 异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({BusinessException.class})
    public Result<?> handleBusinessException(BusinessException ex) {
        return Result.failed(ex.getMessage());
    }

    /**
     * 捕获 {@code ForbiddenException} 异常
     */
    @ExceptionHandler({ForbiddenException.class})
    public Result<?> handleForbiddenException(ForbiddenException ex) {
        return Result.failed(ResultEnum.FORBIDDEN);
    }

    /**
     * {@code @RequestBOdy} 参数校验不能过时抛出异常
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder builder = new StringBuilder("检验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            builder.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append(" , ");
        }
        String msg = builder.toString();
        if (StringUtils.hasText(msg)) {
            return Result.failed(ResultEnum.VALIDATE_FAILED.getCode(), msg);
        }
        return Result.failed(ResultEnum.VALIDATE_FAILED);
    }

    /**
     * 顶层异常处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({Exception.class})
    public Result<?> handle(Exception ex) {
        return Result.failed(ex.getMessage());
    }
}

