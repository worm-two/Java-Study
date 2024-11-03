package gou.xuming.common.api.result;

import lombok.Getter;

/**
 * @Author: xuming
 * @Date: 2024:10:26 13:53
 * @Version: 1.0
 * @Description: 接口统一返回结果
 **/
public class Result<T> {

    private boolean success;

    private long code;

    private String message;

    @Getter
    private T data;

    @Getter
    private long total;

    @Getter
    private Object other;

    private void setSuccess(boolean success) {
        this.success = success;
    }

    private void setCode(long code) {
        this.code = code;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    private void setData(T data) {
        this.data = data;
    }

    private Result() {
    }

    /**
     * 初始化状态码
     *
     * @param result     结果对象
     * @param resultCode 状态码
     */
    private static <T> void init(Result<T> result, ResultCode resultCode) {
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
    }


    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        init(result, ResultCode.SUCCESS);
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        init(result, ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(T data, String message) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        init(result, ResultCode.SUCCESS);
        result.setData(data);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> fail() {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        init(result, ResultCode.FAILED);
        return result;
    }

    public static <T> Result<T> fail(String message) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        init(result, ResultCode.FAILED);
        result.setMessage(message);
        return result;
    }

    public Result<T> total(long total) {
        this.total = total;
        return this;
    }

    public Result<T> message(String message) {
        this.message = message;
        return this;
    }

    public Result<T> other(Object other) {
        this.other = other;
        return this;
    }

}
