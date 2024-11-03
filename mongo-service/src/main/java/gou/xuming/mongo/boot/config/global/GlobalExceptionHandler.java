package gou.xuming.mongo.boot.config.global;

import gou.xuming.common.api.exception.BusinessException;
import gou.xuming.common.api.exception.CommonException;
import gou.xuming.common.api.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @Author: xuming
 * @Date: 2024:10:26 17:26
 * @Version: 1.0
 * @Description: 全局异常处理
 **/
// 全局异常处理器优先级最高
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Result runtimeException(RuntimeException exception) {
        log.error(exception.getLocalizedMessage(), exception);
        return Result.fail();
    }

    @ExceptionHandler(BusinessException.class)
    public Result businessException(BusinessException exception) {
        log.error(exception.getLocalizedMessage(), exception);
        return Result.fail();
    }

    @ExceptionHandler(CommonException.class)
    public Result commonException(CommonException exception) {
        log.error(exception.getLocalizedMessage(), exception);
        return Result.fail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.error(exception.getLocalizedMessage(), exception);
        return Result.fail();
    }

    /**
     * 处理平铺参数校验失败
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result exceptionHandler(ConstraintViolationException exception) {
        log.warn(exception.getMessage());
        return Result.fail();
    }


}

