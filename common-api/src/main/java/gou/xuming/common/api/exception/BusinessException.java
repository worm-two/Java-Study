package gou.xuming.common.api.exception;

/**
 * @Author: xuming
 * @Date: 2024:10:26 17:08
 * @Version: 1.0
 * @Description: 业务异常
 **/
public class BusinessException extends RuntimeException{


    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }
}
